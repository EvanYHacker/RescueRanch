<template>
  <div>
    <header-default />
    <navbar class="sticky-top" />
        <h2 class="subheading">Thank You For Applying!</h2>
        <h2><a class="redHere" href="/">Click Here To Return Home</a></h2>
        <footer-default />
    </div>
</template>

<script>
import HeaderDefault from '../components/HeaderDefault.vue'
import Navbar from '../components/Navbar.vue'
import FooterDefault from "../components/FooterDefault";
export default {
  components: { HeaderDefault, Navbar, FooterDefault},
}
</script>

<style>
h1 {
  text-align: center;
}

@keyframes color-change {
  0% { color: red; } 
  14.3% { color: orange; }
  28.6% { color: yellow; }
  42.9% { color: green; }
  57.2% { color: blue; }
  71.5% { color: indigo; }
  85.8% { color: violet; }
  100% { color: palegreen; }
}

.redHere {
  animation: color-change 8s infinite;
}

</style>