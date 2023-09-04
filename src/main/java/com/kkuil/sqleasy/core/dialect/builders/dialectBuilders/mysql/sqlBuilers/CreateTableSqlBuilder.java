package com.kkuil.sqleasy.core.dialect.builders.dialectBuilders.mysql.sqlBuilers;

import com.kkuil.sqleasy.core.dialect.builders.IDataBuilder;
import com.kkuil.sqleasy.core.model.bo.FieldInfoBO;
import com.kkuil.sqleasy.core.model.dto.DataGenerateConfigInfoDTO;

import static com.kkuil.sqleasy.constant.GlobalConst.EMPTY_STR;
import static com.kkuil.sqleasy.core.constant.GlobalConst.FIELD_INDENTATION;

/**
 * @Author Kkuil
 * @Date 2023/9/4 18:33
 * @Description 建表SQL构造器
 */
public class CreateTableSqlBuilder implements IDataBuilder<String> {

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
     * @return 数据
     */
    @Override
    public String build(DataGenerateConfigInfoDTO dataGenerateConfigInfoDTO) {
        // 1. 注释
        String comment = dataGenerateConfigInfoDTO.getComment();
        // 2. 表名
        String table = dataGenerateConfigInfoDTO.getTable();
        // 3. 建表字段
        String fields = buildFields(dataGenerateConfigInfoDTO.getFields());
        // 4. 引擎
        String engine = dataGenerateConfigInfoDTO.getEngine();
        // 5. 组合
        return String.format(CREATE_TABLE_CODE_TEMPLATE, comment, table, fields, engine, comment);
    }

    /**
     * 构建字段部分
     *
     * @param fieldInfoBOS 字段配置信息
     * @return 建表字段部分
     */
    @Override
    public String buildFields(FieldInfoBO[] fieldInfoBOS) {
        StringBuilder fieldStringBuilder = new StringBuilder();
        for (FieldInfoBO field : fieldInfoBOS) {
            StringBuilder stringBuilder = new StringBuilder(FIELD_INDENTATION);
            // 1. 表名
            String name = field.getName();
            // 2. 存储类型
            String type = field.getType();
            // 3. 默认值
            String defaultValue = field.getDefaultValue();
            // 4. 自增
            Boolean autoIncrement = field.getAutoIncrement();
            // 5. 非空
            Boolean nonNull = field.getNonNull();
            // 6. 唯一
            Boolean unique = field.getUnique();
            // 7. 主键
            Boolean primary = field.getPrimary();
            // 8. 注释
            String comment = field.getComment();
            // 9. 同步更新
            Boolean onUpdate = field.getOnUpdate();
            stringBuilder
                    .append(name)
                    .append(" ")
                    .append(type)
                    .append(" ")
                    .append(EMPTY_STR.equals(defaultValue) ? EMPTY_STR : DEFAULT + defaultValue)
                    .append(" ")
                    .append(autoIncrement ? AUTO_INCREMENT : EMPTY_STR)
                    .append(" ")
                    .append(nonNull ? NOT_NULL : EMPTY_STR)
                    .append(" ")
                    .append(unique ? UNIQUE : EMPTY_STR)
                    .append(" ")
                    .append(primary ? PRIMARY : EMPTY_STR)
                    .append(" ")
                    .append(onUpdate ? ON_UPDATE + DEFAULT_ON_UPDATE : EMPTY_STR)
                    .append(" ")
                    .append(EMPTY_STR.equals(comment) ? EMPTY_STR : COMMENT + comment);
            fieldStringBuilder.append(stringBuilder);
        }
        return fieldStringBuilder.toString();
    }
}
