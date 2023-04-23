package com.litao.convert;

import com.litao.entity.NoticeEntity;
import com.litao.vo.NoticeVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import java.util.List;

/**
 * Notice 实体转换
 *
 * @author mqxu
 **/
@Mapper
public interface NoticeConvert {
    NoticeConvert INSTANCE = Mappers.getMapper(NoticeConvert.class);

    NoticeVO convert(NoticeEntity entity);

    NoticeEntity convert(NoticeVO vo);

    List<NoticeVO> convertList(List<NoticeEntity> list);

}
