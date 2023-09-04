package com.kkuil.sqleasy.core.dialect.factory.builders;

import com.kkuil.sqleasy.core.model.bo.CodeDataBO;
import com.kkuil.sqleasy.core.model.bo.SqlDataBO;

/**
 * @Author Kkuil
 * @Date 2023/9/4 18:51
 * @Description 方言构造器接口
 */
public interface IDialectBuilder<T> {

    /**
     * 构造数据
     *
     * @return 数据
     */
    T build();

    /**
     * sql构造器
     *
     * @return SqlDataBO
     */
    SqlDataBO buildSql();

    /**
     * 代码构造器
     *
     * @return CodeDataBO<Object, Object, Object>
     */
    default CodeDataBO buildCode() {
        CodeDataBO codeDataBO = CodeDataBO.builder()
                .javaCode("javaCode")
                .jsonCode("jsonCode")
                .typescriptCode("typescriptCode")
                .build();
        return codeDataBO;
    }
}
