<template>
  <div>
    <header-default />
    <logged-in-navbar class="sticky-top" />

    <div class="mission">
      <h2 class="subheading">Pending Applicants</h2>
    </div>

    <form>
      <div class="applicant-box">
        <div
          class="applicant"
          v-for="applicant in applicants"
          v-bind:key="applicant"
          v-bind:applicant="applicant"
        >
          <h4>{{ applicant.fullname }}</h4>
          <p>Phone: {{ applicant.phoneNumber }}</p>
          <p>{{ applicant.email }}</p>
          <p>Username: {{ applicant.username }}</p>

          <button v-on:click.prevent="approveApplicant(applicant.id)">APPROVE</button>
          <button v-on:click.prevent="denyApplicant(applicant.id)">DENY</button>
        </div>
      </div>
    </form>
    <footer-default />
  </div>
</template>

<script>
import HeaderDefault from "../components/HeaderDefault.vue";
import ApplicantService from "../services/ApplicantService";
import FooterDefault from "../components/FooterDefault";
import LoggedInNavbar from "../components/LoggedInNavbar.vue";

export default {
  components: { HeaderDefault, FooterDefault, LoggedInNavbar },
  data() {
    return {
      applicants: [],
    };
  },

  created() {
    ApplicantService.getApplicants().then((response) => {
      this.applicants = response.data;
    });
  },

  methods: {
    approveApplicant(id) {
      ApplicantService.approveApplicant(id).then((response) => {
      this.applicants = response.data;
    });
     
     },
      
    denyApplicant(id) {
      ApplicantService.denyApplicant(id).then((response) => {
      this.applicants = response.data;
    });
  }
  }
};
</script>

<style>
.applicant {
  margin: auto;
  margin-bottom: 15px;
  text-align: center;
  border: 2px solid black;
  width: 33%;
}
.applicant-box {
  text-align: center;
}
button {
  margin: 5px;
}
</style>