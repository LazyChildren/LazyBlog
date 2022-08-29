import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    isLogin: false,
    user: {},
    userinfo: {},
    
  },
  getters: {
    getUser: state => {
      return state.user
    },
    getUserInfo: state => {
      return state.userinfo
    },
    getState: state => {
      return state.isLogin
    },
  
  },
  mutations: {
    refresh: (state) => {
      if(sessionStorage.getItem("islogin") == 'true' )
        state.isLogin = true
      else
        state.isLogin = false
      state.user = JSON.parse(sessionStorage.getItem("user"))
      state.userinfo = JSON.parse(sessionStorage.getItem("userinfo"))

    },
    SET_USER: (state, user) =>{
      state.user = user
      sessionStorage.setItem("user",JSON.stringify(user))
    },
    SET_USERINFO: (state, userinfo) =>{
      state.userinfo = userinfo
      sessionStorage.setItem("userinfo",JSON.stringify(userinfo))

    },
    LOG_IN: (state, user, userinfo) =>{
      state.isLogin = true
      state.user = user
      state.userinfo = userinfo
      sessionStorage.setItem("user",JSON.stringify(user))
      sessionStorage.setItem("userinfo",JSON.stringify(userinfo))
      sessionStorage.setItem("islogin","true")
    },
    REMOVE_INFO: (state) => {
      state.user = {}
      state.userinfo = {}
    },
    LOG_OUT: (state) => {
      state.isLogin = false 
      state.user = {}
      state.userinfo = {}
      sessionStorage.removeItem("user")
      sessionStorage.removeItem("userinfo")
      sessionStorage.removeItem("islogin")
    }


  },
  actions: {
  },
  modules: {
  }
})


