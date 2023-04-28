package com.litao.rbac.service.impl;

import com.litao.mybatis.service.impl.BaseServiceImpl;
import com.litao.rbac.dao.SysUserRoleDao;
import com.litao.rbac.entity.SysUserRoleEntity;
import com.litao.rbac.service.SysUserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 用户角色关系业务实现类
 *
 * @author
 */
@Service
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRoleDao, SysUserRoleEntity> implements SysUserRoleService {
    @Override
    public List<Long> getRoleIdList(Long id) {
        List<Long> roleIdList = baseMapper.getRoleIdList(id);
        return roleIdList;
    }
}
