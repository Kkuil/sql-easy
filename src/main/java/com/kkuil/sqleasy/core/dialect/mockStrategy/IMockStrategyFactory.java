package com.kkuil.sqleasy.core.dialect.mockStrategy;

/**
 * @Author Kkuil
 * @Date 2023/9/5 10:15
 * @Description 模拟数据策略工厂接口
 */
public interface IMockStrategyFactory {

    /**
     * 生产模拟数据策略
     *
     * @param id 策略ID
     * @return 具体策略
     */
    IMockStrategy produce(int id);
}
