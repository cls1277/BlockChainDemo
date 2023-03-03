import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/index',
    name: 'index',
    component: () => import('../../views_index/Home'),
    props: true
  }
]

const router = new VueRouter({
  mode: 'history',
  base: '/',
  routes
})

export default router