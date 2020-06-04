<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="orderId">
      <el-input v-model="dataForm.orderId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="productId">
      <el-input v-model="dataForm.productId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="fromAirportId">
      <el-input v-model="dataForm.fromAirportId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="fromTime">
      <el-input v-model="dataForm.fromTime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="toAirportId">
      <el-input v-model="dataForm.toAirportId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="toTime">
      <el-input v-model="dataForm.toTime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="todayTime">
      <el-input v-model="dataForm.todayTime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="price">
      <el-input v-model="dataForm.price" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="planeId">
      <el-input v-model="dataForm.planeId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="info">
      <el-input v-model="dataForm.info" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="airlineName">
      <el-input v-model="dataForm.airlineName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="status">
      <el-input v-model="dataForm.status" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="num">
      <el-input v-model="dataForm.num" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          orderId: '',
          productId: '',
          fromAirportId: '',
          fromTime: '',
          toAirportId: '',
          toTime: '',
          todayTime: '',
          price: '',
          planeId: '',
          info: '',
          airlineName: '',
          status: '',
          num: ''
        },
        dataRule: {
          orderId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          productId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          fromAirportId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          fromTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          toAirportId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          toTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          todayTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          price: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          planeId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          info: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          airlineName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          num: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/amazon/webomsorderitem/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.orderId = data.webOmsOrderItem.orderId
                this.dataForm.productId = data.webOmsOrderItem.productId
                this.dataForm.fromAirportId = data.webOmsOrderItem.fromAirportId
                this.dataForm.fromTime = data.webOmsOrderItem.fromTime
                this.dataForm.toAirportId = data.webOmsOrderItem.toAirportId
                this.dataForm.toTime = data.webOmsOrderItem.toTime
                this.dataForm.todayTime = data.webOmsOrderItem.todayTime
                this.dataForm.price = data.webOmsOrderItem.price
                this.dataForm.planeId = data.webOmsOrderItem.planeId
                this.dataForm.info = data.webOmsOrderItem.info
                this.dataForm.airlineName = data.webOmsOrderItem.airlineName
                this.dataForm.status = data.webOmsOrderItem.status
                this.dataForm.num = data.webOmsOrderItem.num
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/amazon/webomsorderitem/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'orderId': this.dataForm.orderId,
                'productId': this.dataForm.productId,
                'fromAirportId': this.dataForm.fromAirportId,
                'fromTime': this.dataForm.fromTime,
                'toAirportId': this.dataForm.toAirportId,
                'toTime': this.dataForm.toTime,
                'todayTime': this.dataForm.todayTime,
                'price': this.dataForm.price,
                'planeId': this.dataForm.planeId,
                'info': this.dataForm.info,
                'airlineName': this.dataForm.airlineName,
                'status': this.dataForm.status,
                'num': this.dataForm.num
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
