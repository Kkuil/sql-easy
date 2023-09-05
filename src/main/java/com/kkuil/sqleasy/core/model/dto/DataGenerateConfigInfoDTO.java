package com.kkuil.sqleasy.core.model.dto;

import com.kkuil.sqleasy.core.model.bo.FieldInfoBO;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.List;
import java.util.Map;

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
    @NonNull
    private String dialect;

    /**
     * 数据库名
     */
    private String database;

    /**
     * 表名
     */
    @NonNull
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
    @NonNull
    private Integer count;

    /**
     * 字段信息
     */
    @NonNull
    private FieldInfoBO[] fields;

    /**
     * 模拟数据
     */
    private List<Map<String, Object>> mockData;
}
