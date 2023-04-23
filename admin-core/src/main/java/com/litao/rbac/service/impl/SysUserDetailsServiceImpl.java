package com.litao.rbac.service.impl;

import com.litao.rbac.convert.SysUserConvert;
import com.litao.rbac.entity.SysUserEntity;
import com.litao.rbac.enums.UserStatusEnum;
import com.litao.rbac.service.SysUserDetailsService;
import com.litao.security.user.UserDetail;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


/**
 * 用户详细信息接口实现类
 *
 * @author
 */
@Service
@AllArgsConstructor
public class SysUserDetailsServiceImpl implements SysUserDetailsService {

    @Override
    public UserDetails getUserDetails(SysUserEntity userEntity) {
        // 转换成UserDetail对象
        UserDetail userDetail = SysUserConvert.INSTANCE.convertDetail(userEntity);

        // 账号不可用
        if (userEntity.getStatus() == UserStatusEnum.DISABLE.getValue()) {
            userDetail.setEnabled(false);
        }

        // 用户权限列表
        Set<String> authoritySet = new HashSet<>();
        userDetail.setAuthoritySet(authoritySet);

        return userDetail;
    }
}