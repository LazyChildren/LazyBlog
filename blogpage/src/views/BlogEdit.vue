<template>
  <div class="block">
      <div class="cent">
      <el-form
        :model="ruleForm"
        status-icon
        :rules="rules"
        ref="ruleForm"
        label-width="100px"
        class="demo-ruleForm"
      >
        <el-form-item label="标题" prop="title">
          <el-input
            type="text"
            v-model="ruleForm.title"
            placeholder="博客的标题"
            autocomplete="off"
            maxlength="30"
              show-word-limit
          ></el-input>
        </el-form-item>

        <el-form-item label="正文" prop="content">
          <el-input
            type="textarea"
             
            v-model="ruleForm.content"
            :autosize="{ minRows: 5, maxRows: 20}"
            placeholder="在这里输入博客的内容..."
            autocomplete="off"
          ></el-input>
        </el-form-item>

        <el-form-item>
          <el-button
            type="primary"
            class="button"
            @click="submitForm('ruleForm')"
            >发表</el-button
          >
          <el-button
            type="danger"
            class="button"
            @click="quitForm()"
            >取消</el-button
          >
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>


<script>
export default {
  data() {
    return {
      ruleForm: {
        title: "",
        content: "",
      },
      rules: {
        content: [{ required: true, message: "请输入博客内容", trigger: "blur" }],
        title: [
          { required: true, message: "请添加博客标题", trigger: "blur" },
        ],
      },
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          // const _this = this
          this.$axios
            .post("/dairy/add", this.ruleForm)
            .then((res) => {
              if(res.data.code === 200)
              {
                this.$router.replace("/index")
                this.$message({
                  message: '发表成功!',
                  type: 'success',
                });
              }
              
            });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    quitForm() {
      if(this.ruleForm.title!=='' || this.ruleForm.content!=='')
      {
        this.$confirm('有未提交的内容，是否继续？(数据会在退出页面后丢失)', '是否退出', {
          distinguishCancelAndClose: true,
          confirmButtonText: '留在此页',
          cancelButtonText: '继续'
        })
          .then(() => {
          })
          .catch(action => {
            if(action==='cancel')
            {
              this.$router.push("/index")
            }
          });
      }
      else
        this.$router.push("/index")
    },
  },
};
</script>

<style scoped>
.block {
  text-align: center;
  margin: 0 auto;
  margin-top: 50px;
  height: auto;
  width: 60%;
  border-radius: 6px;
  background-color: rgba(255, 255, 255, 0.7);
}

.cent {
  height: 50%;
  width: 90%;
  margin-top: 15%;
  margin-left: 0%;
  padding-top: 10%;
  padding-bottom: 3%;
}

.button {
  margin: 0 auto;
}


.formarea{
  top: 20%;
  background-color: rgba(255, 255, 255, 0.5);
  height: 300px;
  width: 400px;
  left: 34.3%;
  position: absolute;
}

.el-button{
  margin: 30px;
}
</style>