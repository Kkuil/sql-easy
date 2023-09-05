package com.kkuil.sqleasy.core.dialect.builders.dialectBuilders.mysql.sqlBuilers;

import com.kkuil.sqleasy.core.dialect.builders.dialectBuilders.mysql.abstractBuilders.AbstractMySqlCreateTableSqlBuilder;
import com.kkuil.sqleasy.core.model.bo.FieldInfoBO;
import com.kkuil.sqleasy.core.model.dto.DataGenerateConfigInfoDTO;

import static com.kkuil.sqleasy.constant.GlobalConst.EMPTY_STR;
import static com.kkuil.sqleasy.constant.GlobalConst.SPACE_STR;
import static com.kkuil.sqleasy.core.constant.GlobalConst.FIELD_INDENTATION;

/**
 * @Author Kkuil
 * @Date 2023/9/4 18:33
 * @Description 建表SQL构造器
 */
public class MySqlCreateTableSqlBuilder extends AbstractMySqlCreateTableSqlBuilder {

    /**
     * 生成数据
     *
     * @return 数据
     */
    @Override
    public String build(DataGenerateConfigInfoDTO dataGenerateConfigInfoDTO) {
        // 1. 注释
        String comment = dataGenerateConfigInfoDTO.getComment();
        // 2. 数据库名
        String database = dataGenerateConfigInfoDTO.getDatabase();
        // 3. 表名
        String table = dataGenerateConfigInfoDTO.getTable();
        // 4. 建表字段
        String fields = buildFields(dataGenerateConfigInfoDTO.getFields());
        // 5. 引擎
        String engine = dataGenerateConfigInfoDTO.getEngine();
        // 6. 组合
        return String.format(CREATE_TABLE_CODE_TEMPLATE, comment, database, table, fields, engine, comment);
    }

    /**
     * 构建字段部分
     *
     * @param fields 字段配置信息
     * @return 建表字段部分
     */
    @Override
    public String buildFields(FieldInfoBO[] fields) {
        StringBuilder fieldStringBuilder = new StringBuilder();
        for (FieldInfoBO field : fields) {
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
                    .append(EMPTY_STR.equals(defaultValue) ? EMPTY_STR : DEFAULT + SPACE_STR + defaultValue)
                    .append(" ")
                    .append(autoIncrement ? AUTO_INCREMENT : EMPTY_STR)
                    .append(" ")
                    .append(nonNull ? NOT_NULL : EMPTY_STR)
                    .append(" ")
                    .append(unique ? UNIQUE : EMPTY_STR)
                    .append(" ")
                    .append(primary ? PRIMARY : EMPTY_STR)
                    .append(" ")
                    .append(onUpdate ? ON_UPDATE + SPACE_STR + DEFAULT_ON_UPDATE : EMPTY_STR)
                    .append(" ")
                    .append(EMPTY_STR.equals(comment) ? EMPTY_STR : COMMENT + SPACE_STR + comment)
                    .append("\n");
            fieldStringBuilder.append(stringBuilder);
        }
        return fieldStringBuilder.toString();
    }
}
