package com.litao.rbac.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.litao.common.utils.PageResult;
import com.litao.mybatis.service.impl.BaseServiceImpl;
import com.litao.rbac.convert.SysRoleConvert;
import com.litao.rbac.dao.SysRoleDao;
import com.litao.rbac.entity.SysRoleEntity;
import com.litao.rbac.query.SysRoleQuery;
import com.litao.rbac.service.SysRoleMenuService;
import com.litao.rbac.service.SysRoleService;
import com.litao.rbac.service.SysUserRoleService;
import com.litao.rbac.vo.SysRoleVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 系统角色业务实现类
 *
 * @author
 */
@Service
@AllArgsConstructor
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {
    private final SysRoleMenuService  sysRoleMenuService;
    private  final SysUserRoleService sysUserRoleService;
    @Override
    public PageResult<SysRoleVO> page(SysRoleQuery query) {
        IPage<SysRoleEntity> iPage = baseMapper.selectPage(getPage(query), getWrapper(query));
        return new PageResult<>(SysRoleConvert.INSTANCE.convertList(iPage.getRecords()), iPage.getTotal());
    }

    private Wrapper<SysRoleEntity> getWrapper(SysRoleQuery query){
        LambdaQueryWrapper<SysRoleEntity> wrapper=new LambdaQueryWrapper<>();
        wrapper.like(StrUtil.isNotBlank(query.getName()),SysRoleEntity::getName,query.getName());
        return wrapper;
    }

//    @Override
//    public List<SysRoleVO> getList(SysRoleQuery query) {
//        List<SysRoleEntity> list = baseMapper.selectList(getWrapper(query));
//        return SysRoleConvert.INSTANCE.convertList(list);
//    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysRoleVO vo) {
        SysRoleEntity sysRoleEntity = SysRoleConvert.INSTANCE.convert(vo);
        baseMapper.insert(sysRoleEntity);
        //保存角色菜单关系
//      sysRoleMenuService.saveOrUpdate(vo.getId(),vo.getMenuIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysRoleVO vo) {
        SysRoleEntity sysRoleEntity = SysRoleConvert.INSTANCE.convert(vo);
        updateById(sysRoleEntity);
        //保存角色菜单关系
//        sysRoleMenuService.saveOrUpdate(vo.getId(),vo.getMenuIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        //删除角色
        removeById(id);
        //删除用户角色关系
        sysUserRoleService.deleteByRoleIdList(List.of(id));
        //删除角色菜单关系
        sysRoleMenuService.deleteByRoleIdList(List.of(id));

    }

    @Override
    public void setRoleMenus(Long roleId, List<Long> menuIds) {
        sysRoleMenuService.saveOrUpdate(roleId,menuIds);
    }

//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public void deleted(List<Long> idList) {
//        //删除角色
//        removeByIds(idList);
//        //删除用户角色关系
//        sysUserRoleService.deleteByRoleIdList(idList);
//        //删除角色菜单关系
//        sysRoleMenuService.deleteByRoleIdList(idList);
//
//    }
}
