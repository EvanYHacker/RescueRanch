<template>
  <div>
    <header-default />
    <navbar class="sticky-top" />
        <h1>Thank You For Your Donation!</h1>
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
</style>