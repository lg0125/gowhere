<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="orderId">
      <el-input v-model="dataForm.orderId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="memberId">
      <el-input v-model="dataForm.memberId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="memberName">
      <el-input v-model="dataForm.memberName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="amount">
      <el-input v-model="dataForm.amount" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="payName">
      <el-input v-model="dataForm.payName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="card">
      <el-input v-model="dataForm.card" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="memberPhone">
      <el-input v-model="dataForm.memberPhone" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="orderStatus">
      <el-input v-model="dataForm.orderStatus" placeholder=""></el-input>
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
          orderId: '',
          memberId: '',
          memberName: '',
          amount: '',
          payName: '',
          card: '',
          memberPhone: '',
          orderStatus: '',
          deleted: ''
        },
        dataRule: {
          orderId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          memberId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          memberName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          amount: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          payName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          card: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          memberPhone: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          orderStatus: [
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
              url: this.$http.adornUrl(`/amazon/webomsorder/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.orderId = data.webOmsOrder.orderId
                this.dataForm.memberId = data.webOmsOrder.memberId
                this.dataForm.memberName = data.webOmsOrder.memberName
                this.dataForm.amount = data.webOmsOrder.amount
                this.dataForm.payName = data.webOmsOrder.payName
                this.dataForm.card = data.webOmsOrder.card
                this.dataForm.memberPhone = data.webOmsOrder.memberPhone
                this.dataForm.orderStatus = data.webOmsOrder.orderStatus
                this.dataForm.deleted = data.webOmsOrder.deleted
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
              url: this.$http.adornUrl(`/amazon/webomsorder/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'orderId': this.dataForm.orderId,
                'memberId': this.dataForm.memberId,
                'memberName': this.dataForm.memberName,
                'amount': this.dataForm.amount,
                'payName': this.dataForm.payName,
                'card': this.dataForm.card,
                'memberPhone': this.dataForm.memberPhone,
                'orderStatus': this.dataForm.orderStatus,
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
