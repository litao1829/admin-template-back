package com.litao.rbac.dao;

import com.litao.mybatis.dao.BaseDao;
import com.litao.rbac.entity.SysRoleMenuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 角色与菜单对应关系 dao
 *
 * @author
 */
@Mapper
public interface SysRoleMenuDao extends BaseDao<SysRoleMenuEntity> {
    /**
     * 根据角色ID，获取菜单ID列表
     */
    List<Long> getMenuIdList(@Param("roleId") Long roleId);
}
