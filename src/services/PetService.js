import axios from 'axios';


export default {

    getAllPets() {
        return axios.get('/allpets');
    },
    getPetById(id) {
        return axios.get('/petinfo/' + id);
    },
    getCats() {
        return axios.get('/cats');
    },
    getDogs() {
        return axios.get('/dogs');
    },
    getOthers() {
        return axios.get('/otheranimals');
    },

    addPet(pet, user) {
        return axios.post('/addpet', pet, user);
    },

    updatePet(pet) {
        return axios.put('/updatepet', pet);
    },

    applyToAdopt(AdoptionApplication) {
        return axios.post('/newadoptionapplication', AdoptionApplication);
    },

    adoptedPets() {
        return axios.get('/adoptedpets');
    }

}