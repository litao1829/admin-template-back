package com.litao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.litao.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * notice 实体类
 *
 * @author
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_notice")
public class NoticeEntity extends BaseEntity{
    /**
     * 通知标题
     */
    private String title;
    /**
     * 通知内容
     */
    private String content;
}
