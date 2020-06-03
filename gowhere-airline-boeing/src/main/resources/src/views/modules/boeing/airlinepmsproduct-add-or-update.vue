<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
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
    <el-form-item label="" prop="today">
      <el-input v-model="dataForm.today" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="price">
      <el-input v-model="dataForm.price" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="num">
      <el-input v-model="dataForm.num" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="planeId">
      <el-input v-model="dataForm.planeId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="productId">
      <el-input v-model="dataForm.productId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="deleted">
      <el-input v-model="dataForm.deleted" placeholder=""></el-input>
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
          fromAirportId: '',
          fromTime: '',
          toAirportId: '',
          toTime: '',
          today: '',
          price: '',
          num: '',
          planeId: '',
          productId: '',
          deleted: ''
        },
        dataRule: {
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
          today: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          price: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          num: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          planeId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          productId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          deleted: [
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
              url: this.$http.adornUrl(`/boeing/airlinepmsproduct/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.fromAirportId = data.airlinePmsProduct.fromAirportId
                this.dataForm.fromTime = data.airlinePmsProduct.fromTime
                this.dataForm.toAirportId = data.airlinePmsProduct.toAirportId
                this.dataForm.toTime = data.airlinePmsProduct.toTime
                this.dataForm.today = data.airlinePmsProduct.today
                this.dataForm.price = data.airlinePmsProduct.price
                this.dataForm.num = data.airlinePmsProduct.num
                this.dataForm.planeId = data.airlinePmsProduct.planeId
                this.dataForm.productId = data.airlinePmsProduct.productId
                this.dataForm.deleted = data.airlinePmsProduct.deleted
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
              url: this.$http.adornUrl(`/boeing/airlinepmsproduct/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'fromAirportId': this.dataForm.fromAirportId,
                'fromTime': this.dataForm.fromTime,
                'toAirportId': this.dataForm.toAirportId,
                'toTime': this.dataForm.toTime,
                'today': this.dataForm.today,
                'price': this.dataForm.price,
                'num': this.dataForm.num,
                'planeId': this.dataForm.planeId,
                'productId': this.dataForm.productId,
                'deleted': this.dataForm.deleted
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
