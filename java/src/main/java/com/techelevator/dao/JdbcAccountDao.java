package com.techelevator.dao;

import com.techelevator.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcAccountDao implements AccountDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean promoteUser(Long id){
        String sql = "UPDATE users " +
                     "SET role = ? " +
                     "WHERE user_id = ?;";

        return jdbcTemplate.update(sql,"ROLE_ADMIN",id) == 1;
    }

    public boolean removeUser(Long id){
        String sql = "DELETE " +
                     "FROM users "+
                     "WHERE user_id = ?;";
        return jdbcTemplate.update(sql,id) == 1;
    }

    public List<Account> getAllRanchers(){
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT applicant_id, username, password_hash, full_name, email, phone_number " +
                     "FROM applicants " +
                     "LEFT OUTER JOIN accounts ON applicants.applicant_id = accounts.previous_id " +
                     "WHERE accounts.previous_id IS NOT NULL";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Account account = mapRowToAccount(results);
            accounts.add(account);
        }
        return accounts;
    }

    @Override
    public boolean acceptApplicant(Long id) {
        Account account = getApplicantById(id);

        String sql1 = "insert into users (username,password_hash,role) values(?, ?, ?) " +
                      "RETURNING user_id;";

        Long anotherLong = jdbcTemplate.queryForObject(sql1, Long.class, account.getUsername(), account.getPassword_hash(), "ROLE_USER");


        String sql2 = "INSERT INTO accounts " +
                     "(previous_id, aUser_id) " +
                     "VALUES (?, ?) " +
                     "RETURNING account_id;";

        Long aLong = jdbcTemplate.queryForObject(sql2,Long.class, id,anotherLong);

        if(aLong != null && anotherLong != null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean denyApplicant(Long id) {
        String sql = "DELETE " +
                     "FROM applicants " +
                     "WHERE applicant_id = ?;";
        return jdbcTemplate.update(sql,id) == 1;
    }

    @Override
    public Account getApplicantById(Long id) {
        Account account = null;
        String sql = "SELECT applicant_id, username, password_hash, full_name, email, phone_number "+
                     "FROM applicants "+
                     "WHERE applicant_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,id);
        if(results.next()){
            account = mapRowToAccount(results);
        }
        return account;
    }

    public Account createApplicant(Account account){


        Account createdApplicant = null;
        String sql = "INSERT INTO applicants (username, password_hash, full_name, email, phone_number) " +
                     "VALUES (?, ?, ?, ?, ?) " +
                     "RETURNING applicant_id;";
        Long newApplicantId = jdbcTemplate.queryForObject(sql,Long.class,account.getUsername(), hashPassWord(account.getPassword_hash()), account.getFullname(), account.getEmail(), account.getPhoneNumber());
        createdApplicant = getAccount(newApplicantId);

        return createdApplicant;
    }

    public Account getAccount(Long accountId){
        Account account = null;

        String sql = "SELECT applicant_id, username, password_hash, full_name, email, phone_number " +
                     "FROM applicants " +
                     "WHERE applicant_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,accountId);
        if(results.next()){
            account = mapRowToAccount(results);
        }
        return account;
    }

    public List<Account> getApplicants(){
        List<Account> applicants = new ArrayList<>();

        String sql = "SELECT applicant_id, username, password_hash, full_name, email, phone_number " +
                     "FROM applicants " +
                     "LEFT OUTER JOIN accounts ON applicants.applicant_id = accounts.previous_id " +
                     "WHERE accounts.previous_id IS NULL";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Account account = mapRowToAccount(results);
            applicants.add(account);
        }

        return applicants;
    }

    private String hashPassWord(String password){
        return new BCryptPasswordEncoder().encode(password);
    }


    private Account mapRowToAccount(SqlRowSet rs){
        Account account = new Account();
        account.setId(rs.getLong("applicant_id"));
        account.setEmail(rs.getString("email"));
        account.setFullname(rs.getString("full_name"));
        account.setPassword_hash(rs.getString("password_hash"));
        account.setPhoneNumber(rs.getLong("phone_number"));
        account.setUsername(rs.getString("username"));
        return account;
    }

}
