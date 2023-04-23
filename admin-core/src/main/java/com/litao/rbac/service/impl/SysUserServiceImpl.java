package com.litao.rbac.service.impl;

import com.litao.mybatis.service.impl.BaseServiceImpl;
import com.litao.rbac.dao.SysUserDao;
import com.litao.rbac.entity.SysUserEntity;
import com.litao.rbac.service.SysUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * 系统用户业务实现类
 *
 * @author
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

}
