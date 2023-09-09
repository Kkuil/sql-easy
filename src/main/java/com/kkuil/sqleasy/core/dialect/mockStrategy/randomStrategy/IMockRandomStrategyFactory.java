package com.kkuil.sqleasy.core.dialect.mockStrategy.randomStrategy;

/**
 * @Author Kkuil
 * @Date 2023/9/5 10:15
 * @Description 模拟随机数据策略工厂接口
 */
public interface IMockRandomStrategyFactory {

    /**
     * 生产模拟数据策略
     *
     * @param id 策略ID
     * @return 具体策略
     */
    IMockRandomStrategy produce(int id);
}
