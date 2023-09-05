package com.kkuil.sqleasy.core.model.bo;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author Kkuil
 * @Description Java 实体生成封装类
 * @Date 2023/09/05
 */
@Data
@Builder
public class JavaEntityBO {

    /**
     * 类名
     */
    private String clazz;

    /**
     * 类注释
     */
    private String comment;

    /**
     * 列信息列表
     */
    private List<FieldInfo> fieldList;

    /**
     * 列信息
     */
    @Data
    @Accessors(chain = true)
    public static class FieldInfo {
        /**
         * 字段名
         */
        private String name;

        /**
         * Java 类型
         */
        private String type;

        /**
         * 注释（字段中文名）
         */
        private String comment;
    }

}
