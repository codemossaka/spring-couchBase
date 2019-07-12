import * as type from "../types";

export default {
    [type.GET_MENUS]: ({commit, getters}) =>
        getters.GET(`/`)
            .then(body => commit(type.GET_MENUS, body.result)),

    [type.SAVE_MENU]: ({commit, getters}) =>
    getters.POST(`/`)
        .then(body => commit(type.SAVE_MENU, body)),

}
