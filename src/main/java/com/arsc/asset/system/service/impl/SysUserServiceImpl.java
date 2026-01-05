package com.arsc.asset.system.service.impl;

import com.arsc.asset.common.security.DBUserDetailsManager;
import com.arsc.asset.system.entity.SysUser;
import com.arsc.asset.system.mapper.SysUserMapper;
import com.arsc.asset.system.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper,SysUser> implements ISysUserService {

    @Resource
    private DBUserDetailsManager dbUserDetailsManager;

    @Override
    public boolean saveUserDetails(SysUser user) {

        UserDetails userDetails = User.withUsername(user.getUserName())
                .password("{noop}"+user.getPassword())
                .build();
        dbUserDetailsManager.createUser(userDetails);
        return true;
    }
}
