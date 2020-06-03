<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="airportId">
      <el-input v-model="dataForm.airportId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="regionId">
      <el-input v-model="dataForm.regionId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="deleted">
      <el-input v-model="dataForm.deleted" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="airportName">
      <el-input v-model="dataForm.airportName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="regionName">
      <el-input v-model="dataForm.regionName" placeholder=""></el-input>
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
          airportId: '',
          regionId: '',
          id: 0,
          deleted: '',
          airportName: '',
          regionName: ''
        },
        dataRule: {
          airportId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          regionId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          deleted: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          airportName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          regionName: [
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
              url: this.$http.adornUrl(`/boeing/airlinepmsairportregion/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.airportId = data.airlinePmsAirportRegion.airportId
                this.dataForm.regionId = data.airlinePmsAirportRegion.regionId
                this.dataForm.deleted = data.airlinePmsAirportRegion.deleted
                this.dataForm.airportName = data.airlinePmsAirportRegion.airportName
                this.dataForm.regionName = data.airlinePmsAirportRegion.regionName
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
              url: this.$http.adornUrl(`/boeing/airlinepmsairportregion/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'airportId': this.dataForm.airportId,
                'regionId': this.dataForm.regionId,
                'id': this.dataForm.id || undefined,
                'deleted': this.dataForm.deleted,
                'airportName': this.dataForm.airportName,
                'regionName': this.dataForm.regionName
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
