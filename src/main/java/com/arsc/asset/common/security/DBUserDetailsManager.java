package com.arsc.asset.common.security;

import com.arsc.asset.system.entity.SysUser;
import com.arsc.asset.system.mapper.SysUserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Component
public class DBUserDetailsManager implements UserDetailsManager, UserDetailsPasswordService {

    @Resource
    private SysUserMapper userMapper;

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        return null;
    }

    @Override
    public void createUser(UserDetails userDetails) {
        SysUser user = new SysUser();
        user.setUserName(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        userMapper.insert(user);
    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        SysUser user = userMapper.selectOne(queryWrapper);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }else{
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            return new User(
                    user.getUserName(),
                    user.getPassword(),
                    !Objects.equals(user.getDelFlag(), "2"),
                    true,
                    true,
                    true,
                    authorities
                    );
        }
    }
}
