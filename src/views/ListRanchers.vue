<template>
  <div>
    <header-default />
    <logged-in-navbar class="sticky-top" />

    <div class="mission">
      <h2 class="subheading">The Rescue Ranchers</h2>
    </div>
    <div class="">
      <div class="">
      <div class="applicant-box">
        <rancher-display
          class="applicant"
          v-for="user in users"
          v-bind:key="user.userId"
          v-bind:user="user"
        />
      </div>
      </div>
      </div>
      <footer-default />
    </div>
</template>

<script>
import RancherService from "../services/RancherService";
import RancherDisplay from "../components/RancherDisplay.vue";
import HeaderDefault from "../components/HeaderDefault.vue";
import FooterDefault from "../components/FooterDefault";
import LoggedInNavbar from '../components/LoggedInNavbar.vue';

export default {
  components: { RancherDisplay, HeaderDefault, FooterDefault, LoggedInNavbar },
  data() {
    return {
      users: [],
    };
  },
  created() {
    RancherService.getAllRanchers().then((response) => {
      this.users = response.data;
    });
  },
};
</script>

<style>
.adoptable > p {
  color: rgb(255, 255, 230);
}

.adoptable > img {
  margin-top: 10px;
  width: 33%;
}

.volunteer > p {
  color: rgb(155, 34, 38);
}
</style>