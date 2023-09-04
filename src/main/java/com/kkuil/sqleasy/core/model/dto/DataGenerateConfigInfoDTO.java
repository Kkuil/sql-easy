package com.kkuil.sqleasy.core.model.dto;

import com.kkuil.sqleasy.core.model.bo.FieldInfoBO;
import lombok.Builder;
import lombok.Data;

/**
 * @Author Kkuil
 * @Date 2023/9/4 16:39
 * @Description 数据生成所需的配置信息
 */
@Data
@Builder
public class DataGenerateConfigInfoDTO {
    /**
     * 方言
     */
    private String dialect;

    /**
     * 数据库名
     */
    private String database;

    /**
     * 表名
     */
    private String table;

    /**
     * 存储引擎
     */
    private String engine;

    /**
     * 表注释
     */
    private String comment;

    /**
     * 生成的数据数量
     */
    private String count;

    /**
     * 字段信息
     */
    private FieldInfoBO[] fields;
}
