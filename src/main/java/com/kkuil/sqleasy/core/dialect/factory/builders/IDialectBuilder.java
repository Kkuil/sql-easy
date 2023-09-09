package com.kkuil.sqleasy.core.dialect.factory.builders;

import com.kkuil.sqleasy.core.dialect.builders.IDataBuilder;
import com.kkuil.sqleasy.core.dialect.builders.codeBuilders.JavaCodeBuilder;
import com.kkuil.sqleasy.core.dialect.builders.codeBuilders.JsonCodeBuilder;
import com.kkuil.sqleasy.core.dialect.builders.codeBuilders.TypescriptCodeBuilder;
import com.kkuil.sqleasy.core.dialect.builders.otherBuilders.ExcelExportBuilder;
import com.kkuil.sqleasy.core.dialect.mockStrategy.IMockStrategy;
import com.kkuil.sqleasy.core.model.bo.CodeDataBO;
import com.kkuil.sqleasy.core.model.bo.FieldInfoBO;
import com.kkuil.sqleasy.core.model.bo.OtherDataBO;
import com.kkuil.sqleasy.core.model.bo.SqlDataBO;
import com.kkuil.sqleasy.core.model.dto.DataGenerateConfigInfoDTO;
import jakarta.validation.constraints.NotBlank;

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
    SqlDataBO buildSql(DataGenerateConfigInfoDTO dataGenerateConfigInfoDTO, @NotBlank(message = "模拟数据不能为空") List<Map<String, Object>> data);

    /**
     * 代码构造器
     *
     * @param dataGenerateConfigInfoDTO 生成数据配置信息
     * @return CodeDataBO
     */
    default CodeDataBO buildCode(DataGenerateConfigInfoDTO dataGenerateConfigInfoDTO, @NotBlank(message = "模拟数据不能为空") List<Map<String, Object>> data) {
        // 1. java代码
        IDataBuilder javaCodeBuilder = new JavaCodeBuilder();
        String javaCode = javaCodeBuilder.build(dataGenerateConfigInfoDTO, data);

        // 2. json代码
        IDataBuilder jsonCodeBuilder = new JsonCodeBuilder();
        String jsonCode = jsonCodeBuilder.build(dataGenerateConfigInfoDTO, data);

        // 3. typescript代码
        IDataBuilder typescriptCodeBuilder = new TypescriptCodeBuilder();
        String typescriptCode = typescriptCodeBuilder.build(dataGenerateConfigInfoDTO, data);
        CodeDataBO codeDataBO = CodeDataBO.builder()
                .javaCode(javaCode)
                .jsonCode(jsonCode)
                .typescriptCode(typescriptCode)
                .build();
        return codeDataBO;
    }

    /**
     * 其他数据构造器
     *
     * @param dataGenerateConfigInfoDTO 配置信息
     * @param data                      模拟数据
     * @return 其他数据
     */
    default OtherDataBO buildOther(DataGenerateConfigInfoDTO dataGenerateConfigInfoDTO, @NotBlank(message = "模拟数据不能为空") List<Map<String, Object>> data) {
        OtherDataBO otherData = new OtherDataBO();

        // 1. 获取excel下载地址
        ExcelExportBuilder excelExportBuilder = new ExcelExportBuilder();
        String excel = excelExportBuilder.build(dataGenerateConfigInfoDTO, data);

        otherData.setExcel(excel);
        return otherData;
    }

    /**
     * 模拟数据生成器
     *
     * @param dataGenerateConfigInfoDTO 生成数据配置信息
     * @return List<Map < String, Object>>
     */
    default List<Map<String, Object>> buildData(DataGenerateConfigInfoDTO dataGenerateConfigInfoDTO) {
        FieldInfoBO[] fields = dataGenerateConfigInfoDTO.getFields();
        int count = dataGenerateConfigInfoDTO.getCount();
        List<Object[]> dataList = new ArrayList<>();
        // 1. 生成模拟数据
        for (FieldInfoBO field : fields) {
            IMockStrategy mockStrategy = MOCK_STRATEGY_FACTORY.produce(field.getMockDataType());
            Object[] data = mockStrategy.getData(count, field);
            dataList.add(data);
        }
        // 2. 调整格式
        List<Map<String, Object>> dataListMap = new ArrayList<>();
        for (int i = 0; i < dataGenerateConfigInfoDTO.getCount(); i++) {
            Map<String, Object> dataMap = new HashMap<>(8);
            for (int j = 0; j < fields.length; j++) {
                dataMap.put(fields[j].getName(), dataList.get(j)[i]);
            }
            dataListMap.add(dataMap);
        }
        return dataListMap;
    }
}
