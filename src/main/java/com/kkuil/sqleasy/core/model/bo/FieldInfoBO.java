package com.kkuil.sqleasy.core.model.bo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author Kkuil
 * @Date 2023/9/4 16:42
 * @Description 字段信息
 */
@Data
@EqualsAndHashCode
@Builder
public class FieldInfoBO {
    /**
     * 字段名
     */
    @NotBlank(message = "字段名不能为空")
    private String name;

    /**
     * 字段类型
     */
    @NotBlank(message = "字段类型不能为空")
    private String type;

    /**
     * 默认值
     */
    private String defaultValue;

    /**
     * 字段注释
     */
    private String comment;

    /**
     * 是否同步更新
     */
    private Boolean onUpdate;

    /**
     * 是否非空
     */
    private Boolean nonNull;

    /**
     * 是否唯一
     */
    private Boolean unique;

    /**
     * 是否主键
     */
    private Boolean primary;

    /**
     * 是否自增
     */
    private Boolean autoIncrement;

    /**
     * 模拟的数据类型
     */
    @NotNull(message = "模拟数据类型不能为空")
    private Integer mockDataType;

    /**
     * 额外信息
     */
    private Object extraInfo;
}
