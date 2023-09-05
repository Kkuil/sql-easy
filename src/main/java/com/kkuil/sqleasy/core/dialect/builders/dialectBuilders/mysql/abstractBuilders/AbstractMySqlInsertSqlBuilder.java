package com.kkuil.sqleasy.core.dialect.builders.dialectBuilders.mysql.abstractBuilders;

import com.kkuil.sqleasy.core.dialect.builders.dialectBuilders.AbstractSqlBuilder;
import com.kkuil.sqleasy.core.model.bo.FieldInfoBO;

import java.util.List;
import java.util.Map;

/**
 * @Author Kkuil
 * @Date 2023/9/4 23:19
 * @Description 抽象MySQL类
 */
public abstract class AbstractMySqlInsertSqlBuilder extends AbstractSqlBuilder {

    /**
     * 插入数据模板
     */
    public static final String INSERT_SQL_TEMPLATE = """
            INSERT INTO %s.`%s` (%s) VALUES
            %s;
            """;

    /**
     * 分隔符
     */
    public static final String SPLIT_CHAR = ",";

    /**
     * 构建列名
     *
     * @param fields 列信息
     * @return 列名
     */
    public abstract String buildColumns(FieldInfoBO[] fields);

    /**
     * 构建列值
     *
     * @param count  模拟数量
     * @param fields 列信息
     * @return 列值
     */
    public abstract String buildValues(List<Map<String, Object>> dataListMap, FieldInfoBO[] fields);

}
