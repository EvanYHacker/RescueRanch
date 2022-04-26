<template>
  
      <div class="pet d-flex redback col-4 adoptable viewFix">
        <img
          :src="pet.pictureOne"
          alt=""
          srcset=""
          class="img-fluid petImage"
        />

        <h2 class="subyellow">{{ pet.petName }}</h2>
        <p>{{ pet.animalDescription }}</p>
        <p>Sex: {{ pet.animalGender }}</p>
        <p>Breed: {{ pet.petBreed }}</p>
        <p>Age: {{ pet.age }}</p>
        <div class="d-flex holdBtn">
          <div class="view-btn">
            <router-link class="btn btn-outline"
              v-bind:to="{ name: 'petinfo', params: { id: pet.petId } }"
            tag="button">
              About {{ pet.petName }}
            </router-link>
          </div>
        </div>
      </div>
  
 
</template>

<script>
export default {
  props: ["pet"],
};
</script>

<style>

.holdBtn {
  justify-content: center;
  align-items: center;
}
.view-btn {
  margin-right: 5px;
  margin-left: 5px;
}

.col-4 > p {
  margin: 1px 0px 1px 0px;
  text-transform: capitalize;
  font-weight: bold;
  font-size: 20px;
}

.col-4 > img {
  border-radius: 100%;
  border: 3px solid rgb(255, 255, 230);
}
</style>