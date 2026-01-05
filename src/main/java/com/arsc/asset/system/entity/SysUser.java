package com.arsc.asset.system.entity;

import java.util.Date;

import com.arsc.asset.common.core.domain.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @ClassName: SysUser
 * @Description: 系统用户实体类
 * @author zhangcj
 * @date 2026-01-05 08:44:00
 */
@EqualsAndHashCode(callSuper = false)
@Data
@TableName(value = "sys_user", schema = "public")
public class SysUser extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/** 用户ID */
	@TableId(value = "user_id", type = IdType.INPUT)
	private Long userId;

	/** 部门ID */
	private Long deptId;

	/** 用户账号 */
	private String userName;

	/** 用户昵称 */
	private String nickName;

	/** EPC编码 */
	private String epc;

	/** 用户邮箱 */
	private String email;

	/** 手机号码 */
	private String phonenumber;

	/** 用户性别 */
	private String sex;

	/** 用户头像 */
	private String avatar;

	/** 密码 */
	@JsonIgnore
	private String password;

	/** 账号状态（0正常 1停用） */
	private String status;

	/** 删除标志（0代表存在 2代表删除） */
	private String delFlag;

	/** 最后登录IP */
	private String loginIp;

	/** 最后登录时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date loginDate;

	/** 密码最后更新时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date pwdUpdateDate;

}
