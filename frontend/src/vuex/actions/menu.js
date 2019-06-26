import * as type from "../types";

export default {
    [type.GET_MENUS]: ({commit, getters}) =>
        getters.GET(`/`)
            .then(body => commit(type.GET_MENUS, body)),

}
