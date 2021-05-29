import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import axios from "axios";
import VModal from 'vue-js-modal'

Vue.use(VModal, {
    dialog: true,
    dynamicDefaults: {
        draggable: true
    }
});

//if change start port, modify node_modules@vue\cli-service\lib\commands\serve.js
axios.defaults.baseURL = 'http://localhost:8080';// Springboot start port

Vue.config.productionTip = false;

new Vue({
  router,
  render: h => h(App),
}).$mount('#app');
