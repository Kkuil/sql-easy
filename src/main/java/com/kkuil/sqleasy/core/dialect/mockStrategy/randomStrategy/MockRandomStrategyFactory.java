package com.kkuil.sqleasy.core.dialect.mockStrategy.randomStrategy;

import cn.hutool.core.util.ObjectUtil;
import com.kkuil.sqleasy.core.enums.MockRandomDataEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Kkuil
 * @Date 2023/9/5 10:11
 * @Description 模拟数据策略工厂
 */
public class MockRandomStrategyFactory implements IMockRandomStrategyFactory {

    /**
     * 模拟随机数据策略映射
     */
    public static final Map<Integer, IMockRandomStrategy> MOCK_RAMDOM_STRATEGY_MAP = new HashMap<>(8);

    static {
        MOCK_RAMDOM_STRATEGY_MAP.put(MockRandomDataEnum.TIMESTAMP.getId(), new RandomTimestampStrategy());
        MOCK_RAMDOM_STRATEGY_MAP.put(MockRandomDataEnum.WEBSITE.getId(), new RandomWebsiteStrategy());
        MOCK_RAMDOM_STRATEGY_MAP.put(MockRandomDataEnum.IP.getId(), new RandomIpStrategy());
        MOCK_RAMDOM_STRATEGY_MAP.put(MockRandomDataEnum.EMAIL.getId(), new RandomEmailStrategy());
        MOCK_RAMDOM_STRATEGY_MAP.put(MockRandomDataEnum.PHONE.getId(), new RandomPhoneStrategy());
        MOCK_RAMDOM_STRATEGY_MAP.put(MockRandomDataEnum.NAME.getId(), new RandomNameStrategy());
        MOCK_RAMDOM_STRATEGY_MAP.put(MockRandomDataEnum.CITY.getId(), new RandomCityStrategy());
        MOCK_RAMDOM_STRATEGY_MAP.put(MockRandomDataEnum.UNIVERSITY.getId(), new RandomUniversityStrategy());
        MOCK_RAMDOM_STRATEGY_MAP.put(MockRandomDataEnum.DEFAULT.getId(), new RandomDefaultStrategy());
    }


    /**
     * 生产模拟数据随机策略
     *
     * @param id 策略ID
     * @return 具体随机策略
     */
    @Override
    public IMockRandomStrategy produce(int id) {
        IMockRandomStrategy strategy = MOCK_RAMDOM_STRATEGY_MAP.get(id);
        if (ObjectUtil.isNull(strategy)) {
            return MOCK_RAMDOM_STRATEGY_MAP.get(MockRandomDataEnum.DEFAULT.getId());
        } else {
            return MOCK_RAMDOM_STRATEGY_MAP.get(id);
        }
    }
}
