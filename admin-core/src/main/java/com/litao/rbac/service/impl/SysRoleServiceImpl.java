package com.litao.rbac.service.impl;

import com.litao.mybatis.service.impl.BaseServiceImpl;
import com.litao.rbac.dao.SysRoleDao;
import com.litao.rbac.entity.SysRoleEntity;
import com.litao.rbac.service.SysRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * 系统角色业务实现类
 *
 * @author
 */
@Service
@AllArgsConstructor
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {

}
