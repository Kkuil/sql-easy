package com.kkuil.sqleasy.core.dialect.builders.dialectBuilders.mysql.abstractBuilders;

import com.kkuil.sqleasy.core.dialect.builders.dialectBuilders.AbstractSqlBuilder;
import com.kkuil.sqleasy.core.model.bo.FieldInfoBO;
import jakarta.validation.constraints.NotBlank;

/**
 * @Author Kkuil
 * @Date 2023/9/4 23:19
 * @Description 抽象MySQL类
 */
public abstract class AbstractMySqlCreateTableSqlBuilder extends AbstractSqlBuilder {

    /**
     * 建表模板
     */
    public static final String CREATE_TABLE_CODE_TEMPLATE = """
            -- %s
            CREATE TABLE IF NOT EXISTS %s.`%s` (
            %s
            ) ENGINE=%s COMMENT=%s;
            """;

    /**
     * 默认值关键词
     */
    public static final String DEFAULT = "DEFAULT";

    /**
     * 自增关键词
     */
    public static final String AUTO_INCREMENT = "AUTO_INCREMENT";

    /**
     * 非空关键词
     */
    public static final String NOT_NULL = "NOT NULL";

    /**
     * 唯一性关键词
     */
    public static final String UNIQUE = "UNIQUE";

    /**
     * 主键关键词
     */
    public static final String PRIMARY = "PRIMARY KEY";

    /**
     * 注释关键词
     */
    public static final String COMMENT = "COMMENT";

    /**
     * 同步更新关键词
     */
    public static final String ON_UPDATE = "ON UPDATE";

    /**
     * 默认同步更新的选项
     */
    public static final String DEFAULT_ON_UPDATE = "CURRENT_TIMESTAMP";

    /**
     * 构建字段部分
     *
     * @param fieldInfoBOS 字段配置信息
     * @return 建表字段部分
     */
    public abstract String buildFields(@NotBlank(message = "字段信息不能为空") FieldInfoBO[] fieldInfoBOS);
}
