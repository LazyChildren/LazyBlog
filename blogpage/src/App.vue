<template>
  <div id="app" >
   <div class="background"></div>
   <div>
    <el-container>
      <el-header v-show="$route.meta.showheader" style="height: 100px"><Header/></el-header>
      <el-main> <router-view/> </el-main>
      <el-footer v-show="$route.meta.showheader"><Footer/></el-footer>
    </el-container>
   </div>
    
    
  </div>
  
</template>

<script>
import Header from './components/Header.vue'
import Footer from './components/Footer.vue'



export default {
  name: "app",
  components: { Header, Footer},
  data() {
    return {
      bgurl: "https://www.z4a.net/images/2022/08/22/illust_65261833_20200924_234507.jpg",
    };
  },
  watch: {
    // 监听 $route 属性的变化
    $route(newValue) {
      console.log(newValue)
    },
  },
};
</script>


<style scoped>
* {
  margin: 0px;
  padding: 0px;
}

.app{
  margin: 0px;
  padding: 0px;
  width: auto;
}

.el-main{
  margin-top: 30px;
  margin: 0px;
}

.el-footer{
  margin-top: 10px;
}


.background{
    width: 100%;
    height: 100%;
    position: fixed;
    filter: blur(5px);
    z-index: -1;
    margin: 0;
    padding: 0;
	border:0;
    background-size: cover;
    transform: scale(1.1);
    position: left 10%;
    background-image: url('http://localhost:8081/image/bg.jpg');
    
 }
</style>

