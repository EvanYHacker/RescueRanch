<template>
  <div>
    <header-default />
    <navbar class="sticky-top" />
    <h2 class="subheading">Donation Form</h2>
    <form>
      <div class="form-row">
        <div class="form-group col-md-6">
          <label for="inputFullname">Full Name</label>
          <input
            type="text"
            class="form-control"
            id="inputFullname"
            placeholder="Full Name"
            required
          />
        </div>
      </div>

      <div class="form-row">
        <div class="form-group col-md-6">
          <label for="inputEmail">Email</label>
          <input
            type="email"
            class="form-control"
            id="inputEmail"
            placeholder="Joe@RescueRanch.com"
            required
          />
        </div>
      </div>

      <div class="form-row">
        <div class="form-group col-md-6">
          <label for="inputAmount">Donation</label>
          <input
            type="number"
            min="0.01"
            step="0.01"
            class="form-control"
            id="inputAmount"
            placeholder="Donation Amount"
            required
          />
        </div>
      </div>
      <div class="d-flex sbm-btn dono-sbm">
        <input type="submit" value="Submit" />
        </div>
    </form>
    <footer-default />
  </div>
</template>

<script>
import HeaderDefault from "../components/HeaderDefault.vue";
import Navbar from "../components/Navbar.vue";
import FooterDefault from "../components/FooterDefault";

export default {
  components: { HeaderDefault, Navbar, FooterDefault },
};
</script>

<style>
.dono-sbm {
  padding-bottom: 10px;
}
</style>