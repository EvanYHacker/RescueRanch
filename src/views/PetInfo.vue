<template>
  <div>
    <header-default />
    <navbar />
    <div>
      <h2 class="subheading indiName">{{ pet.petName }}</h2>
    </div>
    <div class="row adopt">
      <div class="col-12 redback adoptable">
        <img
          :src="pet.pictureOne"
          alt=""
          srcset=""
          class="img-fluid petImage indi"
        />
        <p>{{ pet.animalDescription }}</p>
        <p>Sex: {{ pet.animalGender }}</p>
        <p>Breed: {{ pet.petBreed }}</p>
        <p>Age: {{ pet.age }}</p>
         <div class="d-flex holdBtn">
          <div class="view-btn">
            <router-link class="btn btn-outline"
              v-bind:to="{ name: 'adopt', params: { id: pet.petId } }"
            tag="button">
              Adopt {{ pet.petName }}
            </router-link>
          </div>
        </div>
      </div>
    </div>
    <footer-default />
  </div>
</template>

<script>
import FooterDefault from "../components/FooterDefault.vue";
import HeaderDefault from "../components/HeaderDefault.vue";
import Navbar from "../components/Navbar.vue";
import petService from "../services/PetService";
export default {
  components: { HeaderDefault, Navbar, FooterDefault },
  data() {
    return {
      name: "petinfo",
      pet: {},
    };
  },

  created() {
    petService.getPetById(this.$route.params.id).then((response) => {
      this.pet = response.data;
    });
  },
};
</script>

<style>
.indi {
  margin-top: 20px !important;
  margin-bottom: 20px !important;
}

.indiName {
  font-size: 5em;
}
</style>