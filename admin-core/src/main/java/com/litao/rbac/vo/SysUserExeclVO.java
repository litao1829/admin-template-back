package com.litao.rbac.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.litao.common.excel.DateConverter;
import com.litao.rbac.convert.GenderTypeConverter;
import com.litao.rbac.convert.StatusTypeConverter;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class SysUserExeclVO implements Serializable {
    @Serial
    private static final long serialVersionUID =1L;

    @ExcelIgnore
    private Long id;

    @ExcelProperty("用户名")
    private String username;


    @ExcelProperty("真实姓名")
    private String realName;

    @ExcelProperty(value = "性别",converter = GenderTypeConverter.class)
    private Integer gender;

    @ExcelProperty("邮箱")
    private String email;

    @ExcelProperty("手机号")
    private String mobile;

    @ExcelProperty(value = "状态",converter = StatusTypeConverter.class)
    private Integer status;

    @ExcelProperty(value = "创建时间",converter = DateConverter.class)
    private Date createTime;
}
