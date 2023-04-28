package com.litao.rbac.dao;

import com.litao.mybatis.dao.BaseDao;
import com.litao.rbac.entity.SysUserRoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 用户角色关系 dao
 *
 * @author
 */
@Mapper
public interface SysUserRoleDao extends BaseDao<SysUserRoleEntity> {
    List<Long> getRoleIdList(@Param("id")Long id);
}
