<template>
  <div>
    <header-default />
    <navbar class="sticky-top" />

    <div class="mission">
      <h2 class="subheading">Your New Best Friend!</h2>
    </div>

    <div class="container-fluid">
      <div class="row adopt">
        <pet-display
          class="pet d-flex redback"
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
import PetDisplay from "../components/PetDisplay.vue";
import petService from "../services/PetService";
import Navbar from "../components/Navbar";
import FooterDefault from "../components/FooterDefault";
export default {
  components: { HeaderDefault, PetDisplay, Navbar, FooterDefault },
  data() {
    return {
      pets: [],
    };
  },

  created() {
    petService.getDogs().then((response) => {
      this.pets = response.data;
    });
  },
};
</script>

<style>
</style>