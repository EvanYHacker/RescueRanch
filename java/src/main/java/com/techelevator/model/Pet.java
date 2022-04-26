package com.techelevator.model;

import java.util.List;

public class Pet {
    private Long petId;
    private String animalType;
    private String animalGender;
    private String petName;
    private String petBreed;
    private Integer age;
    private String animalDescription;
    private Boolean available;
    private String pictureOne;
    private String pictureTwo;
    private String pictureThree;

    public Pet(long petId, String animalType, String animalGender, String petName, String petBreed, int age, String animalDescription, boolean available, String pictureOne){
        this.petId = petId;
        this.animalType = animalType;
        this.animalGender = animalGender;
        this.petName = petName;
        this.petBreed = petBreed;
        this.age = age;
        this.animalDescription = animalDescription;
        this.available = available;
        this.pictureOne = pictureOne;
        this.pictureTwo = null;
        this.pictureThree = null;
    }
    public Pet(String animalType, String animalGender, String petName, String petBreed, int age, String animalDescription, boolean available, String pictureOne){
        this.animalType = animalType;
        this.animalGender = animalGender;
        this.petName = petName;
        this.petBreed = petBreed;
        this.age = age;
        this.animalDescription = animalDescription;
        this.available = available;
        this.pictureOne = pictureOne;
        this.pictureTwo = null;
        this.pictureThree = null;
    }
    public Pet(long petId, String animalType, String animalGender, String petName, String petBreed, int age, String animalDescription, boolean available, String pictureOne, String pictureTwo, String pictureThree){
        this.petId = petId;
        this.animalType = animalType;
        this.animalGender = animalGender;
        this.petName = petName;
        this.petBreed = petBreed;
        this.age = age;
        this.animalDescription = animalDescription;
        this.available = available;
        this.pictureOne = pictureOne;
        this.pictureTwo = pictureTwo;
        this.pictureThree = pictureThree;
    }
    public Pet(String animalType, String animalGender, String petName, String petBreed, int age, String animalDescription, boolean available, String pictureOne, String pictureTwo, String pictureThree){
        this.animalType = animalType;
        this.animalGender = animalGender;
        this.petName = petName;
        this.petBreed = petBreed;
        this.age = age;
        this.animalDescription = animalDescription;
        this.available = available;
        this.pictureOne = pictureOne;
        this.pictureTwo = pictureTwo;
        this.pictureThree = pictureThree;
    }
    public Pet(){

    }

    public Boolean getAvailable() {
        return available;
    }

    public String getAnimalGender() {
        return animalGender;
    }

    public Integer getAge() {
        return age;
    }

    public Long getPetId() {
        return petId;
    }

    public String getAnimalDescription() {
        return animalDescription;
    }

    public String getAnimalType() {
        return animalType;
    }

    public String getPetBreed() {
        return petBreed;
    }

    public String getPetName() {
        return petName;
    }

    public String getPictureOne() {
        return pictureOne;
    }

    public String getPictureThree() {
        return pictureThree;
    }

    public String getPictureTwo() {
        return pictureTwo;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setAnimalDescription(String animalDescription) {
        this.animalDescription = animalDescription;
    }

    public void setAnimalGender(String animalGender) {
        this.animalGender = animalGender;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public void setPictureOne(String pictureOne) {
        this.pictureOne = pictureOne;
    }

    public void setPictureThree(String pictureThree) {
        this.pictureThree = pictureThree;
    }

    public void setPictureTwo(String pictureTwo) {
        this.pictureTwo = pictureTwo;
    }
}
