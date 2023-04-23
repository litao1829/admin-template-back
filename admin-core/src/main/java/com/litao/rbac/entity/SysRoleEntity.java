package com.litao.rbac.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.litao.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 角色表实体类
 *
 * @author
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_role")
public class SysRoleEntity extends BaseEntity {
    /**
     * 角色名称
     */
    private String name;
    /**
     * 备注
     */
    private String remark;
}
