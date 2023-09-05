package com.kkuil.sqleasy.core.dialect.factory.builders;

import com.kkuil.sqleasy.core.dialect.builders.dialectBuilders.mysql.sqlBuilers.MySqlCreateTableSqlBuilder;
import com.kkuil.sqleasy.core.dialect.builders.dialectBuilders.mysql.sqlBuilers.MySqlInsertSqlBuilder;
import com.kkuil.sqleasy.core.model.bo.CodeDataBO;
import com.kkuil.sqleasy.core.model.bo.SqlDataBO;
import com.kkuil.sqleasy.core.model.dto.DataGenerateConfigInfoDTO;
import com.kkuil.sqleasy.core.model.vo.GeneratedAllDataVO;

/**
 * @Author Kkuil
 * @Date 2023/9/4 20:54
 * @Description MySQL构造器
 */
public class MySqlBuilder implements IDialectBuilder<GeneratedAllDataVO> {

    /**
     * 构造数据
     *
     * @return 数据
     */
    @Override
    public GeneratedAllDataVO build(DataGenerateConfigInfoDTO dataGenerateConfigInfoDTO) {
        // 1. 构建代码数据
        CodeDataBO codeDataBO = buildCode(dataGenerateConfigInfoDTO);
        // 2. 构建sql数据
        SqlDataBO sqlDataBO = buildSql(dataGenerateConfigInfoDTO);
        // 3. 组装数据
        GeneratedAllDataVO generatedAllDataVO = GeneratedAllDataVO.builder()
                .createTableSql(sqlDataBO.getCreateTableSql())
                .insertSql(sqlDataBO.getInsertSql())
                .jsonCode(codeDataBO.getJsonCode())
                .javaCode(codeDataBO.getJavaCode())
                .typescriptCode(codeDataBO.getTypescriptCode())
                .build();
        return generatedAllDataVO;
    }

    /**
     * sql构造器
     *
     * @return SqlDataBO
     */
    @Override
    public SqlDataBO buildSql(DataGenerateConfigInfoDTO dataGenerateConfigInfoDTO) {
        // 1. 建表语句构造器
        MySqlCreateTableSqlBuilder createTableSqlBuilder = new MySqlCreateTableSqlBuilder();
        // 2. 生成建表语句
        String createTableSql = createTableSqlBuilder.build(dataGenerateConfigInfoDTO);

        // 1. 插入语句构造器
        MySqlInsertSqlBuilder insertSqlBuilder = new MySqlInsertSqlBuilder();
        // 2. 生成建表语句
        String insertSql = insertSqlBuilder.build(dataGenerateConfigInfoDTO);
        // 构造sql
        return SqlDataBO.builder()
                .createTableSql(createTableSql)
                .insertSql(insertSql)
                .build();
    }
}
