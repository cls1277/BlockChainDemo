import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import Home from '../views_home/Home.vue'
import axios from 'axios'
axios.defaults.baseURL='http://localhost:8080/'
// Vue.prototype.$baseUrl = "http://150.158.93.128:8080"
// Vue.prototype.$baseUrl = "http://localhost:8080"
// axios.defaults.baseURL='http://150.158.93.128:8080'
Vue.prototype.$http = axios
import router from '../router/home'


Vue.use(ElementUI)
Vue.config.productionTip = false

new Vue({
    router,
    render: h => h(Home)
}).$mount('#app')