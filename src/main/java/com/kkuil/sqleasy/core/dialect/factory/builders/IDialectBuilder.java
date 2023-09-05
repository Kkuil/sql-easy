package com.kkuil.sqleasy.core.dialect.factory.builders;

import com.kkuil.sqleasy.core.dialect.builders.codeBuilders.JavaCodeBuilder;
import com.kkuil.sqleasy.core.dialect.builders.codeBuilders.JsonCodeBuilder;
import com.kkuil.sqleasy.core.dialect.builders.codeBuilders.TypescriptCodeBuilder;
import com.kkuil.sqleasy.core.dialect.mockStrategy.IMockStrategy;
import com.kkuil.sqleasy.core.model.bo.CodeDataBO;
import com.kkuil.sqleasy.core.model.bo.FieldInfoBO;
import com.kkuil.sqleasy.core.model.bo.SqlDataBO;
import com.kkuil.sqleasy.core.model.dto.DataGenerateConfigInfoDTO;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.kkuil.sqleasy.core.dialect.builders.dialectBuilders.mysql.sqlBuilers.MySqlInsertSqlBuilder.MOCK_STRATEGY_FACTORY;

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
        // 1. java代码
        JavaCodeBuilder javaCodeBuilder = new JavaCodeBuilder();
        String javaCode = javaCodeBuilder.build(dataGenerateConfigInfoDTO);

        // 2. json代码
        JsonCodeBuilder jsonCodeBuilder = new JsonCodeBuilder();
        String jsonCode = jsonCodeBuilder.build(dataGenerateConfigInfoDTO);

        // 3. typescript代码
        TypescriptCodeBuilder typescriptCodeBuilder = new TypescriptCodeBuilder();
        String typescriptCode = typescriptCodeBuilder.build(dataGenerateConfigInfoDTO);
        CodeDataBO codeDataBO = CodeDataBO.builder()
                .javaCode(javaCode)
                .jsonCode(jsonCode)
                .typescriptCode(typescriptCode)
                .build();
        return codeDataBO;
    }

    /**
     * 模拟数据生成器
     *
     * @param dataGenerateConfigInfoDTO 生成数据配置信息
     * @return List<Map<String, Object>>
     */
    default List<Map<String, Object>> buildData(DataGenerateConfigInfoDTO dataGenerateConfigInfoDTO) {
        FieldInfoBO[] fields = dataGenerateConfigInfoDTO.getFields();
        int count = dataGenerateConfigInfoDTO.getCount();
        List<Object[]> dataList = new ArrayList<>();
        for (FieldInfoBO field : fields) {
            IMockStrategy mockStrategy = MOCK_STRATEGY_FACTORY.produce(field.getMockDataType());
            Object[] data = mockStrategy.getData(count, field);
            dataList.add(data);
        }
        ArrayList<Map<String, Object>> dataListMap = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            HashMap<String, Object> dataMap = new HashMap<>(8);
            for (int j = 0; j < fields.length; j++) {
                dataMap.put(fields[j].getName(), dataList.get(j)[i]);
            }
            dataListMap.add(dataMap);
        }
        return dataListMap;
    }
}
