package com.kkuil.sqleasy.core.dialect.builders.codeBuilders;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kkuil.sqleasy.core.dialect.builders.IDataBuilder;
import com.kkuil.sqleasy.core.model.dto.DataGenerateConfigInfoDTO;

/**
 * @Author Kkuil
 * @Date 2023/9/4 18:34
 * @Description Json代码构造器
 */
public class JsonCodeBuilder implements IDataBuilder {
    /**
     * 生成数据
     *
     * @param dataGenerateConfigInfoDTO 生成数据配置信息
     * @return 数据
     */
    @Override
    public String build(DataGenerateConfigInfoDTO dataGenerateConfigInfoDTO) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(dataGenerateConfigInfoDTO.getMockData());
    }
}
