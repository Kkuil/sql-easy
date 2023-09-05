package com.kkuil.sqleasy.core.dialect.mockStrategy;

import com.kkuil.sqleasy.core.enums.MockDataTypeEnum;
import io.jsonwebtoken.impl.crypto.MacProvider;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Kkuil
 * @Date 2023/9/5 10:11
 * @Description 模拟数据策略工厂
 */
public class MockStrategyFactory implements IMockStrategyFactory {

    /**
     * 模拟数据策略映射
     */
    public static final Map<Integer, IMockStrategy> MOCK_STRATEGY_MAP = new HashMap<>(8);

    static {
        MOCK_STRATEGY_MAP.put(MockDataTypeEnum.AUTO_INCREMENT.getId(), new AutoIncrementStrategy());
        MOCK_STRATEGY_MAP.put(MockDataTypeEnum.NON.getId(), new NullStrategy());
        MOCK_STRATEGY_MAP.put(MockDataTypeEnum.RANDOM.getId(), new AutoIncrementStrategy());
        MOCK_STRATEGY_MAP.put(MockDataTypeEnum.REGULAR.getId(), new AutoIncrementStrategy());
        MOCK_STRATEGY_MAP.put(MockDataTypeEnum.UNCHANGED.getId(), new AutoIncrementStrategy());
        MOCK_STRATEGY_MAP.put(MockDataTypeEnum.VOCABULARY.getId(), new AutoIncrementStrategy());
    }


    /**
     * 生产模拟数据策略
     *
     * @param id 策略ID
     * @return 具体策略
     */
    @Override
    public IMockStrategy produce(int id) {
        return MOCK_STRATEGY_MAP.get(id);
    }
}
