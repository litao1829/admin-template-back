package com.litao.common.excel;

import java.util.List;

/**
 * excel读取数据完成
 *
 * @author
 */
public interface ExcelFinishCallBack<T> {

    /**
     * 导出后置处理数据
     *
     * @param result result
     */
    void doAfterAllAnalysed(List<T> result);

    /**
     * @param result result
     */
    default void doSaveBatch(List<T> result) {
    }
}
