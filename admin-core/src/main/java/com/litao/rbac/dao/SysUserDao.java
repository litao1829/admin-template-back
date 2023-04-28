package com.litao.rbac.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.litao.mybatis.dao.BaseDao;
import com.litao.rbac.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


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

    /**
     *根据条件查询用户数据
     *return List<SysUserEntity>
     * */
    List<SysUserEntity> getList(Map<String,Object> params);

    /**
     *根据id查询用户数据
     *return SysUserEntity
     * */
    SysUserEntity getByid(@Param("id")Long id);


}