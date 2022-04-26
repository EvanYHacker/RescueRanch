package com.techelevator.dao;

import com.techelevator.model.AdoptionApplication;

import java.util.List;

public interface AdoptionDao {

    public AdoptionApplication createNewAdoption(AdoptionApplication adoptionApplication);
    public boolean approveAdoption(Long id);
    public AdoptionApplication getApplicationById(Long id);
    public boolean removeAdoption(Long id);
    public List<AdoptionApplication> getAllAdoptionApplications();
    public boolean rejectAdoption(Long id);
}
