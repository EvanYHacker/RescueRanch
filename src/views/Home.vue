<template>
  <div>
    <header>
      <div>
        <img
          id="title"
          class="img-fluid"
          src="../assets/images/jimmyredshoes.jpg"
          alt="Title and Slogan"
          srcset=""
        />
      </div>
    </header>
    <navbar class="sticky-top" />

    <body>
      <main>
        <div class="row mission">
          <div class="col-6 col-lg-4 col-xl-6">
            <h2 class="subheading">Our Mission</h2>
            <p class="paragraph text-fluid">
              Rescue Ranch of Tech Elevator is the world’s leading resource for
              pets and pet owners. Our mission is to eliminate the needless
              euthanasia of healthy and treatable pets across the world.
              Formerly the Righetti Ranch Humane Society, Rescue Ranch and
              Helping Hands Pet Rescue, we joined forces in 2018 to streamline
              services for pets and the people who love them. Founded in The
              Blue classroom over 10 days ago, Rescue Ranch of Tech Elevator is
              committed to ensuring every healthy or treatable companion animal
              in our region finds a loving, adoptive home.
            </p>
            <a class="subheading" href="/ApplyToVolunteer">
              <h2 class="subheading">Join The Team Today!</h2></a
            >
          </div>

          <div class="col-sm-6 col-lg-8 col-xl-6">
            <b-carousel
              class="carousel image"
              v-model="slide"
              :interval="4000"
              controls
              indicators
              background="rgb(255, 255, 230)"
              img-width="1024"
              img-height="480"
              style="text-shadow: 1px 1px 2px #333"
              @sliding-start="onSlideStart"
              @sliding-end="onSlideEnd"
            >
              <b-carousel-slide
                caption="Join the Team Today"
                text="Apply To volunteer and become part of our family."
                img-src="https://www.halifaxhumanesociety.org/zupload/site-options/pet-adoption-img1.jpg"
              ></b-carousel-slide>

              <b-carousel-slide
                caption="You can make a difference"
                text="Our goal is to provide animals in need with the love and care they need."
                img-src="https://ffwallpaper.com/thumb/cat-and-dog/cat-and-dog-4.jpg"
              ></b-carousel-slide>

              <b-carousel-slide
                caption="Adopt an animal"
                text="Every adoption helps give a good home to a needy animal."
                img-src="https://www.stageroadanimalhospital.com/files/spay-neuter-cat-memphis-vet.jpeg"
              ></b-carousel-slide>

              <b-carousel-slide
                caption="Donate Today"
                text="Your contribution can help give an animal the second chance they deserve."
                img-src="https://ffwallpaper.com/thumb/cat-and-dog/cat-and-dog-11.jpg"
              ></b-carousel-slide>
            </b-carousel>
          </div>
        </div>
        <div class="row-director">
          <div
            class="
              fluid
              subyellow
              col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 col-xxl-12
            "
          >
            <a class="yunderline" href="AllPets"
              ><h2 class="subyellow">Click Here to Adopt a Pet Today!</h2></a
            >
          </div>
          <div class="d-flex justify-content-space-evenly">
            <div class="row adopt">
              <div class="col-12">
                <a class="yunderline" href="Cats">
                  <img
                    class="img-fluid"
                    src="https://images.unsplash.com/photo-1580788404954-ae4e4bdc9061?ixlib=rb-1.2.1&ixid=MnwxM[…]G90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&q=80"
                    alt=""
                    srcset=""
                  />
                  <h2 class="subyellow">Cats</h2></a
                >
              </div>
            </div>
            <div class="row adopt">
              <div class="col-12">
                <a class="yunderline" href="Dogs">
                  <img
                    class="img-fluid"
                    src="https://images.unsplash.com/photo-1587354004405-bbce24c893c8?ixlib=rb-1.2.1&ixid=MnwxM[…]G90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&q=80"
                    alt=""
                    srcset=""
                  />
                  <h2 class="subyellow">Dogs</h2></a
                >
              </div>
            </div>
            <div class="row adopt">
              <div class="col-12">
                <a class="yunderline" href="Others">
                  <img
                    class="img-fluid"
                    src="https://images.unsplash.com/photo-1589643989849-b4cef7873cd4?ixlib=rb-1.2.1&ixid=MnwxM[…]G90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&q=80"
                    alt=""
                    srcset=""
                  />
                  <h2 class="subyellow">Other Animals</h2></a
                >
              </div>
            </div>
          </div>
        </div>
        <div class="row mission">
          <div class="col-sm-6 col-lg-8">
            <img
              class="img-fluid image"
              src="https://www.humanesociety.org/sites/default/files/styles/2000x850/public/2018/08/dog-girl-440625.jpg?h=558430af&itok=R-RS3S6N"
              alt=""
              srcset=""
            />
          </div>
          <div class="col-6 col-lg-4">
            <h2 class="subheading">About The Team</h2>
            <a name="A"></a>
            <p class="paragraph fluid">
              We practice responsible and innovative ways to reduce animal
              overpopulation in shelters, rescue and rehabilitate critically
              injured and neglected animals, and connect the community to
              services that enable animals to remain in their homes. Together we
              are advocates, rescuers, and educators. Together we make a
              difference. Why do we do what we do? Because they deserve a Second
              Chance.
            </p>
            <a class="subheading" href="/MeetTheTeam"
              ><h2 class="subheading">Click To Meet The Team</h2></a
            >
          </div>
        </div>
      </main>
    </body>
    <footer-default />
  </div>
</template>

<script>
import Navbar from "../components/Navbar.vue";
import FooterDefault from "../components/FooterDefault";

export default {
  components: { Navbar, FooterDefault },
};
</script>

<style>
.carousel-caption h3 {
  font-family: Garamond;
  font-size: 3em;
  color: rgb(155, 34, 38) !important;
  text-shadow: black 1px 0px 0px, black 0.540302px 0.841471px 0px,
    black -0.416147px 0.909297px 0px, black -0.989992px 0.14112px 0px,
    black -0.653644px -0.756802px 0px, black 0.283662px -0.958924px 0px,
    black 0.96017px -0.279416px 0px;
}

.carousel-caption p {
  font-family: Garamond;
  font-size: 2em;
  color: rgb(255, 255, 230) !important;
  text-shadow: black 1px 0px 0px, black 0.540302px 0.841471px 0px,
    black -0.416147px 0.909297px 0px, black -0.989992px 0.14112px 0px,
    black -0.653644px -0.756802px 0px, black 0.283662px -0.958924px 0px,
    black 0.96017px -0.279416px 0px;
}

.image {
  border: 10px solid rgb(255, 255, 230);
  border-radius: 50px;
  overflow: hidden;
}

.nav-link,
span {
  font-size: large;
}

.row-director {
  background-color: rgb(155, 34, 38);
}

.subyellow {
  color: rgb(255, 255, 230);
  text-shadow: 1px black;
}

.col-12 > img {
  border-radius: 50%;
  border: 7px solid rgb(255, 255, 230);
}

.col-12 > a > img {
  width: 69%;
  border-radius: 50%;
  border: 7px solid rgb(255, 255, 230);
}

.mission {
  background-color: rgb(255, 255, 230);
  align-items: center;
}

.director {
  background-color: rgb(155, 34, 38);
}

.paragraph {
  text-align: center;
  padding-left: 10px;
  padding-right: 10px;
  font-size: 25px;
}

#nav {
  bottom: 0;
  width: 100%;
  background-color: rgb(155, 34, 38);
}

.nav-item {
  display: inline-block;
  font-size: 20px;
  padding: 1px 5px 1px 5px;
}

.dropdown {
  color: rgb(255, 255, 230);
  background-color: rgb(155, 34, 38);
}

h2 {
  text-align: center;
  color: rgb(155, 34, 38);
  text-shadow: 2px black;
  padding: 15px;
  text-shadow: black 1px 0px 0px, black 0.540302px 0.841471px 0px,
    black -0.416147px 0.909297px 0px, black -0.989992px 0.14112px 0px,
    black -0.653644px -0.756802px 0px, black 0.283662px -0.958924px 0px,
    black 0.96017px -0.279416px 0px;
}

.d-flex {
  display: flex !important;
  justify-content: space-evenly;
}

.adopt {
  text-align: center;
}

.col-12 > img {
  max-width: 50%;
}

.redback {
  background-color: rgb(155, 34, 38);
}

.foot {
  padding: 10px;
  border-top: 10px solid rgb(155, 34, 38);
  background-color: rgb(255, 255, 230);
  font-style: italic;
  text-align: center;
}

body {
  background: rgb(255, 255, 230);
}

html {
  scroll-behavior: smooth;
}

.paul {
  color: black;
}

.paul:hover {
  color: rgb(155, 34, 38);
}

.yunderline:hover {
  text-decoration-color: rgb(255, 255, 230);
}

.volunteerform {
  padding: 10px;
}
</style>