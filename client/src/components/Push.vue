<template>
<div id="trans">
<el-form ref="form" :model="form" label-width="80px">
  <el-form-item label="欢迎您，">
     <el-input :placeholder=username :disabled="true"></el-input>   
  </el-form-item>
  <el-form-item label="充值金额">
    <el-input v-model="form.money"></el-input>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="onSubmit">确认充值</el-button>
  </el-form-item>
</el-form>
</div>
</template>

<script>
  export default {
    name : "Push",
    data() {
      return {
        form: {
            money: 0,
        },
        dialog: true,
      }
    },
    props: {
      username: String
    },
    methods: {
      onSubmit() {
        if(this.form.money <= 0) {
          this.$notify.error({
            title: '充值失败',
            message: '充值数目应大于零'
          });
          return 
        }
        this.$http({
          method : 'post',
          // url : "http://150.158.93.128:8080" + '/payforit',
          url : "http://localhost:8080" + '/payforit',
          data : {
            id : "0",
            amount : this.form.money.toString(),
            name : '账户充值'
          }
        })
        .then(response=>{
          const divPay = document.createElement("div")
          divPay.innerHTML = response.data
          document.body.appendChild(divPay)
          document.forms[2].submit()
        })
      }
    }
  }
</script>

<style>
#trans {
    background-color: #D3DCE6;
    margin-top: 30%;
    padding: 5px;
    text-align: center;
    box-shadow: 0 5px 15px -2px rgba(10,16,34,.4)!important;
      border-radius: 10px;

}
</style>