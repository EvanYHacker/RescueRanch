<template>
  <div>
    <header-default />
    <navbar class="sticky-top"/> 
    <div class="mission">
      <h2 class="subheading">Your New Best Friend!</h2>
    </div>
 <div class="container-fluid">
    <div class="row adopt">
     <pet-display
      class="pet d-flex justify-content-space-evenly redback"
      v-for="pet in pets"
      v-bind:key="pet.petId"
      v-bind:pet="pet"
    />
    </div>
 </div>
    <footer-default />
  </div>
</template>

<script>
import HeaderDefault from "../components/HeaderDefault";
import petService from "../services/PetService";
import PetDisplay from '../components/PetDisplay.vue'
import Navbar from '../components/Navbar.vue'
import FooterDefault from "../components/FooterDefault";

export default {
  components: { HeaderDefault, PetDisplay, Navbar, FooterDefault},
  data() {
    return {
      pets: [],
    };
  },

  created() {
    petService.getCats().then((response) => {
      this.pets = response.data;
    });

   // this.$store.commit("Cats");
   // this.$router.push("/Cats");
  },
};
</script>

<style>
</style>