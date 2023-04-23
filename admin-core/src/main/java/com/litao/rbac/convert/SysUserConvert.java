package com.litao.rbac.convert;

import com.litao.rbac.entity.SysUserEntity;
import com.litao.rbac.vo.SysUserVO;
import com.litao.security.user.UserDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SysUserConvert  {
    SysUserConvert INSTANCE= Mappers.getMapper(SysUserConvert.class);

    UserDetail convertDetail(SysUserEntity userEntity);

    SysUserVO convert(UserDetail userDetail);
}
