<template>
  <div>
    <header-default />
    <navbar class="sticky-top" />
    <h2 class="subheading">Apply To Volunteer</h2>

    <div class="d-flex volunteerform adopt-form">
      <form v-on:submit.prevent="submitForm" class="ApplyToVolunteer">
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="inputUsername">Username</label>
            <input
              type="text"
              class="form-control"
              id="inputUsername"
              placeholder="Username"
              v-model="applicant.inputUsername"
              required
            />
          </div>

          <div class="form-group col-md-6">
            <label for="inputPassword">Password</label>
            <input
              type="password"
              class="form-control"
              id="inputPassword"
              placeholder="Password"
              v-model="applicant.inputPassword"
              required
            />
          </div>
        </div>

        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="inputFirstname">First Name</label>
            <input
              type="text"
              class="form-control"
              id="inputFirstname"
              placeholder="First Name"
              v-model="applicant.inputFirstname"
              required
            />
          </div>
          <div class="form-group col-md-6">
            <label for="inputLastname">Last Name</label>
            <input
              type="text"
              class="form-control"
              id="inputLastname"
              placeholder="Last Name"
              v-model="applicant.inputLastname"
              required
            />
          </div>
          <div>
            <div class="form-row">
              <div class="form-group col-md-6">
                <label for="inputEmail">Email</label>
                <input
                  type="email"
                  class="form-control"
                  id="inputEmail"
                  placeholder="Joe@RescueRanch.com"
                  v-model="applicant.inputEmail"
                  required
                />
              </div>

              <div class="form-group col-md-6">
                <label for="inputPhone">Phone Number (10 Digits)</label>
                <input
                  type="tel"
                  class="form-control"
                  id="inputPhone"
                  v-model="applicant.inputPhone"
                  placeholder="9194445555"
                  :maxlength="10"
                  pattern="[1-9]{1}[0-9]{9}"
                  required
                />
              </div>
            </div>
          </div>
        </div>
        <div class="d-flex sbm-btn">
        <input type="submit" value="Submit" />
        </div>
      </form>
    </div>
    <footer-default />
  </div>
</template>

<script>
import HeaderDefault from "../components/HeaderDefault.vue";
import Navbar from "../components/Navbar.vue";
import ApplicantService from "../services/ApplicantService";
import FooterDefault from "../components/FooterDefault";

export default {
  name: "ApplyToVolunteer",

  data() {
    return {
      applicant: {
        username: "",
        password_hash: "",
        fullname: "",
        email: "",
        phoneNumber: "",
      },
    };
  },

  components: { HeaderDefault, Navbar, FooterDefault },

  methods: {
    submitForm() {
      const newApplicant = {
        username: this.applicant.inputUsername,
        password_hash: this.applicant.inputPassword,
        fullname:
          this.applicant.inputFirstname + " " + this.applicant.inputLastname,
        email: this.applicant.inputEmail,
        phoneNumber: parseInt(this.applicant.inputPhone),
      };

      if (newApplicant) {
        ApplicantService.addApplicant(newApplicant).then((response) => {
          if (response.status === 200) {
            this.$router.push("/thankyou");
          }
        });
      }
    },
  },
};
</script>

<style>

.form-row {
  justify-content: center;
}

.sbm-btn {
  align-items: center;
}
</style>