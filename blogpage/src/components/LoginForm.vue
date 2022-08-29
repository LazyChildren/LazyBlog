<template>
    <div class="cent">
      <el-form
        :model="ruleForm"
        status-icon
        :rules="rules"
        ref="ruleForm"
        label-width=auto
        class="demo-ruleForm"
      >
        <el-form-item label="账号" prop="phone">
          <el-input
            type="text"
            v-model="ruleForm.phone"
            autocomplete="off"
            placeholder="手机号"
          ></el-input>
        </el-form-item>

        <el-form-item label="密码" prop="password">
          <el-input
            type="password"
            v-model="ruleForm.password"
            autocomplete="off"
          ></el-input>
        </el-form-item>

        <el-form-item>
          <el-button
            type="primary"
            class="button"
            @click="submitForm('ruleForm')"
            >登陆</el-button
          >
        </el-form-item>
      </el-form>
    </div>

</template>


<script>
export default {
  data() {
    return {
      ruleForm: {
        phone: "15671151238",
        password: "lazycrocy",
      },
      rules: {
        password: [{ required: true, message: "请输入密码", trigger: "blur" }],
        phone: [
          { required: true, message: "请输入账号", trigger: "blur" },
          { min: 11, max: 11, message: "请输入正确的手机号码", trigger: "blur" },
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
            .post("/user/login", this.ruleForm)
            .then((res) => {
              //this.$store.commit("SET_USER", res.data.data.user);
              //this.$store.commit("SET_USERINFO", res.data.data.userinfo);
              this.$store.commit("LOG_IN",res.data.data.user, res.data.data.userinfo);
              this.$router.push("/index")
            });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
  },
};
</script>

<style scoped>
.cent {
  height: auto;
  width: auto;
  margin-top: 5%;
  margin-left: 0%;
}

.button {
  margin-left: 26%;
}



</style>