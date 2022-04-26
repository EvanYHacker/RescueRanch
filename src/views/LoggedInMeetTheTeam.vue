<template>
  <div>
    <header-default />
    <logged-in-navbar class="sticky-top" />
    <h1 class="indiName meet">Meet The Ranchers</h1>

    <main>
      <div class="d-flex justify-content-space-evenly">
        <div class="row box">
          <div class="col-12 redback box-line">
            <a class="yunderline" href="https://www.linkedin.com/in/evanyhacker/">
              <img class="img-fluid" src="../assets/images/Evan.jpg" alt="" srcset="" />
              <h2 class="subyellow">Evan Y Hacker</h2></a>
            <p class="team-text">Rescued a trash dog</p>
            <p class="team-text">Speaks Chinese</p>
            <p class="team-text">Graduate of Tech Elevator</p>
          </div>
        </div>
        <div class="row box">
          <div class="col-12 redback box-line">
            <a
              class="yunderline"
              href="https://www.linkedin.com/in/dev-james-miller/"
            >
              <img
                class="img-fluid"
                src="../assets/images/Jim.jpg"
                alt=""
                srcset=""
              />
              <h2 class="subyellow">Jim Miller</h2></a
            >
            <p class="team-text">Loves To Sing</p>
            <p class="team-text">Vue Maddog</p>
            <p class="team-text">Graduate of Tech Elevator</p>
          </div>
        </div>
        <div class="row box">
          <div class="col-12 redback box-line">
            <a
              class="yunderline"
              href="https://www.linkedin.com/in/cameron-nagy/"
            >
              <img
                class="img-fluid"
                src="../assets/images/Me.jpg"
                alt=""
                srcset=""
              />
              <h2 class="subyellow">Cameron Nagy</h2></a
            >
            <p class="team-text">Gamer</p>
            <p class="team-text">Loves the Word Bruh</p>
            <p class="team-text">Graduate of Tech Elevator</p>
          </div>
        </div>

        <div class="row box">
          <div class="col-12 redback box-line">
            <a
              class="yunderline"
              href="https://www.linkedin.com/in/robert-presley/"
            >
              <img
                class="img-fluid"
                src="../assets/images/Robert.jpg"
                alt=""
                srcset=""
              />
              <h2 class="subyellow">Robert Presley</h2></a
            >
            <p class="team-text">Java Pro</p>
            <p class="team-text">Proud owner of RescueRanch.io</p>
            <p class="team-text">Graduate of Tech Elevator</p>
          </div>
        </div>
      </div>
    </main>

    <footer-default />
  </div>
</template>

<script>
import HeaderDefault from "../components/HeaderDefault";
import LoggedInNavbar from "../components/LoggedInNavbar.vue";
import FooterDefault from "../components/FooterDefault";
export default {
  components: { HeaderDefault, LoggedInNavbar, FooterDefault },
};
</script>

<style>
.col-12 {
  text-align: center;
}
</style>