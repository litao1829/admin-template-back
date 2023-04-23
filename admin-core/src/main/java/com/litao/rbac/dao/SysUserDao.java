package com.litao.rbac.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.litao.mybatis.dao.BaseDao;
import com.litao.rbac.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;


/**
 * 系统用户管理 dao
 *
 * @author
 */
@Mapper
public interface SysUserDao extends BaseDao<SysUserEntity> {
    default SysUserEntity getByUsername(String username){
        return this.selectOne(new QueryWrapper<SysUserEntity>().eq("username", username));
    }
}