package com.litao.rbac.convert;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.ReadConverterContext;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.litao.rbac.enums.UserGenderEnum;

public class GenderTypeConverter  implements Converter<Integer> {

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
       if(cellData.getStringValue().equals(UserGenderEnum.MAN.getName())){
           return UserGenderEnum.MAN.getValue();
       }
       else if(cellData.getStringValue().equals(UserGenderEnum.WOMEN.getName())){
           return UserGenderEnum.WOMEN.getValue();
       }
       else{
           return UserGenderEnum.UNKNOWN.getValue();
       }
    }



    @Override
    public WriteCellData<?> convertToExcelData(Integer value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        if(value.equals(UserGenderEnum.MAN.getValue())){
            return new WriteCellData<>(UserGenderEnum.MAN.getName());
        }
        else if(value.equals(UserGenderEnum.WOMEN.getValue())){
            return new WriteCellData<>(UserGenderEnum.WOMEN.getName());
        }
        else {
            return new WriteCellData<>(UserGenderEnum.UNKNOWN.getName());
        }
    }

}
