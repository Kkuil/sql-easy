package com.kkuil.sqleasy.core.dialect.factory.builders;

import com.kkuil.sqleasy.core.model.bo.CodeDataBO;
import com.kkuil.sqleasy.core.model.bo.SqlDataBO;
import com.kkuil.sqleasy.core.model.dto.DataGenerateConfigInfoDTO;

/**
 * @Author Kkuil
 * @Date 2023/9/4 18:51
 * @Description 方言构造器接口
 */
public interface IDialectBuilder<T> {

    /**
     * 构造数据
     *
     * @param dataGenerateConfigInfoDTO 生成数据配置信息
     * @return 数据
     */
    T build(DataGenerateConfigInfoDTO dataGenerateConfigInfoDTO);

    /**
     * sql构造器
     *
     * @param dataGenerateConfigInfoDTO 生成数据配置信息
     * @return SqlDataBO
     */
    SqlDataBO buildSql(DataGenerateConfigInfoDTO dataGenerateConfigInfoDTO);

    /**
     * 代码构造器
     *
     * @param dataGenerateConfigInfoDTO 生成数据配置信息
     * @return CodeDataBO
     */
    default CodeDataBO buildCode(DataGenerateConfigInfoDTO dataGenerateConfigInfoDTO) {
        CodeDataBO codeDataBO = CodeDataBO.builder()
                .javaCode("javaCode")
                .jsonCode("jsonCode")
                .typescriptCode("typescriptCode")
                .build();
        return codeDataBO;
    }
}
