package com.kkuil.sqleasy.core.dialect.builders.dialectBuilders;

import com.kkuil.sqleasy.core.model.dto.DataGenerateConfigInfoDTO;

/**
 * @Author Kkuil
 * @Date 2023/9/5 8:32
 * @Description 抽象sql语句构造器
 */
public abstract class AbstractSqlBuilder {
    /**
     * 生成数据
     *
     * @param dataGenerateConfigInfoDTO 生成数据配置信息
     * @return 数据
     */
    public abstract String build(DataGenerateConfigInfoDTO dataGenerateConfigInfoDTO);
}
