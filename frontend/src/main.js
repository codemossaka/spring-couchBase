import Vue from 'vue'
import './plugins/vuetify'
import App from './App.vue'
import router from './router/index'
import store from './vuex'
import VueLodash from 'vue-lodash'

Vue.config.productionTip = false
const options = { name: 'lodash' }
Vue.use(VueLodash, options)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
