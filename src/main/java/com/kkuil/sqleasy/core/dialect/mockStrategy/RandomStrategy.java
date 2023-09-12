package com.kkuil.sqleasy.core.dialect.mockStrategy;

import cn.hutool.core.util.StrUtil;
import com.kkuil.sqleasy.core.dialect.mockStrategy.randomStrategy.IMockRandomStrategy;
import com.kkuil.sqleasy.core.dialect.mockStrategy.randomStrategy.IMockRandomStrategyFactory;
import com.kkuil.sqleasy.core.dialect.mockStrategy.randomStrategy.MockRandomStrategyFactory;
import com.kkuil.sqleasy.core.enums.MockRandomDataEnum;
import com.kkuil.sqleasy.core.model.bo.FieldInfoBO;

/**
 * @Author Kkuil
 * @Date 2023/9/5 9:18
 * @Description 随机策略
 */
public class RandomStrategy implements IMockStrategy {

    /**
     * 模拟随机策略工厂
     */
    public static final IMockRandomStrategyFactory MOCK_RANDOM_STRATEGY_FACTORY = new MockRandomStrategyFactory();

    /**
     * 获取值
     *
     * @param count 模拟数量
     * @param field 字段配置信息
     * @return 数据
     */
    @Override
    public String[] getData(int count, FieldInfoBO field) {
        // 1. 获取额外信息（随机策略）
        String randomStrategyId = field.getExtraInfo().toString();
        // 2. 从随机工厂中获取随机数据加载器
        IMockRandomStrategy strategy =
                StrUtil.isBlank(randomStrategyId)
                        ? MOCK_RANDOM_STRATEGY_FACTORY.produce(MockRandomDataEnum.DEFAULT.getId())
                        : MOCK_RANDOM_STRATEGY_FACTORY.produce(Integer.parseInt(randomStrategyId));
        // 3. 获取随机数据，返回
        String[] randomData = strategy.getRandomData(count);
        return randomData;
    }
}
