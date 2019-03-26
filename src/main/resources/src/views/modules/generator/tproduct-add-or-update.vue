<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="类别id，对应neuedu_category表的主键" prop="categoryId">
      <el-input v-model="dataForm.categoryId" placeholder="类别id，对应neuedu_category表的主键"></el-input>
    </el-form-item>
    <el-form-item label="商品名称" prop="name">
      <el-input v-model="dataForm.name" placeholder="商品名称"></el-input>
    </el-form-item>
    <el-form-item label="商品副标题" prop="subtitle">
      <el-input v-model="dataForm.subtitle" placeholder="商品副标题"></el-input>
    </el-form-item>
    <el-form-item label="产品主图，url相对地址" prop="mainImage">
      <el-input v-model="dataForm.mainImage" placeholder="产品主图，url相对地址"></el-input>
    </el-form-item>
    <el-form-item label="图片地址，json格式" prop="subImages">
      <el-input v-model="dataForm.subImages" placeholder="图片地址，json格式"></el-input>
    </el-form-item>
    <el-form-item label="商品详情" prop="detail">
      <el-input v-model="dataForm.detail" placeholder="商品详情"></el-input>
    </el-form-item>
    <el-form-item label="价格，单位-元保留两位小数" prop="price">
      <el-input v-model="dataForm.price" placeholder="价格，单位-元保留两位小数"></el-input>
    </el-form-item>
    <el-form-item label="库存数量" prop="stock">
      <el-input v-model="dataForm.stock" placeholder="库存数量"></el-input>
    </el-form-item>
    <el-form-item label="商品状态，1-在售 2-下架 3-删除" prop="status">
      <el-input v-model="dataForm.status" placeholder="商品状态，1-在售 2-下架 3-删除"></el-input>
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
          categoryId: '',
          name: '',
          subtitle: '',
          mainImage: '',
          subImages: '',
          detail: '',
          price: '',
          stock: '',
          status: '',
          createTime: '',
          updateTime: ''
        },
        dataRule: {
          categoryId: [
            { required: true, message: '类别id，对应neuedu_category表的主键不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '商品名称不能为空', trigger: 'blur' }
          ],
          subtitle: [
            { required: true, message: '商品副标题不能为空', trigger: 'blur' }
          ],
          mainImage: [
            { required: true, message: '产品主图，url相对地址不能为空', trigger: 'blur' }
          ],
          subImages: [
            { required: true, message: '图片地址，json格式不能为空', trigger: 'blur' }
          ],
          detail: [
            { required: true, message: '商品详情不能为空', trigger: 'blur' }
          ],
          price: [
            { required: true, message: '价格，单位-元保留两位小数不能为空', trigger: 'blur' }
          ],
          stock: [
            { required: true, message: '库存数量不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '商品状态，1-在售 2-下架 3-删除不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/generator/tproduct/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.categoryId = data.tproduct.categoryId
                this.dataForm.name = data.tproduct.name
                this.dataForm.subtitle = data.tproduct.subtitle
                this.dataForm.mainImage = data.tproduct.mainImage
                this.dataForm.subImages = data.tproduct.subImages
                this.dataForm.detail = data.tproduct.detail
                this.dataForm.price = data.tproduct.price
                this.dataForm.stock = data.tproduct.stock
                this.dataForm.status = data.tproduct.status
                this.dataForm.createTime = data.tproduct.createTime
                this.dataForm.updateTime = data.tproduct.updateTime
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
              url: this.$http.adornUrl(`/generator/tproduct/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'categoryId': this.dataForm.categoryId,
                'name': this.dataForm.name,
                'subtitle': this.dataForm.subtitle,
                'mainImage': this.dataForm.mainImage,
                'subImages': this.dataForm.subImages,
                'detail': this.dataForm.detail,
                'price': this.dataForm.price,
                'stock': this.dataForm.stock,
                'status': this.dataForm.status,
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
