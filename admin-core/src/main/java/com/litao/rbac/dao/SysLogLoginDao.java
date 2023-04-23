package com.litao.rbac.dao;

import com.litao.mybatis.dao.BaseDao;
import com.litao.rbac.entity.SysLogLoginEntity;
import org.apache.ibatis.annotations.Mapper;


/**
 * 登录日志 dao
 *
 * @author
 **/
@Mapper
public interface SysLogLoginDao extends BaseDao<SysLogLoginEntity> {

}
