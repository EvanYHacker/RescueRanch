<template>
  <div id="board">
    <header-default />
    <navbar class="sticky-top"/>
    <vue-firework />

    <div>

    <div class="mission">
      <h2 class="subheading">Adopted Pets!</h2>
    </div>

    <div class="container-fluid">
      <div class="row adopt celebrate">
        <pet-display
          class="pet d-flex redback"
          v-for="pet in pets"
          v-bind:key="pet.petId"
          v-bind:pet="pet"
        />
      </div>

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
import VueFirework from 'vue-firework';
export default {
  components: { HeaderDefault, PetDisplay, Navbar, FooterDefault, VueFirework },
  data() {
    return {
      pets: [],
    };
  },

  created() {
    petService.adoptedPets().then((response) => {
      this.pets = response.data;
    });
  },
};

</script>

<style>

</style>