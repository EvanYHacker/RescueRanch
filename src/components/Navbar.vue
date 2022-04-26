<template>
  <div>
    <b-navbar
      type="dark"
      id="nav"
      role="navigation"
      class="
        navbar
        bd-navbar
        flex-column flex-md-row
        navbar-expand
        nav-item
        sticky-top
        navbar-custom
      "
    >
      <b-navbar-nav class="d-flex justify-content-center">
        <b-nav-item
          class="nav-item justify-content-end navbar-item yunderline smarthome"
        >
          <router-link
            class="smarthome"
            v-bind:to="{ name: 'home' }"
            v-if="$store.state.token.length == 0"
            ><div class="smarthome">Home</div></router-link
          >&nbsp;&nbsp;
          <router-link
            class="smarthome"
            v-bind:to="{ name: 'loggedinhome' }"
            v-if="$store.state.token.length > 1"
            >Home</router-link
          >
        </b-nav-item>

        <b-nav-item-dropdown text="Adopt" right class="nav-item">
          <b-dropdown-item href="/AllPets">See All Animals</b-dropdown-item>
          <b-dropdown-item href="/Cats">Cats and Kittens</b-dropdown-item>
          <b-dropdown-item href="/Dogs">Dogs and Puppies</b-dropdown-item>
          <b-dropdown-item href="/Others">Other Animals</b-dropdown-item>
          <b-dropdown-item href="/AdoptedPets">Adopted Pets!</b-dropdown-item>
        </b-nav-item-dropdown>

        <b-nav-item-dropdown text="Volunteer" right>
          <b-dropdown-item href="/ApplyToVolunteer"
            >Join The Team</b-dropdown-item
          >
          <b-dropdown-item href="/MeetTheTeam">Meet The Team</b-dropdown-item>
        </b-nav-item-dropdown>

        <b-nav-item class="mr-auto navbar-item" href="/#A">About Us</b-nav-item>

        <a class="nav-link navbar-item" href="/dono"
          ><i class="fa fa-heart"></i> Donate<span class="sr-only"
            >(current)</span
          ></a
        >

        <b-navbar-nav class="d-flex justify-content-center">
          <b-nav-item
            href="/"
            class="nav-item justify-content navbar-item smarthome"
          >
            <router-link
              class="smarthome"
              v-bind:to="{ name: 'login' }"
              v-if="$store.state.token.length == 0"
              >Login</router-link
            >&nbsp;&nbsp;
            <router-link
              class="smarthome"
              v-bind:to="{ name: 'logout' }"
              v-if="$store.state.token.length > 1"
              >Logout</router-link
            >
          </b-nav-item>
        </b-navbar-nav>

        <!-- <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token.length == 0" class="nav-item justify-content-end log">Login</router-link>&nbsp;&nbsp;
  <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token.length >1" class="nav-item justify-content-end log">Logout</router-link>  -->
      </b-navbar-nav>
    </b-navbar>
  </div>
</template>

<script>
export default {
  name: "navbar",
};
</script>

<style>
.navbar-item {
  color: rgb(255, 255, 230);
}

.log {
  background-color: rgb(155, 34, 38);
  color: rgb(255, 255, 230);
  border-radius: 15px;
}

.show {
  background-color: rgb(255, 255, 230);
  border-radius: 10px;
}

.dropdown-item {
  color: rgb(155, 34, 38);
}

.smarthome {
  color: rgb(255, 255, 230) !important;
  opacity: 0.75;
}

.smarthome:hover {
  opacity: 0.9;
}

a:hover {
  text-decoration: none;
}

.dropdown-item:hover {
  background-color: rgb(155, 34, 38);
  color: rgb(255, 255, 230);
}
</style>