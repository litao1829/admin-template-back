package com.litao.rbac.dao;

import com.litao.mybatis.dao.BaseDao;
import com.litao.rbac.entity.SysRoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 角色管理 dao
 *
 * @author
 */
@Mapper
public interface SysRoleDao extends BaseDao<SysRoleEntity> {
    List<SysRoleEntity> getRoleList();
}
