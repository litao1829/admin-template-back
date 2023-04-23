package com.litao.rbac.service.impl;

import com.litao.mybatis.service.impl.BaseServiceImpl;
import com.litao.rbac.dao.SysMenuDao;
import com.litao.rbac.entity.SysMenuEntity;
import com.litao.rbac.service.SysMenuService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



/**
 * 系统菜单业务实现类
 *
 * @author
 */
@Service
@AllArgsConstructor
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {

}
