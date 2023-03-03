<template>
    <div id='block'>
        <el-descriptions class="margin-top" title="" :column="2" size="medium" border>
        <el-descriptions-item>
        <template slot="label"><i class="el-icon-finished"></i>块号</template>
        <span>{{blockid}}</span>
        </el-descriptions-item>

        <el-descriptions-item>
        <template slot="label"><i class="el-icon-date"></i>时间</template>
        <span>{{blocktime}}</span>
        <!-- on Sun, 02 Oct 2022 08:51:46 GMT -->
        </el-descriptions-item>

        <el-descriptions-item>
        <template slot="label"><i class="el-icon-edit"></i>PreHash</template>
        <span>{{prehash}}</span>
        <!-- 0003f7afbd57c5f97830f7116167567266dbae68e941314d12cb35fafd834122 -->
        </el-descriptions-item>

        <el-descriptions-item>
        <template slot="label"><i class="el-icon-edit-outline"></i>NowHash</template>
        <span>{{nowhash}}</span>
        <!-- 00040fb18b68f8e6e4047d25f0a41dd37d213831a35c4ce424efd5bc61d636fe -->
        </el-descriptions-item>

        <el-descriptions-item>
        <template slot="label"><i class="el-icon-user"></i>用户</template>
        <span>{{username}}</span>
        <!-- cls1277 -->
        </el-descriptions-item>

        <el-descriptions-item>
        <template slot="label"><i class="el-icon-coin"></i>数目</template>
        <span>{{count}}</span>
        <!-- 100 -->
        </el-descriptions-item>

        <el-descriptions-item>
        <template slot="label"><i class="el-icon-star-off"></i>状态</template>
        <span>{{status}}</span>
        <!-- UnSpent -->
        </el-descriptions-item>

        <el-descriptions-item>
        <template slot="label"><i class="el-icon-more-outline"></i>备注</template>
        <span>{{message}}</span>
        <!-- 无 -->
        </el-descriptions-item>
        </el-descriptions>
    </div>
</template>

<script>
export default {
    name: 'Block',
    props: {
        blockid: Number,
        blocktime: String,
        prehash: String,
        nowhash: String,
        username: String,
        count: Number,
        status: String,
        message: String
    }
}
</script>

<style>
#block {
    margin-top: 20px;
    box-shadow: 0 5px 15px -2px rgba(10,16,34,.4)!important;
    border-radius: 10px;
}
</style>