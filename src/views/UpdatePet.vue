<template>
  <div>
    <header-default />
    <logged-in-navbar />
    <div>
      <h2 class="subheading indiName">{{ pet.petName }}</h2>
    </div>

    <div>
      <form v-on:submit.prevent="submitForm">
        <div class="form-row centerForm">
          <div class="form-group col-md-6">
            <label for="animalName">Animal Name:</label>
            <input
              type="text"
              class="form-control"
              id="animalName"
              placeholder="Spaghetti"
              v-model="pet.petName"
              required
            />
          </div>

          <div class="form-group col-md-6">
            <label for="animalType">Animal Type:</label>
            <input
              type="text"
              class="form-control"
              id="animalType"
              placeholder="Cat/Dog/Other"
              v-model="pet.animalType"
              required
            />
          </div>
        </div>

        <div class="form-row centerForm">
          <div class="form-group col-md-6">
            <label for="animalBreed">Breed:</label>
            <input
              type="text"
              class="form-control"
              id="animalBreed"
              placeholder="Type breed here"
              v-model="pet.petBreed"
              required
            />
          </div>

          <label for="animalGender">Choose a gender:</label>
          <select
            v-model="pet.animalGender"
            id="animalGender"
            name="animalGender"
          >
            <option value="m">Male</option>
            <option value="f">Female</option>
          </select>
        </div>

        <div class="form-row centerForm">
          <div class="form-group col-md-6">
            <label for="animalAge">Age:</label>
            <input
              type="number"
              class="form-control"
              id="animalAge"
              placeholder="How many years old?"
              v-model="pet.age"
              required
            />
          </div>

          <div class="form-group col-md-6">
            <label for="animalDescription">Description</label>
            <input
              type="text"
              class="form-control"
              id="animalDescription"
              placeholder="Insert Description Here..."
              v-model="pet.animalDescription"
            />
          </div>

          <div class="form-group col-md-6">
            <label for="pictureOne">Picture Link</label>
            <input
              type="text"
              class="form-control"
              id="pictureOne"
              placeholder="Insert Link..."
              v-model="pet.pictureOne"
            />
          </div>

          <label for="available">Available Now:</label>
          <select v-model="pet.available" id="available" name="available">
            <option value="true">Yes</option>
            <option value="false">No</option>
          </select>
          <input type="submit" value="Submit" />
        </div>
      </form>
    </div>

    <footer-default />
  </div>
</template>

<script>
import FooterDefault from "../components/FooterDefault.vue";
import HeaderDefault from "../components/HeaderDefault.vue";
import LoggedInNavbar from "../components/LoggedInNavbar.vue";
import petService from "../services/PetService";
export default {
  components: { HeaderDefault, LoggedInNavbar, FooterDefault },
  data() {
    return {
      name: "petinfo",
      pet: {
        animalType: "{{pet.animalType}}",
        animalGender: "{{pet.animalGender",
        petName: "{{pet.petName}}",
        petBreed: "pet.petBreed",
        age: "pet.age",
        animalDescription: "Description Coming Soon",
        available: "",
        pictureOne:
          "https://1.bp.blogspot.com/-AzSTfPrkhSY/WkrdSHwgxkI/AAAAAAAAARI/L_3p6sG_CK8UgGpgXyTRXaKtG9O7KUCWACLcBGAs/s320/unnamed.png",
        petId: "",
      },
    };
  },

  methods: {
    submitForm() {
      const newPet = {
        animalType: this.pet.animalType,
        animalGender: this.pet.animalGender,
        petName: this.pet.petName,
        petBreed: this.pet.petBreed,
        age: parseInt(this.pet.age),
        animalDescription: this.pet.animalDescription,
        available: Boolean(this.pet.available),
        pictureOne: this.pet.pictureOne,
        petId: this.pet.petId,
      };

      if (newPet) {
        petService.updatePet(newPet).then((response) => {
          if (response.status === 200) {
            this.$router.push("/EditPets");
          }
        });
      }
    },
  },

  created() {
    petService.getPetById(this.$route.params.id).then((response) => {
      this.pet = response.data;
    });
  },
};
</script>

<style>
</style>