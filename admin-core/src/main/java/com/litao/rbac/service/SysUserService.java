package com.litao.rbac.service;


import com.litao.mybatis.service.BaseService;
import com.litao.rbac.entity.SysUserEntity;

/**
 * 系统用户业务接口
 *
 * @author
 */
public interface SysUserService extends BaseService<SysUserEntity> {

    /**
     * 修改密码
     *
     * @param id          用户ID
     * @param newPassword 新密码
     */
    void updatePassword(Long id, String newPassword);

}
