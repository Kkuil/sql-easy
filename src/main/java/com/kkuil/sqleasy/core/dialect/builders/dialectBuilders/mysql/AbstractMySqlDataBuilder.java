package com.kkuil.sqleasy.core.dialect.builders.dialectBuilders.mysql;

import com.kkuil.sqleasy.core.dialect.builders.IDataBuilder;
import com.kkuil.sqleasy.core.model.bo.FieldInfoBO;
import com.kkuil.sqleasy.core.model.dto.DataGenerateConfigInfoDTO;

/**
 * @Author Kkuil
 * @Date 2023/9/4 23:19
 * @Description 抽象MySQL类
 */
public abstract class AbstractMySqlDataBuilder implements IDataBuilder<String> {

    /**
     * 建表模板
     */
    public static final String CREATE_TABLE_CODE_TEMPLATE = """
            -- %s
            CREATE TABLE IF NOT EXISTS %s (
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
     * 生成数据
     *
     * @param dataGenerateConfigInfoDTO 生成数据配置信息
     * @return 数据
     */
    public abstract String build(DataGenerateConfigInfoDTO dataGenerateConfigInfoDTO);

    /**
     * 构建字段部分
     *
     * @param fieldInfoBOS 字段配置信息
     * @return 建表字段部分
     */
    public abstract String buildFields(FieldInfoBO[] fieldInfoBOS);
}
