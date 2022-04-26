<template>
  <div class="container-fluid">
    <div class="row adopt">
      <div
        class="pet d-flex redback col-3 adoptable viewFix"
        v-for="pet in pets"
        v-bind:key="pet.petId"
        v-bind:pet="pet"
      >
        <img
          :src="pet.pictureOne"
          alt=""
          srcset=""
          class="img-fluid petImage"
        />

        <h2 class="subyellow">{{ pet.petName }}</h2>
        <p>{{ pet.animalDescription }}</p>
        <p>Animal Type: {{ pet.animalType }}</p>
        <p>Sex: {{ pet.animalGender }}</p>
        <p>Breed: {{ pet.petBreed }}</p>
        <p>Age: {{ pet.age }}</p>
        <p>Available: Yes</p>
        <div class="d-flex holdBtn">
          <div class="view-btn">
            <router-link
              class="btn btn-outline"
              v-bind:to="{ name: 'updatepet', params: { id: pet.petId } }"
              tag="button"
            >
              Edit {{ pet.petName }}'s Page
            </router-link>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import petService from "../services/PetService";
export default {
  data() {
    return {
      pets: [],
    };
  },
  created() {
    petService.getAllPets().then((response) => {
      this.pets = response.data;
    });
  },
};
</script>

<style>
.btn-outline {
  border: 2px solid rgb(255, 255, 230);
  color: rgb(155, 34, 38);
  background-color: rgb(255, 255, 230);
}

.btn-outline:hover {
  border: 2px solid rgb(255, 255, 230);
  color: rgb(255, 255, 230);
  background-color: rgb(155, 34, 38);
}

.viewFix {
  flex-direction: column;
  align-items: center;
  border-radius: 25px;
  border: 10px solid rgb(255, 255, 230);
}

.col-3 > p {
  margin: 1px 0px 1px 0px;
  text-transform: capitalize;
  font-weight: bold;
  font-size: 20px;
}

.col-3 > img {
  border-radius: 100%;
  border: 3px solid rgb(255, 255, 230);
}
</style>