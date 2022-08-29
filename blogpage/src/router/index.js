import Vue from 'vue'
import VueRouter from 'vue-router'
import HomePage from '../views/HomePage'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    meta: {
      showheader: true,
    },
    component: HomePage
  },
  {
    path: '/index',
    name: 'index',
    meta: {
      showheader: true,
    },
    component: HomePage
  },
  {
    path: '/login',
    name: 'login',
    meta: {
      showheader: false,
    },
    component: () => import('../views/Login.vue')
  },
  {
    path: '/blog/edit',
    name: 'blogadd',
    meta: {
      showheader: true,
    },
    component: () => import( '../views/BlogEdit.vue')
  },
  {
    path: '/blog/:blogid',
    name: 'blogdetail',
    meta: {
      showheader: true,
    },
    component: () => import( '../views/BlogDetail.vue')
  },
  {
    path: '/blog/edit/:blogid',
    name: 'blogedit',
    meta: {
      showheader: true,
    },
    component: () => import( '../views/BlogEdit.vue')
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
