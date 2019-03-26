<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="userId">
      <el-input v-model="dataForm.userId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="订单号" prop="orderNo">
      <el-input v-model="dataForm.orderNo" placeholder="订单号"></el-input>
    </el-form-item>
    <el-form-item label="" prop="shippingId">
      <el-input v-model="dataForm.shippingId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="实际付款金额，单位元，保留两位小数" prop="payment">
      <el-input v-model="dataForm.payment" placeholder="实际付款金额，单位元，保留两位小数"></el-input>
    </el-form-item>
    <el-form-item label="支付类型，1-在线支付" prop="paymentType">
      <el-input v-model="dataForm.paymentType" placeholder="支付类型，1-在线支付"></el-input>
    </el-form-item>
    <el-form-item label="运费，单位是元" prop="postage">
      <el-input v-model="dataForm.postage" placeholder="运费，单位是元"></el-input>
    </el-form-item>
    <el-form-item label="订单状态：0-已取消 10-未付款 20-已付款 40-已发货 50-交易成功 60-交易关闭" prop="status">
      <el-input v-model="dataForm.status" placeholder="订单状态：0-已取消 10-未付款 20-已付款 40-已发货 50-交易成功 60-交易关闭"></el-input>
    </el-form-item>
    <el-form-item label="支付时间" prop="paymentTime">
      <el-input v-model="dataForm.paymentTime" placeholder="支付时间"></el-input>
    </el-form-item>
    <el-form-item label="发货时间" prop="sendTime">
      <el-input v-model="dataForm.sendTime" placeholder="发货时间"></el-input>
    </el-form-item>
    <el-form-item label="交易完成时间" prop="endTime">
      <el-input v-model="dataForm.endTime" placeholder="交易完成时间"></el-input>
    </el-form-item>
    <el-form-item label="交易关闭时间" prop="closeTime">
      <el-input v-model="dataForm.closeTime" placeholder="交易关闭时间"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="最后一次更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="最后一次更新时间"></el-input>
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
          userId: '',
          orderNo: '',
          shippingId: '',
          payment: '',
          paymentType: '',
          postage: '',
          status: '',
          paymentTime: '',
          sendTime: '',
          endTime: '',
          closeTime: '',
          createTime: '',
          updateTime: ''
        },
        dataRule: {
          userId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          orderNo: [
            { required: true, message: '订单号不能为空', trigger: 'blur' }
          ],
          shippingId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          payment: [
            { required: true, message: '实际付款金额，单位元，保留两位小数不能为空', trigger: 'blur' }
          ],
          paymentType: [
            { required: true, message: '支付类型，1-在线支付不能为空', trigger: 'blur' }
          ],
          postage: [
            { required: true, message: '运费，单位是元不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '订单状态：0-已取消 10-未付款 20-已付款 40-已发货 50-交易成功 60-交易关闭不能为空', trigger: 'blur' }
          ],
          paymentTime: [
            { required: true, message: '支付时间不能为空', trigger: 'blur' }
          ],
          sendTime: [
            { required: true, message: '发货时间不能为空', trigger: 'blur' }
          ],
          endTime: [
            { required: true, message: '交易完成时间不能为空', trigger: 'blur' }
          ],
          closeTime: [
            { required: true, message: '交易关闭时间不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '最后一次更新时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/generator/torder/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.userId = data.torder.userId
                this.dataForm.orderNo = data.torder.orderNo
                this.dataForm.shippingId = data.torder.shippingId
                this.dataForm.payment = data.torder.payment
                this.dataForm.paymentType = data.torder.paymentType
                this.dataForm.postage = data.torder.postage
                this.dataForm.status = data.torder.status
                this.dataForm.paymentTime = data.torder.paymentTime
                this.dataForm.sendTime = data.torder.sendTime
                this.dataForm.endTime = data.torder.endTime
                this.dataForm.closeTime = data.torder.closeTime
                this.dataForm.createTime = data.torder.createTime
                this.dataForm.updateTime = data.torder.updateTime
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
              url: this.$http.adornUrl(`/generator/torder/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'userId': this.dataForm.userId,
                'orderNo': this.dataForm.orderNo,
                'shippingId': this.dataForm.shippingId,
                'payment': this.dataForm.payment,
                'paymentType': this.dataForm.paymentType,
                'postage': this.dataForm.postage,
                'status': this.dataForm.status,
                'paymentTime': this.dataForm.paymentTime,
                'sendTime': this.dataForm.sendTime,
                'endTime': this.dataForm.endTime,
                'closeTime': this.dataForm.closeTime,
                'createTime': this.dataForm.createTime,
                'updateTime': this.dataForm.updateTime
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
