<template>
  <div>
    <header-default />
    <logged-in-navbar />
    <div class="mission">
      <h2 class="subheading">Manage Pet Profiles</h2>
    </div>
    <edit-pet-display />
    
  </div>
</template>

<script>
import HeaderDefault from "../components/HeaderDefault.vue";
import LoggedInNavbar from "../components/LoggedInNavbar.vue";
import EditPetDisplay from '../components/EditPetDisplay.vue';
import petService from "../services/PetService";
export default {
  components: { HeaderDefault, LoggedInNavbar, EditPetDisplay },
   data() {
    return {
      pets: [],
    };
  },
  created() {
    petService.getAllPets().then((response) => {
      this.pets = response.data;
    });
  }
};
</script>

<style>
</style>