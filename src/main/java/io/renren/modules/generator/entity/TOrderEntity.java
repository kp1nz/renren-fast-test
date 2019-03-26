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
@TableName("t_order")
public class TOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 订单id
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer userId;
	/**
	 * 订单号
	 */
	private Long orderNo;
	/**
	 * 
	 */
	private Integer shippingId;
	/**
	 * 实际付款金额，单位元，保留两位小数
	 */
	private BigDecimal payment;
	/**
	 * 支付类型，1-在线支付
	 */
	private Integer paymentType;
	/**
	 * 运费，单位是元
	 */
	private Integer postage;
	/**
	 * 订单状态：0-已取消 10-未付款 20-已付款 40-已发货 50-交易成功 60-交易关闭
	 */
	private Integer status;
	/**
	 * 支付时间
	 */
	private Date paymentTime;
	/**
	 * 发货时间
	 */
	private Date sendTime;
	/**
	 * 交易完成时间
	 */
	private Date endTime;
	/**
	 * 交易关闭时间
	 */
	private Date closeTime;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 最后一次更新时间
	 */
	private Date updateTime;

}
