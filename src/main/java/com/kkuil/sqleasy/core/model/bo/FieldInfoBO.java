package com.kkuil.sqleasy.core.model.bo;

import lombok.Builder;
import lombok.Data;

/**
 * @Author Kkuil
 * @Date 2023/9/4 16:42
 * @Description 字段信息
 */
@Data
@Builder
public class FieldInfoBO {
    /**
     * 字段名
     */
    private String name;

    /**
     * 字段类型
     */
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
    private Integer mockDataType;

    /**
     * 额外信息
     */
    private Object extraInfo;
}
