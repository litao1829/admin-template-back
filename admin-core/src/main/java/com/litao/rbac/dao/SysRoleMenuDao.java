package com.litao.rbac.dao;

import com.litao.mybatis.dao.BaseDao;
import com.litao.rbac.entity.SysRoleMenuEntity;
import org.apache.ibatis.annotations.Mapper;


/**
 * 角色与菜单对应关系 dao
 *
 * @author
 */
@Mapper
public interface SysRoleMenuDao extends BaseDao<SysRoleMenuEntity> {
}
