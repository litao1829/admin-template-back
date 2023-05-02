package com.litao.rbac.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.litao.common.constant.Constant;
import com.litao.common.excel.ExcelFinishCallBack;
import com.litao.common.exception.ServerException;
import com.litao.common.utils.DateUtils;
import com.litao.common.utils.ExcelUtils;
import com.litao.common.utils.PageResult;
import com.litao.mybatis.service.impl.BaseServiceImpl;
import com.litao.rbac.convert.SysUserConvert;
import com.litao.rbac.dao.SysUserDao;
import com.litao.rbac.entity.SysUserEntity;
import com.litao.rbac.enums.SuperAdminEnum;
import com.litao.rbac.query.SysUserQuery;
import com.litao.rbac.service.SysUserRoleService;
import com.litao.rbac.service.SysUserService;
import com.litao.rbac.vo.SysUserExeclVO;
import com.litao.rbac.vo.SysUserVO;
import lombok.AllArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 系统用户业务实现类
 *
 * @author
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {
    private  final SysUserRoleService sysUserRoleService;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePassword(Long id, String newPassword) {
        // 修改密码
        SysUserEntity user = getById(id);
        user.setPassword(newPassword);
        updateById(user);
    }

    @Override
    public PageResult<SysUserVO> page(SysUserQuery query) {
        //查询参数
        Map<String, Object> params = getParams(query);
        //分页查询
        IPage<SysUserEntity> page = getPage(query);
        params.put(Constant.PAGE,page);
        //获取数据列表
        List<SysUserEntity> list=baseMapper.getList(params);
        return new PageResult<>(SysUserConvert.INSTANCE.convertList(list),page.getTotal());
    }

    private Map<String,Object> getParams(SysUserQuery query){
        Map<String,Object> parmas=new HashMap<>();
        parmas.put("username",query.getUsername());
        parmas.put("realName",query.getRealName());
        parmas.put("mobile",query.getMobile());
        parmas.put("gender",query.getGender());
        parmas.put("beginTime",query.getBeginTime());
        parmas.put("endTime",query.getEndTime());
        return parmas;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysUserVO vo) {
        SysUserEntity entity = SysUserConvert.INSTANCE.convert(vo);
        entity.setSuperAdmin(SuperAdminEnum.NO.getValue());

        //判断用户是否存在
        SysUserEntity byUsername = baseMapper.getByUsername(entity.getUsername());

        if(byUsername!=null){
            throw new ServerException("用户名已存在");
        }
        //TODO：判断手机号是否存在
        SysUserEntity user=baseMapper.getByMobile(entity.getMobile());
        if(user !=null){
            throw new ServerException("手机号已存在");
        }

        //保存用户
        baseMapper.insert(entity);

    }

    @Override
    public void update(SysUserVO vo) {
        SysUserEntity entity = SysUserConvert.INSTANCE.convert(vo);


        //判断用户是否存在
        SysUserEntity user = baseMapper.getByUsername(entity.getUsername());
        if(user!=null&& !user.getId().equals(entity.getId())){
            throw  new ServerException("用户已存在");
        }

        //判断手机号是否存在
        user=baseMapper.getByMobile(entity.getMobile());
        if(user!=null&&!user.getId().equals(entity.getId())){
            throw  new ServerException("手机号已经存在");
        }

        //更新用户
        updateById(entity);
    }

    @Override
    public void updateStatus(long id, int status) {
        SysUserEntity entity = baseMapper.getByid(id);
        entity.setStatus(status);
        baseMapper.updateById(entity);
    }

    @Override
    public void delete(Long id) {
        removeById(id);
        //删除用户和角色之间的关系
        sysUserRoleService.deleteByUserIdList(List.of(id));
    }

    @Override
    public void deleteSelectAll(List<Long> ids) {
        //批量删除用户
        removeByIds(ids);
        //删除用户和角色之间的关系
        sysUserRoleService.deleteByUserIdList(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void importByExcel(MultipartFile file, String password) {
        ExcelUtils.readAnalysis(file,SysUserExeclVO.class,new ExcelFinishCallBack<SysUserExeclVO>(){
            @Override
            public void doAfterAllAnalysed(List<SysUserExeclVO> result) {
                saveUser(result);
            }

            @Override
            public void doSaveBatch(List<SysUserExeclVO> result) {
                //批量新增
                saveUser(result);
            }
            private void saveUser(List<SysUserExeclVO> result){
                List<SysUserEntity> userEntities = SysUserConvert.INSTANCE.convertListEntity(result);
                //给每个导入的用户设置初始化密码
                userEntities.forEach(item-> {
                    item.setSuperAdmin(0);
                    item.setPassword(password);});
                //批量新增
                saveBatch(userEntities);
            }
        });
    }

    @Override
    public void export() {
        List<SysUserEntity> list=list(Wrappers.lambdaQuery(SysUserEntity.class).eq(SysUserEntity::getSuperAdmin,SuperAdminEnum.NO.getValue()));
        List<SysUserExeclVO> userExeclVOList = SysUserConvert.INSTANCE.convert2List(list);
        //导出下载
        ExcelUtils.excelExport(SysUserExeclVO.class,"system_user_excel"+ DateUtils.format(new Date()),"sheet1",userExeclVOList);

    }

    @Override
    public void setUserRole(Long userId, List<Long> roleIds) {
        sysUserRoleService.saveOrUpdate(userId,roleIds);
    }


}
