package com.arsc.asset.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arsc.asset.system.entity.SysUser;
import com.arsc.asset.system.mapper.SysUserMapper;
import com.arsc.asset.system.service.ISysUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

@Service
public class SysUserServiceImpl implements ISysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public List<SysUser> selectUserList(SysUser user) {
		LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
		// 1. 等值查询：用户ID（精准匹配）
		queryWrapper.eq(user.getUserId() != null, SysUser::getUserId, user.getUserId());
		// 2. 等值查询：部门ID
		queryWrapper.eq(user.getDeptId() != null, SysUser::getDeptId, user.getDeptId());
		// 3. 等值查询：用户名（账号精准匹配）
		queryWrapper.eq(user.getUserName() != null && !user.getUserName().trim().isEmpty(), SysUser::getUserName,
				user.getUserName());
		// 4. 模糊查询：昵称【修复：trim去空格，避免空字符串干扰】
		queryWrapper.like(user.getNickName() != null && !user.getNickName().trim().isEmpty(), SysUser::getNickName,
				user.getNickName());
		// 5. 等值查询：用户状态（0-禁用 1-启用）
		queryWrapper.eq(user.getStatus() != null, SysUser::getStatus, user.getStatus());
		// 6. 等值查询：手机号
		queryWrapper.eq(user.getPhonenumber() != null && !user.getPhonenumber().trim().isEmpty(),
				SysUser::getPhonenumber, user.getPhonenumber());
		// 7. 模糊查询：邮箱
		queryWrapper.like(user.getEmail() != null && !user.getEmail().trim().isEmpty(), SysUser::getEmail,
				user.getEmail());
		// 8. 固定条件：只查未删除数据（业务必备）【强制字符串匹配，避免类型问题】
		queryWrapper.eq(SysUser::getDelFlag, "0");
		// 9. 排序：按创建时间降序（最新数据在前）
		queryWrapper.orderByDesc(SysUser::getCreateTime);
		// 执行查询
		return sysUserMapper.selectList(queryWrapper);
	}

}
