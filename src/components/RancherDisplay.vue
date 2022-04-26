<template>

  <div>
      <div class="row adopt">
        <div class="col-12 volunteer">
        <!--  <img :src="pet.pictureOne" alt="" srcset="" class="img-fluid" /> -->
          <h3 class="subRedding">{{ user.fullname }}</h3>
          <p class="vol-info">Email: {{ user.email }}</p>
          <p class="vol-info">Phone: {{ user.phoneNumber }}</p>
        </div>
      </div>
  </div>

</template>

<script>
export default {
props: [
  'user'
]
}
</script>

<style>

.volunteer {
  color: black;
}

.vol-info {
  color: black;
}

</style>