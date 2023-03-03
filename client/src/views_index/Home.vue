<template>
  <div id="app">
    <div class="login-wrap">
      <el-form class="login-container">
        <h1 class="title">用户登陆</h1>
        <el-form-item>
          <el-input
            type="text"
            v-model="username"
            placeholder="用户账号"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-input
            type="password"
            v-model="password"
            placeholder="用户密码"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="doLogin" style="width: 100%"
            >登陆</el-button
          >
        </el-form-item>
        <el-row style="text-align: center; margin-top: -10px"> </el-row>
      </el-form>
    </div>
  </div>
</template>

<script>
// import Login from '@/components/Login.vue'
import { setCookie, getCookie } from "@/utils/cookies";

export default {
  name: "Home",
  components: {
    // Login
  },
  data: function () {
    return {
      username: "admin",
      password: "123456",
    };
  },
  methods: {
    doLogin() {
      this.$http({
        method: "post",
        // url: "http://150.158.93.128:8080" + "/login",
        url: "http://localhost:8080" + "/login",
        // contentType: 'application/json;charset=utf-8',
        data: {
          username: this.username,
          password: this.password,
        },
        // headers:{
        //   'Content-Type':'application/x-www-form-urlencoded',
        // },
      }).then((response) => {
        if (response.data.length == 1) {
          setCookie(this.username);
          this.$notify({
            title: "登录成功",
            message: "登录成功",
            type: "success",
          });
          this.$router.replace({
            path: "/home.html",
            name: "home",
            query: {
              username: this.username,
              // password: this.password
            },
          });
          this.$router.go();
        } else {
          this.$notify.error({
            title: "登录失败",
            message: "账号或密码错误",
          });
          this.password = "";
        }
      });
    },
  },
};
</script>

<style>
.login-wrap {
  box-sizing: border-box;
  width: 100%;
  height: 100%;
  padding-top: 10%;
  /* background-color: #112346;  */
  /* background-repeat: no-repeat; */
  /* background-position: center right; */
  /* background-size: 100%; */
}

.login-container {
  border-radius: 10px;
  margin: 0px auto;
  width: 350px;
  padding: 30px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  text-align: left;
  box-shadow: 0 0 20px 2px rgba(0, 0, 0, 0.1);
}

.title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}

body,
html {
  height: 100%;
  margin: 0;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  /* margin-top: 60px; */
  background-image: url("../../public/bg.jpg");
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
  height: 100%;
  widows: 100%;
}
</style>