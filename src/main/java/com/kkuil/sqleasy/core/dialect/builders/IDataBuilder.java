package com.kkuil.sqleasy.core.dialect.builders;

import com.kkuil.sqleasy.core.model.bo.FieldInfoBO;
import com.kkuil.sqleasy.core.model.dto.DataGenerateConfigInfoDTO;

/**
 * @Author Kkuil
 * @Date 2023/9/4 18:36
 * @Description 数据构造器接口
 */
public interface IDataBuilder<DataType> {

    /**
     * 生成数据
     *
     * @param dataGenerateConfigInfoDTO 生成数据配置信息
     * @return 数据
     */
    DataType build(DataGenerateConfigInfoDTO dataGenerateConfigInfoDTO);

    /**
     * 构建字段部分
     *
     * @param fieldInfoBOS 字段配置信息
     * @return 建表字段部分
     */
    String buildFields(FieldInfoBO[] fieldInfoBOS);
}
