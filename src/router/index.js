import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import AllPets from '../views/AllPets.vue'
import Cats from '../views/Cats.vue'
import Dogs from '../views/Dogs.vue'
import Others from '../views/Others.vue'
import ApplyToVolunteer from '../views/ApplyToVolunteer.vue'
import Dono from '../views/Dono.vue'
import ThankYou from '../views/ThankYou.vue'
import ListRanchers from '../views/ListRanchers.vue'
import LoggedInHome from '../views/LoggedInHome.vue'
import ListApplicants from '../views/ListApplicants.vue'
import AddPet from '../views/AddPet.vue'
import ConfirmPet from '../views/ConfirmPet.vue'
import MeetTheTeam from '../views/MeetTheTeam.vue'
import EditPets from '../views/EditPets.vue'
import PetInfo from '../views/PetInfo.vue'
import Adopt from '../views/Adopt.vue'
import UpdatePet from '../views/UpdatePet.vue'
import LoggedInMeetTheTeam from '../views/LoggedInMeetTheTeam.vue'
import AdoptedPets from '../views/AdoptedPets.vue'
import ThankAdopt from '../views/ThankAdopt.vue'
import ThankDono from '../views/ThankDono.vue'
import store from '../store/index'


Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [{
            path: '/',
            name: 'home',
            component: Home,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/login",
            name: "login",
            component: Login,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/logout",
            name: "logout",
            component: Logout,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/register",
            name: "register",
            component: Register,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/allpets",
            name: "allpets",
            component: AllPets,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/cats",
            name: "cats",
            component: Cats,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/dogs",
            name: "dogs",
            component: Dogs,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/others",
            name: "others",
            component: Others,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/applytovolunteer",
            name: "applytovolunteer",
            component: ApplyToVolunteer,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/thankyou",
            name: "thankyou",
            component: ThankYou,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/confirmpet",
            name: "confirmpet",
            component: ConfirmPet,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/dono",
            name: "dono",
            component: Dono,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/loggedinhome",
            name: "loggedinhome",
            component: LoggedInHome,
            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/rancherlist",
            name: "rancherlist",
            component: ListRanchers,

            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/addpet",
            name: "addpet",
            component: AddPet,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/meettheteam",
            name: "meettheteam",
            component: MeetTheTeam,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/editpets",
            name: "editpets",
            component: EditPets,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/petinfo/:id",
            name: "petinfo",
            component: PetInfo,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/adopt/:id",
            name: "adopt",
            component: Adopt,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/updatepet/:id",
            name: "updatepet",
            component: UpdatePet,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/loggedinmeettheteam",
            name: "loggedinmeettheteam",
            component: LoggedInMeetTheTeam,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/listapplicants",
            name: "listapplicants",
            component: ListApplicants,

            meta: {
                requiresAuth: true
            }
        },
        {
            path: "/thankadopt",
            name: "thankadopt",
            component: ThankAdopt,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/thankdono",
            name: "thankdono",
            component: ThankDono,
            meta: {
                requiresAuth: false
            }
        },
        {
            path: "/adoptedpets",
            name: "adoptedpets",
            component: AdoptedPets,

            meta: {
                requiresAuth: false
            }
        }

    ]
})

router.beforeEach((to, from, next) => {
    // Determine if the route requires Authentication
    const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

    // If it does and they are not logged in, send the user to "/login"
    if (requiresAuth && store.state.token === '') {
        next("/login");
    } else {
        // Else let them go to their next destination
        next();
    }
});

export default router;