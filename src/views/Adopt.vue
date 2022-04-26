<template>
  <div>
    <header-default />
    <navbar />
    <h2 class="subheading">Adopt a Pet Applicant Form</h2>

     <form v-on:submit.prevent="submitForm" class="ApplyToVolunteer">
       <div class="d-flex adopt-form">
            <div class="form-group col-md-6">
              <label for="adopterEmail">Email</label>
              <input
                type="email"
                class="form-control"
                id="adopterEmail"
                placeholder="Joe@RescueRanch.com"
                 v-model="AdoptionApplication.adopterEmail"
                required
              />
            </div>

             <div class="form-group col-md-6 ">
              <label for="adopterPhoneNumber">Phone Number (10 Digits)</label>
              <input
                type="tel"
                class="form-control"
                id="inputPhone"
                 v-model="AdoptionApplication.adopterPhoneNumber"
                placeholder="9194445555"
                :maxlength="10"
                pattern="[1-9]{1}[0-9]{9}"
                required
              />
            </div>

          <div class="form-group col-md-6">
            <label for="adopterName">Your Name</label>
            <input
              type="text"
              class="form-control"
              id="adopterName"
              placeholder="Name"
               v-model="AdoptionApplication.adopterName"
              required
            />
          </div>
          <div class="submit-btn">
        <input type="submit" value="Submit" />
          </div>
        </div>
      </form>
    <footer-default />
  </div>
</template>

<script>
import FooterDefault from '../components/FooterDefault.vue';
import HeaderDefault from "../components/HeaderDefault.vue";
import Navbar from "../components/Navbar.vue";
import petService from "../services/PetService";

export default {
  name: "Adopt",

   data() {
    return {
        pet: {},
        AdoptionApplication: {},
    };
  },

 components: { HeaderDefault, Navbar, FooterDefault },

  methods: {
    submitForm() {
      const newApplicant = {
        adoption_pet_id: parseInt(this.pet.petId),
        adopter_email: this.AdoptionApplication.adopterEmail,
        adopter_phone_number: parseInt(this.AdoptionApplication.adopterPhoneNumber),
        adopter_name: this.AdoptionApplication.adopterName,
        application_status: this.AdoptionApplication.applicationStatus
  };

    if (newApplicant) {
        petService
          .applyToAdopt(newApplicant)
          .then(response => {
            if (response.status === 200) {
              this.$router.push('/thankadopt');
            }
          });
    }
    }
  },

 created() {
    petService.getPetById(this.$route.params.id).then((response) => {
      this.pet = response.data;
    });
   }
  };
 


</script>

<style>
.adopt-form {
  flex-direction: column;
  align-items: center;
}

.submit-btn {
  padding-bottom: 10px;
}
</style>