package com.arsc.asset.controller.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arsc.asset.common.core.domain.result.AjaxResult;
import com.arsc.asset.system.entity.SysUser;
import com.arsc.asset.system.service.ISysUserService;

@RestController
@RequestMapping("/system/user")
public class SysUserController {
	
	@Autowired
	private ISysUserService userService;
	
	@GetMapping("/list")
	public AjaxResult list(SysUser user) {
		List<SysUser> users = userService.selectUserList(user);
		return AjaxResult.success(users);
	}

}
