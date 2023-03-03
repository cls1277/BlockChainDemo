<template>
  <div id="app">
    <el-container>
      <el-aside width="250px">
        <Form :formdata="havemoney" @func="getForm"></Form>
        <Push :username="username" @funcc="getVis"></Push>
      </el-aside>
      <el-main>
        <!-- Main -->
        <div class="balance">
          <div class="balancenum">
            <p class="mybalance-style">{{ balance }}</p>
            <p style="color: #fff; font-size: 30px">余额(￥)</p>
          </div>
        </div>

        <Block
          v-for="block in blocks"
          :blockid="block.blockid"
          :blocktime="block.blocktime"
          :count="block.count"
          :message="block.message"
          :nowhash="block.nowhash"
          :prehash="block.prehash"
          :status="block.status"
          :username="block.username"
        ></Block>

        <Dialog :dialogVisible="dialogvis" @func1="getVis"> </Dialog>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import Form from "@/components/Form.vue";
import Push from "@/components/Push.vue";
import Block from "@/components/Block.vue";
import Dialog from "@/components/Dialog.vue";
import { setCookie, getCookie } from "@/utils/cookies";
import { hextob64u, KEYUTIL, KJUR } from "jsrsasign";

export default {
  name: "Home",
  components: {
    Form,
    Block,
    Push,
    Dialog,
  },
  data() {
    return {
      balance: 1277,
      username: "",
      password: "",
      blocks: [
        {
          blockid: 100,
          blocktime: "error",
          prehash: "error",
          nowhash: "error",
          username: "error",
          count: 1277,
          status: "UnSpent",
          message: "error",
        },
      ],
      havemoney: [],
      form: {
        count: 0,
        msg: "",
        // 使用的资金的下标
        money: 0,
        username: "",
        kkey: "",
        predata: "",
      },
      dialogvis: false,
    };
  },
  mounted: function () {
    // 检测是否真的登录，跳转到login页面
    // alert(this.$route.query.username)
    this.username = this.$route.query.username;
    let iscool = getCookie(this.username);
    // alert(this.username)
    if (iscool == false || this.username == "" || this.username == null) {
      this.$notify.error({
        title: "登录失败",
        message: "请先登录",
      });
      // this.$router.replace({
      //   name:'index'
      // })
      this.$router.replace("/");
      // this.$router.go()
      // 这里现在只是显示登陆错误，但是没有任何跳转
      return;
    }
    // this.password = this.$route.query.password
    console.log(this.username);
    // console.log(this.password)
    // 连接数据库获取余额
    this.$http({
      method: "post",
      // url: "http://150.158.93.128:8080" + "/getbanlance",
      url: "http://localhost:8080" + "/getbanlance",
      data: {
        username: this.username,
        password: "",
      },
      // headers: {
      //   "Content-Type": "application/x-www-form-urlencoded",
      // },
    }).then((response) => {
      if (response.data.length != 0) {
        this.balance = response.data;
        // 连接数据库获取区块链
        this.$http({
          method: "post",
          // url: "http://150.158.93.128:8080" + "/getChain",
          url: "http://localhost:8080" + "/getChain",
          data: {},
          // headers: {
          //   "Content-Type": "application/x-www-form-urlencoded",
          // },
        }).then((response) => {
          this.blocks = response.data;
          //更新使用资金两个条件：
          //1.UnSpent
          //2.username
          for (let block of this.blocks) {
            if (
              block.count == 0 ||
              block.status != "UnSpent" ||
              block.username != this.username
            ) {
              continue;
            }
            let temp = block;
            temp.label = "块号:" + temp.blockid + ",金额:￥" + temp.count;
            // this.havemoney.push(block)
            this.havemoney.push(temp);
          }
        });
      } else {
        this.$notify.error({
          title: "登录失败",
          message: "请先登录",
        });
        console.log("error");
      }
    });
  },
  methods: {
    getVis(dialogvis) {
      console.log(dialogvis);
      this.dialogvis = dialogvis;
      console.log(this.dialogvis);
    },
    getForm(form) {
      console.log(form);
      this.form = form;
      if (this.form.count == 0) {
        console.log("less than");
        this.$notify.error({
          title: "转账失败",
          message: "转账数目应大于零",
        });
        return;
      }

      if (this.form.count > this.blocks[this.form.money - 1].count) {
        console.log("more than");
        this.$notify.error({
          title: "转账失败",
          message: "转账数目大于资金数目",
        });
        return;
      }

      this.form.username = this.username;

      this.$http({
        method: "get",
        // url: "http://150.158.93.128:8080" + "/getallkey",
        url: "http://localhost:8080" + "/getallkey",
        params: {
          username: this.username,
        },
      }).then((response) => {
        this.publickey = response.data.publickey;
        let pub = KEYUTIL.getKey(this.publickey);
        let data =
          this.form.money +
          this.form.count +
          this.form.msg +
          this.form.username;
        this.form.predata = data;
        data = KJUR.crypto.Cipher.encrypt(data, pub);
        this.form.kkey = hextob64u(data);
        this.$http({
          method: "post",
          // url: "http://150.158.93.128:8080" + "/update",
          url: "http://localhost:8080" + "/update",
          data: this.form,
        }).then((response) => {
          if (response.data.length == 0) {
            this.$notify({
              title: "警告",
              message: "交易信息已被篡改，终止交易",
              type: "warning",
            });
          } else {
            this.$notify({
              title: "转账成功",
              message: "转账成功",
              type: "success",
            });
            this.$router.go();
          }
        });
      });
    },
  },
};
</script>

<style>
body,
html {
  height: 100%;
  width: 100%;
  margin: 0;
}

.mybalance-style {
  color: #fff;
  text-align: center;
  height: 50px;
  margin: 0 auto;
  font-size: 48pt;
  align-items: center;
}

.balance {
  /* background-color: red; */
  height: 200px;
}

.balancenum {
  /* box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04); */
  box-shadow: 0 5px 15px -2px rgba(10, 16, 34, 0.4) !important;
  background: linear-gradient(45deg, #4f00bc, #29abe2);
  /* background-color: yellow; */
  border-radius: 10px;

  height: 200px;
  width: 200px;
  /* margin-left: 50%; */
  margin: 0 auto;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  /* margin-top: 60px; */
  height: 100%;
  background-image: url("../../public/bg.jpg");
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}

.el-header,
.el-footer {
  /* background-color: #B3C0D1; */
  color: #333;
  text-align: center;
  line-height: 60px;
}

.el-aside {
  /* background-color: #D3DCE6; */
  color: #333;
  text-align: center;
  line-height: 200px;
  margin-left: 10px;
}

.el-main {
  /* background-color: #E9EEF3; */
  color: #333;
  text-align: center;
  line-height: 160px;
}

body > .el-container {
  margin-bottom: 40px;
}

.el-container {
  height: 100%;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}
</style>