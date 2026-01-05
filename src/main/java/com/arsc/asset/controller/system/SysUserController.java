package com.arsc.asset.controller.system;

import com.arsc.asset.common.core.domain.result.AjaxResult;
import com.arsc.asset.system.entity.SysUser;
import com.arsc.asset.system.service.ISysUserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system/user")
public class SysUserController {
	
	@Resource
	private ISysUserService userService;
	
	@GetMapping("/list")
	public AjaxResult list(SysUser user) {
		List<SysUser> users = userService.list();
		return AjaxResult.success(users);
	}

}
