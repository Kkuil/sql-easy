package com.kkuil.sqleasy.core.dialect.builders.dialectBuilders.mysql.abstractBuilders;

import com.kkuil.sqleasy.core.dialect.builders.dialectBuilders.AbstractSqlBuilder;
import com.kkuil.sqleasy.core.model.bo.FieldInfoBO;
import jakarta.validation.constraints.NotBlank;

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
    public abstract String buildColumns(@NotBlank(message = "字段信息不能为空") FieldInfoBO[] fields);


    /**
     * 构建列值
     *
     * @param dataListMap 模拟数据
     * @param fields      字段信息
     * @return 模拟数据列字符串
     */
    public abstract String buildValues(@NotBlank(message = "模拟数据不能为空") List<Map<String, Object>> dataListMap, @NotBlank(message = "字段信息不能为空") FieldInfoBO[] fields);

}
