package com.arsc.asset.controller.system;

import com.arsc.asset.common.core.domain.result.AjaxResult;
import com.arsc.asset.system.entity.SysUser;
import com.arsc.asset.system.service.ISysUserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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

	@PostMapping
	public AjaxResult add(@RequestBody SysUser user){
		boolean save = userService.saveUserDetails(user);
		if(save){
			return AjaxResult.success("新增用户成功");
		}else{
			return AjaxResult.error("新增用户失败");
		}
	}
}
