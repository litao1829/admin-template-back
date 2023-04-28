package com.litao.rbac.service;


import com.litao.mybatis.service.BaseService;
import com.litao.rbac.entity.SysUserRoleEntity;

import java.util.List;

/**
 * 用户角色关系业务接口
 *
 * @author
 */
public interface SysUserRoleService extends BaseService<SysUserRoleEntity> {
    List<Long> getRoleIdList(Long id);
}