package com.litao.rbac.service;

import com.litao.rbac.entity.SysUserEntity;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户详细信息接口
 * @author moqi
 */
public interface SysUserDetailsService {

    /**
     * 获取 UserDetails 对象
     */
    UserDetails getUserDetails(SysUserEntity userEntity);
}
