import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
    {
        path: '/home',
        name: 'home',
        component: () => import('../../views_home/Home'),
        props: true
    }
]

const router = new VueRouter({
    mode: 'history',
    base: '/home',
    routes
})

export default router