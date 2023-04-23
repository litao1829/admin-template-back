package com.litao.rbac.dao;

import com.litao.mybatis.dao.BaseDao;
import com.litao.rbac.entity.SysMenuEntity;
import org.apache.ibatis.annotations.Mapper;


/**
 * 菜单管理 dao
 *
 * @author
 */
@Mapper
public interface SysMenuDao extends BaseDao<SysMenuEntity> {

}