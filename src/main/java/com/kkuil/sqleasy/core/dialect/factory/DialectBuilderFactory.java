package com.kkuil.sqleasy.core.dialect.factory;

import com.kkuil.sqleasy.core.dialect.factory.builders.IDialectBuilder;
import com.kkuil.sqleasy.core.dialect.factory.builders.MySqlBuilder;
import com.kkuil.sqleasy.core.model.vo.GeneratedAllDataVO;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Kkuil
 * @Date 2023/9/4 18:45
 * @Description SQL方言加工厂
 */
@Component
public class DialectBuilderFactory implements IDialectBuilderFactory {

    /**
     * 方言构造器Map
     */
    public static final Map<String, IDialectBuilder<GeneratedAllDataVO>> DIALECT_BUILDER_MAP = new HashMap<>(8);

    static {
        DIALECT_BUILDER_MAP.put("mysql", new MySqlBuilder());
    }

    /**
     * 生成
     *
     * @return 数据
     */
    @Override
    public IDialectBuilder<GeneratedAllDataVO> produce(String builderName) {
        return DIALECT_BUILDER_MAP.get(builderName);
    }
}
