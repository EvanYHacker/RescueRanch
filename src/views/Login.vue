<template>
  <div class="">
    <header-default />
    <navbar class="sticky-top" />

    <div id="login" class="text-center">
      <form class="form-signin" @submit.prevent="login">
        <h2 class="subheading">Please Sign In</h2>
        <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
          Invalid username and password!
        </div>
        <div
          class="alert alert-success"
          role="alert"
          v-if="this.$route.query.registration"
        >
          Thank you for registering, please sign in.
        </div>
        <div class="d-flex">
          <div class="form-box">
          <label for="username" class="sr-only">Username</label>
          <input
            type="text"
            id="username"
            class="form-control form-line"
            placeholder="Username"
            v-model="user.username"
            required
            autofocus
          />

          <label for="password" class="sr-only">Password</label>
          <input
            type="password"
            id="password"
            class="form-control form-line"
            placeholder="Password"
            v-model="user.password"
            required
          />
        </div>
        </div>

        <router-link
          class="btn r-btn-outline"
          :to="{ name: 'applytovolunteer' }"
          >Need an account?</router-link
        >
        <button class="btn r-btn-outline" type="submit">Sign in</button>
      </form>
    </div>
    <footer-default />
  </div>
</template>

<script>
import HeaderDefault from "../components/HeaderDefault.vue";
import authService from "../services/AuthService";
import Navbar from "../components/Navbar.vue";
import FooterDefault from "../components/FooterDefault";

export default {
  name: "login",
  components: { HeaderDefault, Navbar, FooterDefault },
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/loggedinhome");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style>
.r-btn-outline {
  border: 2px solid rgb(155, 34, 38);
  color: rgb(255, 255, 230);
  background-color: rgb(155, 34, 38);
}

.r-btn-outline:hover {
  border: 2px solid rgb(155, 34, 38);
  color: rgb(155, 34, 38);
  background-color: rgb(255, 255, 230);
}

.form-box {
  flex-direction: column;
  align-items: center;
  width: 33%;
}

.form-line {
  margin: 10px 0px 10px 0px;
}
</style>
