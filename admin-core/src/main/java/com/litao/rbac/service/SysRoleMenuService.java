package com.litao.rbac.service;


import com.litao.mybatis.service.BaseService;
import com.litao.rbac.entity.SysRoleMenuEntity;

import java.util.List;

/**
 * 角色与菜单对应关系业务接口
 *
 * @author
 */
public interface SysRoleMenuService extends BaseService<SysRoleMenuEntity> {
    /**
     *根据角色ID，获取菜单ID列表
     * @param roleId 角色ID
     * @return
     */
    List<Long> getMenuIdList(Long roleId);

    /**
     * 保存或修改
     * @param roleId 角色ID
     * @param menuIdList 菜单ID列表
     */
    void saveOrUpdate(Long roleId,List<Long> menuIdList);

    /**
     * 根据角色ID列表，删除角色菜单关系
     * @param roleIdList 角色id列表
     */
    void deleteByRoleIdList(List<Long> roleIdList);

    /**
     * 根据菜单ID,删除角色菜单关系
     * @param menuId 菜单id
     */
    void deleteByMenuId(Long menuId);
}
