<template>
  <div>
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
    </div>

    <logged-in-navbar class="sticky-top" />

    <body>
      <main>
        <div class="row mission">
          <div class="col-6 col-lg-4 col-xl-6">
            <h2 class="subheading">Our Mission</h2>
            <p class="paragraph">
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
              ><h2 class="subyellow">Adopt a Pet Today!</h2></a
            >
          </div>
          <div class="d-flex justify-content-space-evenly">
            <div class="row adopt">
              <div class="col-12">
                <img
                  class="img-fluid"
                  src="https://images.unsplash.com/photo-1580788404954-ae4e4bdc9061?ixlib=rb-1.2.1&ixid=MnwxM[…]G90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&q=80"
                  alt=""
                  srcset=""
                />
                <a class="yunderline" href="Cats"
                  ><h2 class="subyellow">Cats</h2></a
                >
              </div>
            </div>
            <div class="row adopt">
              <div class="col-12">
                <img
                  class="img-fluid"
                  src="https://images.unsplash.com/photo-1587354004405-bbce24c893c8?ixlib=rb-1.2.1&ixid=MnwxM[…]G90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&q=80"
                  alt=""
                  srcset=""
                />
                <a class="yunderline" href="Dogs"
                  ><h2 class="subyellow">Dogs</h2></a
                >
              </div>
            </div>
            <div class="row adopt">
              <div class="col-12">
                <img
                  class="img-fluid"
                  src="https://images.unsplash.com/photo-1589643989849-b4cef7873cd4?ixlib=rb-1.2.1&ixid=MnwxM[…]G90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&q=80"
                  alt=""
                  srcset=""
                />
                <a class="yunderline" href="Others"
                  ><h2 class="subyellow">Other Animals</h2></a
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
            <p class="paragraph">
              We practice responsible and innovative ways to reduce animal
              overpopulation in shelters, rescue and rehabilitate critically
              injured and neglected animals, and connect the community to
              services that enable animals to remain in their homes. Together we
              are advocates, rescuers, and educators. Together we make a
              difference. Why do we do what we do? Because they deserve a Second
              Chance.
            </p>
            <a class="subheading" href="/LoggedInMeetTheTeam"
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
import FooterDefault from "../components/FooterDefault";
import LoggedInNavbar from "../components/LoggedInNavbar";

export default {
  components: { FooterDefault, LoggedInNavbar },
};
</script>

<style>
</style>