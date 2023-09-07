package com.kkuil.sqleasy.core.model.dto;

import com.kkuil.sqleasy.core.model.bo.FieldInfoBO;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

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
    @NotBlank(message = "方言不能为空")
    private String dialect;

    /**
     * 数据库名
     */
    private String database;

    /**
     * 表名
     */
    @NotBlank(message = "表名不能为空")
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
    @NotBlank(message = "模拟数据数量不能为空")
    private Integer count;

    /**
     * 字段信息
     */
    @NotBlank(message = "字段信息不能为空")
    private FieldInfoBO[] fields;

}
