package com.kkuil.sqleasy.core.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author Kkuil
 * @Date 2023/9/8 19:27
 * @Description Sql字段类型
 */
@Data
@Accessors(chain = true)
public class SqlFieldVO {
    /**
     * 字段ID
     */
    private Integer id;

    /**
     * 字段类型
     */
    private String type;
}
