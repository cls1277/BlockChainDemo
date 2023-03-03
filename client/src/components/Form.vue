<template>
    <div id="trans">
    <el-form ref="form" :model="form" label-width="80px">
    <el-form-item label="转账数目">
        <el-input v-model="form.count"></el-input>
    </el-form-item>
    <el-form-item label="使用资金">
        <el-select v-model="form.money" placeholder="选择资金">
        <el-option v-for="it in formdata" :value=it.blockid :label=it.label></el-option>
        </el-select>
    </el-form-item>
    <!-- <el-form-item label="输入私钥">
        <el-input v-model="form.priv"></el-input>
    </el-form-item> -->
    <el-form-item label="转账备注">
        <el-input type="textarea" v-model="form.msg"></el-input>
        <!-- <el-input v-model="form.msg"></el-input> -->
    </el-form-item>
    <el-form-item>
        <el-button type="primary" @click="onSubmit">确定转账</el-button>
    </el-form-item>
    </el-form>
    </div>
</template>

<script>
  const Base64 = require('js-base64').Base64
  const sha256 = require('js-sha256').sha256

  export default {
    name : "Form" , 
    data() {
      return {
        form: {
            msg : '',
            money : 0, // 使用的资金的下标
            username: '',

            senderaddress : '',
            receiveraddress : '', //这个应该是固定的值
            count : 0,
            senderpublic : '',
            signature: '',
        },
        publickey : '',
        privatekey: ''
      }
    },
    props: {
      formdata: Array
    },
    methods: {
      // 子组件向父组件传值
      onSubmit() {
        // 在这里求对应的签名

        this.$emit('func', this.form)
        // console.log(this.form)
        // console.log('submit!')
      },
    }
  }
</script>

<style>
#trans {
    background-color: #D3DCE6;
    margin-top: 30%;
    padding: 5px;
    /* position: absolute; */
    /* top: 50%; */
    text-align: center;
    /* width: 200px; */
    /* align-items: center; */
    box-shadow: 0 5px 15px -2px rgba(10,16,34,.4)!important;
      border-radius: 10px;

}
</style>