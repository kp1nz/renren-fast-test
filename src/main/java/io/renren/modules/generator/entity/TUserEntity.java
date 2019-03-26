package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-03-26 13:43:38
 */
@Data
@TableName("t_user")
public class TUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	@TableId
	private Integer id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 用户密码,MD5加密
	 */
	private String password;
	/**
	 * 用户email
	 */
	private String email;
	/**
	 * 用户phone
	 */
	private String phone;
	/**
	 * 找回密码问题
	 */
	private String question;
	/**
	 * 找回密码答案
	 */
	private String answer;
	/**
	 * 角色0-管理员,1-普通用户
	 */
	private Integer role;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 最后一次更新时间
	 */
	private Date updateTime;

}
