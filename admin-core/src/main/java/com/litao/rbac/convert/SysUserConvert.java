package com.litao.rbac.convert;

import com.litao.rbac.entity.SysUserEntity;
import com.litao.rbac.vo.SysUserExeclVO;
import com.litao.rbac.vo.SysUserVO;
import com.litao.security.user.UserDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysUserConvert  {
    SysUserConvert INSTANCE= Mappers.getMapper(SysUserConvert.class);

    UserDetail convertDetail(SysUserEntity userEntity);

    SysUserVO convert(UserDetail userDetail);

    SysUserVO convert(SysUserEntity entity);

    SysUserEntity convert(SysUserVO vo);

    List<SysUserVO> convertList(List<SysUserEntity> list);

    List<SysUserExeclVO> convert2List(List<SysUserEntity> list);

    List<SysUserEntity> convertListEntity(List<SysUserExeclVO> list);

}
