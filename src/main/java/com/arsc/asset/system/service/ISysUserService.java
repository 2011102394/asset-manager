package com.arsc.asset.system.service;

import java.util.List;

import com.arsc.asset.system.entity.SysUser;

/**
 * 
 * @ClassName: ISysUserService
 * @Description: 用户 业务层
 * @author zhangcj
 * @date 2026-01-05 09:06:33
 */
public interface ISysUserService {

	/**
	 * 
	 * @MethodName: selectUserList
	 * @Description: 查询用户列表
	 * @author zhangcj
	 * @param user
	 * @return List<SysUser>
	 * @date 2026-01-05 09:31:41
	 */
	List<SysUser> selectUserList(SysUser user);

}
