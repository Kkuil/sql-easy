package com.kkuil.sqleasy.core.model.bo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Author Kkuil
 * @Date 2023/9/7 19:30
 * @Description typescript代码业务实体
 */
@Data
@Accessors(chain = true)
public class TypescriptCodeBO {

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
    private List<TypescriptCodeBO.FieldInfo> fieldList;

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
