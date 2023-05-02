package com.litao.rbac.service;


import com.litao.common.utils.PageResult;
import com.litao.mybatis.service.BaseService;
import com.litao.rbac.entity.SysRoleEntity;
import com.litao.rbac.query.SysRoleQuery;
import com.litao.rbac.vo.SysRoleVO;

import java.util.List;

/**
 * 系统角色业务接口
 *
 * @author
 */
public interface SysRoleService extends BaseService<SysRoleEntity> {
    /**
     * 角色分页列表
     * @param query 查询参数
     * @return
     */
    PageResult<SysRoleVO> page(SysRoleQuery query);


    List<SysRoleVO> getRoleList();

    /**
     * 新增角色
     * @param vo 入参
     */
    void save(SysRoleVO vo);

    /**
     * 更新角色
     * @param vo 入参
     */
    void update(SysRoleVO vo);

    /**
     *  删除角色
     * @param id 角色id
     */
    void delete(Long id);

//    void deleted(List<Long> idList);

    /**
     * 给角色授权
     * @param roleId 角色id
     * @param menuIds 菜单id集合
     */
    void setRoleMenus(Long roleId,List<Long> menuIds);
}
