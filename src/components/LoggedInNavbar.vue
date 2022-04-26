<template>
  <div>
    <b-navbar
      type="dark"
      id="nav"
      role="navigation"
      class="
        navbar
        bd-navbar
        flex-column flex-md-row
        navbar-expand
        nav-item
        sticky-top
        d-flex
        justify-content-center
      "
    >
        <b-navbar-nav class="d-flex justify-content-center">
          <b-nav-item
            href="/LoggedInHome"
            class="nav-item justify-content-end navbar-item"
            >Home</b-nav-item
          >

          <b-nav-item-dropdown text="Manage Pets" right class="nav-item">
            <b-dropdown-item href="/AddPet">Add a Pet Listing</b-dropdown-item>
            <b-dropdown-item href="/EditPets"
              >View/Update Pet Listings</b-dropdown-item
            >
          </b-nav-item-dropdown>

          <b-nav-item class="mr-auto navbar-item" href="/ListApplicants"
            >Applicants</b-nav-item
          >

          <b-nav-item class="mr-auto navbar-item" href="/RancherList"
            >Ranchers</b-nav-item
          >

          <b-nav-item class="mr-auto navbar-item" href="/LoggedInMeetTheTeam"
            >Meet The Team</b-nav-item
          >

          <b-nav-item class="mr-auto navbar-item" href="/LoggedInHome#A"
            >About Us</b-nav-item
          >

          <b-nav-item href="/logout" class="nav-item justify-content-end log smarthome"
            >Logout</b-nav-item
          >
        </b-navbar-nav>
        
          
    </b-navbar>
  </div>
</template>

<script>
export default {
  name: "loggedinnavbar",
};
</script>