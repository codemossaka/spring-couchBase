import * as type from "../types";
import Vue from 'vue';


export default {
    [type.GET_MENUS]:(state, menus) =>{
        Vue.set(state, 'menus', menus)
    },
}
