package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-26 14:26:50
 */
@Data
@TableName("t_product")
public class TProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品id
	 */
	@TableId
	private Integer id;
	/**
	 * 类别id，对应neuedu_category表的主键
	 */
	private Integer categoryId;
	/**
	 * 商品名称
	 */
	private String name;
	/**
	 * 商品副标题
	 */
	private String subtitle;
	/**
	 * 产品主图，url相对地址
	 */
	private String mainImage;
	/**
	 * 图片地址，json格式
	 */
	private String subImages;
	/**
	 * 商品详情
	 */
	private String detail;
	/**
	 * 价格，单位-元保留两位小数
	 */
	private BigDecimal price;
	/**
	 * 库存数量
	 */
	private Integer stock;
	/**
	 * 商品状态，1-在售 2-下架 3-删除
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 最后一次更新时间
	 */
	private Date updateTime;

}
