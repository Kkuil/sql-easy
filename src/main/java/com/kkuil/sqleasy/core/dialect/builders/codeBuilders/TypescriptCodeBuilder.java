package com.kkuil.sqleasy.core.dialect.builders.codeBuilders;

import com.kkuil.sqleasy.core.dialect.builders.IDataBuilder;
import com.kkuil.sqleasy.core.model.dto.DataGenerateConfigInfoDTO;

import java.util.List;
import java.util.Map;

/**
 * @Author Kkuil
 * @Date 2023/9/4 18:35
 * @Description Typescript代码构造器
 */
public class TypescriptCodeBuilder implements IDataBuilder {
    /**
     * 生成数据
     *
     * @param dataGenerateConfigInfoDTO 生成数据配置信息
     * @return 数据
     */
    @Override
    public String build(DataGenerateConfigInfoDTO dataGenerateConfigInfoDTO, List<Map<String, Object>> data) {
        return null;
    }
}
