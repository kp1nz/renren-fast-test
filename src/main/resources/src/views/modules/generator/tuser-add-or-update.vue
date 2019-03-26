<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="用户名" prop="username">
      <el-input v-model="dataForm.username" placeholder="用户名"></el-input>
    </el-form-item>
    <el-form-item label="用户密码,MD5加密" prop="password">
      <el-input v-model="dataForm.password" placeholder="用户密码,MD5加密"></el-input>
    </el-form-item>
    <el-form-item label="用户email" prop="email">
      <el-input v-model="dataForm.email" placeholder="用户email"></el-input>
    </el-form-item>
    <el-form-item label="用户phone" prop="phone">
      <el-input v-model="dataForm.phone" placeholder="用户phone"></el-input>
    </el-form-item>
    <el-form-item label="找回密码问题" prop="question">
      <el-input v-model="dataForm.question" placeholder="找回密码问题"></el-input>
    </el-form-item>
    <el-form-item label="找回密码答案" prop="answer">
      <el-input v-model="dataForm.answer" placeholder="找回密码答案"></el-input>
    </el-form-item>
    <el-form-item label="角色0-管理员,1-普通用户" prop="role">
      <el-input v-model="dataForm.role" placeholder="角色0-管理员,1-普通用户"></el-input>
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
          username: '',
          password: '',
          email: '',
          phone: '',
          question: '',
          answer: '',
          role: '',
          createTime: '',
          updateTime: ''
        },
        dataRule: {
          username: [
            { required: true, message: '用户名不能为空', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '用户密码,MD5加密不能为空', trigger: 'blur' }
          ],
          email: [
            { required: true, message: '用户email不能为空', trigger: 'blur' }
          ],
          phone: [
            { required: true, message: '用户phone不能为空', trigger: 'blur' }
          ],
          question: [
            { required: true, message: '找回密码问题不能为空', trigger: 'blur' }
          ],
          answer: [
            { required: true, message: '找回密码答案不能为空', trigger: 'blur' }
          ],
          role: [
            { required: true, message: '角色0-管理员,1-普通用户不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/generator/tuser/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.username = data.tuser.username
                this.dataForm.password = data.tuser.password
                this.dataForm.email = data.tuser.email
                this.dataForm.phone = data.tuser.phone
                this.dataForm.question = data.tuser.question
                this.dataForm.answer = data.tuser.answer
                this.dataForm.role = data.tuser.role
                this.dataForm.createTime = data.tuser.createTime
                this.dataForm.updateTime = data.tuser.updateTime
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
              url: this.$http.adornUrl(`/generator/tuser/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'username': this.dataForm.username,
                'password': this.dataForm.password,
                'email': this.dataForm.email,
                'phone': this.dataForm.phone,
                'question': this.dataForm.question,
                'answer': this.dataForm.answer,
                'role': this.dataForm.role,
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
