<template>

</template>
 
<script>
  export default{
    name:'Login',
    data:function(){
      return {
        username:'admin',
        password:'123456'
      }
    },
    methods:{
        doLogin() {
            this.$http({
                method: 'post',
                url: '/login',
                data: {
                    username : this.username,
                    password : this.password
                }
            })
            .then(response=>{
                if(response.data.length == 1) {
                    this.$notify({
                        title: '登录成功',
                        message: '登录成功',
                        type: 'success'
                    });
                    this.$router.push({
                      // path:'/home',
                      name:'home',
                      params:{
                        username: this.username,
                        password: this.password
                      }
                    })
                    // this.$router.push('home?username='+this.username+'&password='+this.password)
                    // this.$router.go()
                } else {
                    this.$notify.error({
                        title: '登录失败',
                        message: '账号或密码错误'
                    });
                    this.username = ""
                    this.password = ""
                }
            })
        }
    }
  }
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
</style>