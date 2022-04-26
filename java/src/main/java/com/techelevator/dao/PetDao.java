package com.techelevator.dao;
import com.techelevator.model.Pet;

import java.util.*;

public interface PetDao {
    public List<Pet> findAll();
    public List<Pet> findAllDogs();
    public List<Pet> findAllCats();
    public List<Pet> findAllOtherAnimals();
    public List<Pet> getSearchResults(String input);
    public Pet addPet(Pet pet);
    public Pet updatePet(Pet pet);
    public boolean removePet(Long id);
    public Pet getPetById(Long id);
    public List<Pet> getAllAdoptedPets();
}
