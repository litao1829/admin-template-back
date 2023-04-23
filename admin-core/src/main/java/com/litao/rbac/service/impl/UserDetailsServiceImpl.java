package com.litao.rbac.service.impl;

import com.litao.rbac.dao.SysUserDao;
import com.litao.rbac.entity.SysUserEntity;
import com.litao.rbac.service.SysUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * 我们的账号密码是存储在数据库里面的，SpringSecurity为我们提供了UserDetailsService接口，
 * 只需要实现 UserDetailsService接口
 *
 * @author
 **/
@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final SysUserDetailsService sysUserDetailsService;
    private final SysUserDao sysUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserEntity userEntity = sysUserDao.getByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }

        return sysUserDetailsService.getUserDetails(userEntity);
    }

}