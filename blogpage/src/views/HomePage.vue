<template>
  <div>
    <div class="block">
      <el-timeline>
        <el-timeline-item :timestamp="blog.date" placement="top" v-for="blog in blogs" :key="blog.id">
          <el-card>

            <h4>
              <el-link  @click="toBlogDetail(blog.id)">{{blog.title}}</el-link>
              
            </h4>
            <p>{{blog.content}}</p>
          </el-card>
        </el-timeline-item>
      </el-timeline>
       

      <div class="page" align="center">
        <el-pagination   background  layout="prev, pager, next" 
        :cureent-page="curpage"
        :page-size="pagesize"
        :total="total"
        :hide-on-single-page = "hide_when_one_page"
        @current-change=getPage>
        </el-pagination>
      </div>
    </div>
  </div>
</template>

<script>
export default{
name: "homepage",
  data() {
    return {
      blogs: {},
      curpage: 1,
      total: 0,
      pagesize: 7,
      hide_when_one_page: true,
    };
  },
  methods: {
    getPage(curpage){
      const _this = this
      _this.$axios.get("/dairy/show?curpage="+curpage).then(res => {
        _this.blogs = res.data.data.dairies
        _this.curpage = res.data.data.curpage
        _this.total = res.data.data.totalpage
        _this.pagesize = res.data.data.size
        console.log(res)
      })
    },
    toBlogDetail(id) {
    this.$router.push("/blog/"+id)
    },
  },
  created() {
    this.getPage(1)
    console.log(this.$store.state.isLogin)
  },
  
}
  

</script>


<style scoped>
.block {
  margin: 0 auto;
  margin-top: 50px;
  height: auto;
  width: 60%;
  border-radius: 6px;
  background-color: rgba(255, 255, 255, 0.7);
}

.el-timeline {
  padding-top: 30px;
}

.el-card {
  margin-right: 50px;
}

.el-pagination {
  padding-bottom: 30px;
  
}
</style>