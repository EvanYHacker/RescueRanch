<template>
  <div>
    <header-default />
    <navbar class="sticky-top" />
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
import Navbar from "../components/Navbar.vue";
import FooterDefault from "../components/FooterDefault";
export default {
  components: { HeaderDefault, Navbar, FooterDefault },
};
</script>

<style>
.col-12 {
  text-align: center;
}

.col-12 > a > img{
  border: 3px solid rgb(255, 255, 230);
  margin-top: 15px;
}

.col-12 > p {
  font-size: 20px;
}

.meet {
  color: rgb(155, 34, 38);
  text-shadow: black 1px 0px 0px, black 0.540302px 0.841471px 0px,
    black -0.416147px 0.909297px 0px, black -0.989992px 0.14112px 0px,
    black -0.653644px -0.756802px 0px, black 0.283662px -0.958924px 0px,
    black 0.96017px -0.279416px 0px;
}

.box {
  padding-bottom: 15px;
}

.box-line {
    border: 5px solid black;
    border-radius: 25px;
}

.team-text {
  color: rgb(255, 255, 230);
}
</style>