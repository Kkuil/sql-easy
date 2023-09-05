package com.kkuil.sqleasy.core.dialect.builders.dialectBuilders.mysql.sqlBuilers;

import cn.hutool.core.util.ArrayUtil;
import com.kkuil.sqleasy.core.dialect.builders.dialectBuilders.mysql.abstractBuilders.AbstractMySqlInsertSqlBuilder;
import com.kkuil.sqleasy.core.dialect.mockStrategy.IMockStrategy;
import com.kkuil.sqleasy.core.dialect.mockStrategy.IMockStrategyFactory;
import com.kkuil.sqleasy.core.dialect.mockStrategy.MockStrategyFactory;
import com.kkuil.sqleasy.core.model.bo.FieldInfoBO;
import com.kkuil.sqleasy.core.model.dto.DataGenerateConfigInfoDTO;

import java.util.ArrayList;
import java.util.Arrays;

import static com.kkuil.sqleasy.constant.GlobalConst.EMPTY_STR;
import static com.kkuil.sqleasy.constant.GlobalConst.NEW_LINE_CHAR;

/**
 * @Author Kkuil
 * @Date 2023/9/4 18:35
 * @Description 插入数据SQL构造器
 */
public class MySqlInsertSqlBuilder extends AbstractMySqlInsertSqlBuilder {

    private IMockStrategyFactory mockStrategyFactory = new MockStrategyFactory();

    /**
     * 生成模拟数据
     *
     * @param dataGenerateConfigInfoDTO 生成数据配置信息
     * @return 数据
     */
    @Override
    public String build(DataGenerateConfigInfoDTO dataGenerateConfigInfoDTO) {
        Integer count = dataGenerateConfigInfoDTO.getCount();
        FieldInfoBO[] fields = dataGenerateConfigInfoDTO.getFields();
        if (count <= 0) {
            return EMPTY_STR;
        }
        StringBuilder insertStringBuilder = new StringBuilder();
        // 1. 数据库名
        String database = dataGenerateConfigInfoDTO.getDatabase();
        // 2. 表名
        String table = dataGenerateConfigInfoDTO.getTable();
        // 3. 列名
        FieldInfoBO[] fieldsInfo = dataGenerateConfigInfoDTO.getFields();
        String columns = buildColumns(fieldsInfo);
        // 4. 模拟值
        String values = buildValues(count, fieldsInfo);
        // 5. 组合
        String insertSql = String.format(INSERT_SQL_TEMPLATE, database, table, columns, values);
        return insertSql;
    }

    /**
     * 构建列名
     *
     * @param fields 列信息
     * @return 列名
     */
    @Override
    public String buildColumns(FieldInfoBO[] fields) {
        StringBuilder fieldStringBuilder = new StringBuilder();
        ArrayList<String> columnList = new ArrayList<>();
        for (FieldInfoBO field : fields) {
            columnList.add(field.getName());
        }
        return ArrayUtil.join(columnList.toArray(), ",");
    }

    /**
     * 构建列值
     *
     * @param fields 列信息
     * @return 列值
     */
    @Override
    public String buildValues(int count, FieldInfoBO[] fields) {
        // 1. 获取模拟数据
        ArrayList<Object[]> datas = new ArrayList<>();
        for (FieldInfoBO field : fields) {
            IMockStrategy mockStrategy = mockStrategyFactory.produce(field.getMockDataType());
            Object[] data = mockStrategy.getData(count, field);
            datas.add(data);
        }
        // 2. 组合每一条数据
        StringBuilder valueStringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            StringBuilder valuePerRecord = new StringBuilder();
            ArrayList<String> valueList = new ArrayList<>();
            // 3. 取每一条数据
            for (int j = 0; j < fields.length; j++) {
                valueList.add(datas.get(j)[i].toString());
            }
            if (i == count - 1) {
                valuePerRecord
                        .append("(")
                        .append(ArrayUtil.join(valueList.toArray(), ","))
                        .append(")");
            } else {
                valuePerRecord
                        .append("(")
                        .append(ArrayUtil.join(valueList.toArray(), ","))
                        .append(")")
                        .append(SPLIT_CHAR)
                        .append(NEW_LINE_CHAR);
            }
            valueStringBuilder.append(valuePerRecord);
        }
        return valueStringBuilder.toString();
    }
}
