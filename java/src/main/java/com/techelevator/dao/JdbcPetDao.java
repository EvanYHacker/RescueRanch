package com.techelevator.dao;


import com.techelevator.model.Pet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JdbcPetDao implements PetDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcPetDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pet> getAllAdoptedPets(){
        List<Pet> adoptedPets = new ArrayList<>();
        String sql = "SELECT DISTINCT pet_id, animal_type, gender, pet_name, breed, age, description, available, picture_one, picture_two, picture_three " +
                     "FROM pets " +
                     "LEFT OUTER JOIN adoption_applications ON pets.pet_id = adoption_applications.adoption_application_pet_id " +
                     "WHERE pet_id IN (SELECT adoption_applications.adoption_application_pet_id FROM adoption_applications WHERE adoption_applications.adoption_status ILIKE '%approved%');";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Pet pet = mapRowToPet(results);
            adoptedPets.add(pet);
        }
        return adoptedPets;
    }

    public boolean removePet(Long id){
        String sql = "DELETE " +
                     "FROM pets " +
                     "WHERE pet_id = ?;";
        return jdbcTemplate.update(sql,id) == 1;
    }

    public Pet updatePet(Pet pet){
        Pet newPet = null;
        String sql = "UPDATE pets "+
                     "SET animal_type = ?, gender = ?, pet_name = ?, breed = ?, age = ?, description = ?, available = ?, picture_one = ?, picture_two = ?, picture_three = ? " +
                     "WHERE pet_id = ?; ";

        boolean updated = jdbcTemplate.update(sql,pet.getAnimalType(), pet.getAnimalGender(), pet.getPetName(), pet.getPetBreed(), pet.getAge(), pet.getAnimalDescription(), pet.getAvailable(), pet.getPictureOne(), pet.getPictureTwo(), pet.getPictureThree(), pet.getPetId()) == 1;
        if(updated){
            newPet = getPetById(pet.getPetId());
        }
        return newPet;
    }

    public Pet addPet(Pet pet){
        Pet pet1 = null;
        String sql = "INSERT INTO pets (animal_type, gender, pet_name, breed, age, description, available, picture_one, picture_two, picture_three) "+
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " +
                     "RETURNING pet_id;";
        Long newPetId = jdbcTemplate.queryForObject(sql, Long.class, pet.getAnimalType(), pet.getAnimalGender(), pet.getPetName(), pet.getPetBreed(), pet.getAge(), pet.getAnimalDescription(), pet.getAvailable(), pet.getPictureOne(), pet.getPictureTwo(), pet.getPictureThree());

        pet1 = getPetById(newPetId);

        return pet1;
    }

    public Pet getPetById(Long petId){
        Pet pet = null;

        String sql = "SELECT pet_id, animal_type, gender, pet_name, breed, age, description, available, picture_one, picture_two, picture_three " +
                     "FROM pets WHERE pet_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,petId);

        if(results.next()){
            pet = mapRowToPet(results);
        }

        return pet;
    }

    public List<Pet> findAll(){
        List<Pet> allPets = new ArrayList<>();
        String sql = "SELECT DISTINCT pet_id, animal_type, gender, pet_name, breed, age, description, available, picture_one, picture_two, picture_three " +
                     "FROM pets "+
                     "LEFT OUTER JOIN adoption_applications ON pets.pet_id = adoption_applications.adoption_application_pet_id " +
                     "WHERE pet_id NOT IN (SELECT adoption_applications.adoption_application_pet_id FROM adoption_applications WHERE adoption_applications.adoption_status ILIKE '%approved%');";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Pet pet = mapRowToPet(results);
            allPets.add(pet);
        }
        return allPets;

    }

    public List<Pet> findAllDogs(){
        List<Pet> dogs = new ArrayList<>();
        String sql = "SELECT DISTINCT pet_id, animal_type, gender, pet_name, breed, age, description, available, picture_one, picture_two, picture_three " +
                     "FROM pets " +
                     "LEFT OUTER JOIN adoption_applications ON pets.pet_id = adoption_applications.adoption_application_pet_id " +
                     "WHERE animal_type ILIKE '%dog%' AND pet_id NOT IN (SELECT adoption_applications.adoption_application_pet_id FROM adoption_applications WHERE adoption_applications.adoption_status ILIKE '%approved%');";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Pet pet = mapRowToPet(results);
            dogs.add(pet);
        }
        return dogs;
    }

    public List<Pet> findAllCats(){
        List<Pet> cats = new ArrayList<>();
        String sql = "SELECT DISTINCT pet_id, animal_type, gender, pet_name, breed, age, description, available, picture_one, picture_two, picture_three " +
                     "FROM pets " +
                     "LEFT OUTER JOIN adoption_applications ON pets.pet_id = adoption_applications.adoption_application_pet_id " +
                     "WHERE animal_type ILIKE '%cat%' AND pet_id NOT IN (SELECT adoption_applications.adoption_application_pet_id FROM adoption_applications WHERE adoption_applications.adoption_status ILIKE '%approved%');";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Pet pet = mapRowToPet(results);
            cats.add(pet);
        }
        return cats;
    }

    public List<Pet> findAllOtherAnimals(){
        List<Pet> otherAnimals = new ArrayList<>();
        String sql = "SELECT DISTINCT pet_id, animal_type, gender, pet_name, breed, age, description, available, picture_one, picture_two, picture_three " +
                     "FROM pets " +
                     "LEFT OUTER JOIN adoption_applications ON pets.pet_id = adoption_applications.adoption_application_pet_id " +
                     "WHERE animal_type NOT ILIKE '%cat%' AND animal_type NOT ILIKE '%dog%' AND pet_id NOT IN (SELECT adoption_applications.adoption_application_pet_id FROM adoption_applications WHERE adoption_applications.adoption_status ILIKE '%approved%');";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Pet pet = mapRowToPet(results);
            otherAnimals.add(pet);
        }
        return otherAnimals;
    }

    public List<Pet> getSearchResults(String input){
        List<Pet> searchResults = new ArrayList<>();
        String sql = "SELECT pet_id, animal_type, gender, pet_name, breed, age, description, available, picture_one, picture_two, picture_three "+
                     "FROM pets " +
                     "LEFT OUTER JOIN adoption_applications ON pets.pet_id = adoption_applications.adoption_application_pet_id " +
                     "WHERE (animal_type ILIKE ? OR pet_name ILIKE ? OR breed ILIKE ? OR description ILIKE ?) AND pet_id NOT IN (SELECT adoption_applications.adoption_application_pet_id FROM adoption_applications WHERE adoption_applications.adoption_status ILIKE '%approved%');";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,"%"+input+"%","%"+input+"%","%"+input+"%","%"+input+"%");

        while(results.next()){
            Pet pet = mapRowToPet(results);
            searchResults.add(pet);
        }


        return sortSearchResults(searchResults, input);
    }

    private List<Pet> sortSearchResults(List<Pet> pets, String query){
        List<Pet> name = new ArrayList<>();
        List<Pet> breed = new ArrayList<>();
        List<Pet> animalType = new ArrayList<>();
        List<Pet> rest = new ArrayList<>();
        for(Pet pet: pets){
            if(pet.getPetName().toLowerCase(Locale.ROOT).contains(query.toLowerCase(Locale.ROOT))){
                name.add(pet);
            }else if(pet.getPetBreed().toLowerCase(Locale.ROOT).contains(query.toLowerCase(Locale.ROOT))){
                breed.add(pet);
            }else if(pet.getAnimalType().toLowerCase(Locale.ROOT).contains(query.toLowerCase(Locale.ROOT))){
                animalType.add(pet);
            }else{
                rest.add(pet);
            }
        }
        animalType.addAll(breed);
        animalType.addAll(name);
        animalType.addAll(rest);
        return animalType;
    }

    public Pet mapRowToPet(SqlRowSet rs){
        Pet pet = new Pet();
        pet.setPetId(rs.getLong("pet_id"));
        pet.setAnimalType(rs.getString("animal_type"));
        pet.setAnimalGender(rs.getString("gender"));
        pet.setPetName(rs.getString("pet_name"));
        pet.setPetBreed(rs.getString("breed"));
        pet.setAge(rs.getInt("age"));
        pet.setAnimalDescription(rs.getString("description"));
        pet.setAvailable(rs.getBoolean("available"));
        pet.setPictureOne(rs.getString("picture_one"));
        pet.setPictureTwo(rs.getString("picture_two"));
        pet.setPictureThree(rs.getString("picture_three"));
        return pet;
    }
}
