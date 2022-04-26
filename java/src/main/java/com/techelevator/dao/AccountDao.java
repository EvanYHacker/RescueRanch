package com.techelevator.dao;

import com.techelevator.model.Account;

import java.util.List;

public interface AccountDao {
    Account createApplicant(Account account);
    Account getAccount(Long id);
    List<Account> getApplicants();
    Account getApplicantById(Long id);
    boolean acceptApplicant(Long id);
    boolean denyApplicant(Long id);
    List<Account> getAllRanchers();
    boolean removeUser(Long id);
    boolean promoteUser(Long id);
}
