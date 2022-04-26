package com.techelevator.dao;

import com.techelevator.model.AdoptionApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcAdoptionDao implements AdoptionDao{

    private final String approved = "approved";
    private final String denied = "denied";
    private final String pending = "pending";
    private JdbcTemplate jdbcTemplate;

    public JdbcAdoptionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<AdoptionApplication> getAllAdoptionApplications(){
        List<AdoptionApplication> allApplications = new ArrayList<>();
        String sql = "SELECT adoption_application_id, adoption_application_pet_id, adopter_email, adopter_phone_number, adopter_name, adoption_status "+
                     "FROM adoption_applications ;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()){
            AdoptionApplication application = mapRowToAdoption(results);
            allApplications.add(application);
        }
        return allApplications;
    }

    public boolean rejectAdoption(Long id){
        String sql = "UPDATE adoption_applications "+
                     "SET adoption_status = ?" +
                     "WHERE adoption_application_id = ?;";
        return jdbcTemplate.update(sql, denied, id) == 1;
    }


    public boolean removeAdoption(Long id) {
        String sql = "DELETE " +
                     "FROM adoption_applications " +
                     "WHERE adoption_application_id = ?;";
        return jdbcTemplate.update(sql,id) == 1;
    }

    public AdoptionApplication getApplicationById(Long id){
        AdoptionApplication application = null;
        String sql = "SELECT adoption_application_id, adoption_application_pet_id, adopter_email, adopter_phone_number, adopter_name, adoption_status " +
                     "FROM adoption_applications "+
                     "WHERE adoption_application_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,id);
        if(results.next()){
            application = mapRowToAdoption(results);
        }
        return application;

    }

    public AdoptionApplication createNewAdoption(AdoptionApplication adoptionApplication){
        AdoptionApplication newAdoptionApplication = null;
        String sql = "INSERT INTO adoption_applications " +
                     "(adoption_application_pet_id, adopter_email, adopter_phone_number, adopter_name, adoption_status) "+
                     "VALUES (?, ?, ?, ?, ?) "+
                     "RETURNING adoption_application_id;";
        Long newId = jdbcTemplate.queryForObject(sql, Long.class, adoptionApplication.getAdoption_pet_id(), adoptionApplication.getAdopter_email(), adoptionApplication.getAdopter_phone_number(), adoptionApplication.getAdopter_name(), "approved");

        if(newId != null){
            newAdoptionApplication = getApplicationById(newId);
        }
        return newAdoptionApplication;
    }

    public boolean approveAdoption(Long id){
        String sql = "UPDATE adoption_applications "+
                     "SET adoption_status = ? " +
                     "WHERE adoption_application_id = ?;";

        return jdbcTemplate.update(sql,"adopted", id) == 1;

    }

    private AdoptionApplication mapRowToAdoption(SqlRowSet rs){
        AdoptionApplication application = new AdoptionApplication();
        application.setAdopter_email(rs.getString("adopter_email"));
        application.setAdopter_name(rs.getString("adopter_name"));
        application.setAdopter_phone_number(rs.getLong("adopter_phone_number"));
        application.setAdoption_id(rs.getLong("adoption_application_id"));
        application.setAdoption_pet_id(rs.getLong("adoption_application_pet_id"));
        application.setAdoption_status(rs.getString("adoption_status"));
        return application;
    }

}
