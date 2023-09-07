package com.kkuil.sqleasy.core.dialect.builders;

import com.kkuil.sqleasy.core.model.dto.DataGenerateConfigInfoDTO;

import java.util.List;
import java.util.Map;

/**
 * @Author Kkuil
 * @Date 2023/9/5 14:41
 * @Description 数据构造器接口
 */
public interface IDataBuilder {
    /**
     * 生成数据
     *
     * @param dataGenerateConfigInfoDTO 生成数据配置信息
     * @return 数据
     */
    String build(DataGenerateConfigInfoDTO dataGenerateConfigInfoDTO, List<Map<String,Object>> data);
}
