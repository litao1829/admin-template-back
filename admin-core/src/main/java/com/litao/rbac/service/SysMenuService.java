package com.litao.rbac.service;


import com.litao.common.utils.PageResult;
import com.litao.mybatis.service.BaseService;
import com.litao.rbac.entity.SysMenuEntity;
import com.litao.rbac.query.SysMenuQuery;
import com.litao.rbac.vo.SysMenuVO;
import com.litao.security.user.UserDetail;

import java.util.List;
import java.util.Set;

/**
 * 系统菜单业务接口
 *
 * @author mqxu
 */
public interface SysMenuService extends BaseService<SysMenuEntity> {

    /**
     * 菜单分页查询
     * @param query 程序参数
     * @return
     */
    PageResult<SysMenuVO> page(SysMenuQuery query);

    /**
     * 获取子菜单的数量
     * @param pid 父菜单ID
     * @return
     */
    Long getSubMenuCount(Long pid);

    /**
     * 菜单列表
     *
     * @param type 菜单类型
     */
    List<SysMenuVO> getMenuList(Integer type);

    /**
     * 用户菜单列表
     *
     * @param user 用户
     * @param type 菜单类型
     */
    List<SysMenuVO> getUserMenuList(UserDetail user, Integer type);

    /**
     * 获取用户权限列表
     */
    Set<String> getUserAuthority(UserDetail user);

    /**
     * 保存菜单
     * @param vo 菜单vo
     */
    void save(SysMenuVO vo);

    /**
     * 更新修改
     * @param vo 菜单vo
     */
    void update(SysMenuVO vo);

    /**
     * 根据id删除菜单
     * @param id 菜单id
     */
    void delete(Long id);
}

