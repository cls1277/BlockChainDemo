const { defineConfig } = require('@vue/cli-service')
module.exports = {
  pages: {
      index: {
          entry: 'src/entry/index.js',
          template: 'public/index.html',
          filename: 'index.html',
          title: 'login - cls1277',
          chunks: ['chunk-vendors', 'chunk-common', 'index']
      },
      home: {
          entry: 'src/entry/home.js',
          template: 'public/home.html',
          filename: 'home.html',
          title: 'home - cls1277',
          chunks: ['chunk-vendors', 'chunk-common', 'home']
      },
  },
//   devServer : {
//         // Paths
//         // assetsSubDirectory: 'static',
//         // assetsPublicPath: '/',
//         proxy: {
//             '/api':{
//                 target:'http://150.158.93.128:8080', //后期可以改
//                 changeOrigin:true,
//                 pathRewrite:{
//                 '^/api': ''
//                 }
//             }
//         }, //配置跨域支持
//     }
}