package com.techelevator.model;

public class AdoptionApplication {

    private Long adoption_id;
    private Long adoption_pet_id;
    private String adopter_email;
    private Long adopter_phone_number;
    private String adopter_name;
    private String adoption_status;

    public AdoptionApplication(){

    }

    public AdoptionApplication(Long adoptionId, Long adoptionPetId, String adopterEmail, Long adopterPhoneNumber, String adopterName, String applicationStatus){
        this.adoption_id = adoptionId;
        this.adoption_pet_id = adoptionPetId;
        this.adopter_email = adopterEmail;
        this.adopter_phone_number = adopterPhoneNumber;
        this.adopter_name = adopterName;
        this.adoption_status = applicationStatus;
    }

    public Long getAdopter_phone_number() {
        return adopter_phone_number;
    }

    public Long getAdoption_id() {
        return adoption_id;
    }

    public Long getAdoption_pet_id() {
        return adoption_pet_id;
    }

    public String getAdopter_email() {
        return adopter_email;
    }

    public String getAdopter_name() {
        return adopter_name;
    }

    public String getAdoption_status() {
        return adoption_status;
    }

    public void setAdopter_email(String adopter_email) {
        this.adopter_email = adopter_email;
    }

    public void setAdopter_name(String adopter_name) {
        this.adopter_name = adopter_name;
    }

    public void setAdopter_phone_number(Long adopter_phone_number) {
        this.adopter_phone_number = adopter_phone_number;
    }

    public void setAdoption_id(Long adoption_id) {
        this.adoption_id = adoption_id;
    }

    public void setAdoption_pet_id(Long adoption_pet_id) {
        this.adoption_pet_id = adoption_pet_id;
    }

    public void setAdoption_status(String adoption_status) {
        this.adoption_status = adoption_status;
    }
}
