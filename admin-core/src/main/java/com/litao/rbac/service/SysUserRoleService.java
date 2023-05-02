package com.litao.rbac.service;


import com.litao.mybatis.service.BaseService;
import com.litao.rbac.entity.SysUserRoleEntity;

import java.util.List;

/**
 * 用户角色关系业务接口
 *
 * @author
 */
public interface SysUserRoleService extends BaseService<SysUserRoleEntity> {
    /**
     * 保存或修改
     * @param userId 用户ID
     * @param roleIdList 角色列表
     */
    void saveOrUpdate(Long userId,List<Long> roleIdList);

    /**
     * 分配角色给用户列表
     * @param roleId 角色ID
     * @param userIDList 用户ID列表
     */
    void saveUserList(Long roleId,List<Long> userIDList);

    /**
     * 根据角色id列表，删除用户角色关系
     * @param roleIdList 角色id列表
     */
    void deleteByRoleIdList(List<Long> roleIdList);

    /**
     * 根据用户id列表，删除用户关系角色
     * @param userIdList 用户id列表
     */
    void deleteByUserIdList(List<Long> userIdList);

    /**
     * 根据角色id、用户id列表，删除用户角色关系
     * @param roleId 角色id
     * @param userIdList 用户id列表
     */
    void deleteByUserIdList(Long roleId,List<Long> userIdList);

    /**
     * 角色ID列表
     * @param id
     * @return
     */
    List<Long> getRoleIdList(Long id);
}