import axios from '../axios';
import * as type from "./types";
const getters = {
    // headers(state) {
    //     return {
    //         'Authorization': 'Bearer '+state.sessions.access_token
    //     }
    // },
    CHECK_TOKEN() {
        return (url, token) => axios.get(url, {headers:{'Authorization': 'Bearer '+token}})
            .then( response => response.data || {} )
    },

    GET(state, getters) {
        return (url, params) => axios.get(url, {params, headers: getters.headers})
            .then( response => response.data || {} )
    },

    POST(state, getters) {
        return (url, params) => axios.post(url, params,  {headers: getters.headers})
            .then( response => response.data || {} ).catch(response => response.response.data || {} )
    },

    PUT(state, getters) {
        return (url, params) => axios.put(url, params,  {headers: getters.headers})
            .then( response => response.data || {} )
    },

    DELETE(state, getters) {
        return (url) => axios.delete(url, {headers: getters.headers})
            .then( response => response.data || {} )
    },


};

export default getters;
