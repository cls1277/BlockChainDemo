<template>
    <el-dialog
  :visible.sync="dialogVisible"
  :before-close="handleClose">
  <img class="tu" src="https://pic1.imgdb.cn/item/633af21b16f2c2beb17a4a65.png">
</el-dialog>
</template>


<script>

  export default {
    name : "Dialog",
    data() {
      return {
        // dialogVisible: false
      };
    },
    props : {
        dialogVisible : Boolean
    },
    methods: {
      handleClose() {
        this.dialogVisible = false
        this.$emit("func1", false)
      }
    }
  };
</script>

<style>
.el-dialog {
    width: 300px;
    height: 300px;
}

.tu {
    height: 200px;
    width: 200px;
}
</style>