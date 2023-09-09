package com.kkuil.sqleasy.core.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author Kkuil
 * @Date 2023/9/9 16:09
 * @Description 通用列表视图实体类
 */
@Data
@Accessors(chain = true)
public abstract class AbstractCommonListMapVO {
    /**
     * ID
     */
    private Integer id;

    /**
     * name
     */
    private String name;
}
