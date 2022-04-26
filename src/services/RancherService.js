import axios from 'axios';



export default {

    getAllRanchers() {
        return axios.get('/rancherlist');
    }
}