package com.kkuil.sqleasy.core.dialect.mockStrategy.randomStrategy;

/**
 * @Author Kkuil
 * @Date 2023/9/5 9:22
 * @Description 模拟策略接口
 */
public interface IMockRandomStrategy {

    /**
     * 获取值
     *
     * @param count 模拟数量

     * @return 数据
     */
    String[] getRandomData(int count);
}
