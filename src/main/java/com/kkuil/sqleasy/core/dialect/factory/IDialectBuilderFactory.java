package com.kkuil.sqleasy.core.dialect.factory;

import com.kkuil.sqleasy.core.dialect.factory.builders.IDialectBuilder;
import com.kkuil.sqleasy.core.model.vo.GeneratedAllDataVO;

/**
 * @Author Kkuil
 * @Date 2023/9/4 18:47
 * @Description 工厂接口
 */
public interface IDialectBuilderFactory {

    /**
     * 生成
     * @param builderName 构造器名字
     * @return 数据
     */
    IDialectBuilder<GeneratedAllDataVO> produce(String builderName);
}
