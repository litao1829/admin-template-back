package com.litao.rbac.convert;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.litao.rbac.enums.UserGenderEnum;
import com.litao.rbac.enums.UserStatusEnum;

public class StatusTypeConverter implements Converter<Integer> {

    @Override
    public Class<?> supportJavaTypeKey() {
        return Integer.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Integer convertToJavaData(ReadCellData<?> cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
       if(cellData.getStringValue().equals(UserStatusEnum.ENABLED.getName())){
           return UserStatusEnum.ENABLED.getValue();
       }else if(cellData.getStringValue().equals(UserStatusEnum.DISABLE.getName())){
           return UserStatusEnum.DISABLE.getValue();
       }else {
           return null;
       }
    }

    @Override
    public WriteCellData<?> convertToExcelData(Integer value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        if(value.equals(UserStatusEnum.ENABLED.getValue())){
            return new WriteCellData<>(UserStatusEnum.ENABLED.getName());
        }else if(value.equals(UserStatusEnum.DISABLE.getValue())){
            return new WriteCellData<>(UserStatusEnum.DISABLE.getName());
        }else {
            return new WriteCellData<>("错误");
        }
    }
}
