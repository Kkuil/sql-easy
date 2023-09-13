package com.kkuil.sqleasy.core.model.dto;

import com.kkuil.sqleasy.core.model.bo.FieldInfoBO;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "方言不能为空")
    private String dialect;

    /**
     * 数据库名
     */
    @NotBlank(message = "数据库名不能为空")
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
    @NotNull(message = "模拟数据数量不能为空")
    @Max(message = "数量过多", value = 100)
    private Integer count;

    /**
     * 字段信息
     */
    @NotEmpty(message = "字段信息不能为空")
    private FieldInfoBO[] fields;
}
