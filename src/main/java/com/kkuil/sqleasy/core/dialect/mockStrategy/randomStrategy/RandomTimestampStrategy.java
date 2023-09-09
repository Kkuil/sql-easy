package com.kkuil.sqleasy.core.dialect.mockStrategy.randomStrategy;

import cn.hutool.core.util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Kkuil
 * @Date 2023/9/9 16:34
 * @Description 随机时间戳策略
 */
public class RandomTimestampStrategy implements IMockRandomStrategy {
    /**
     * 获取值
     *
     * @param count 模拟数量
     * @return 数据
     */
    @Override
    public String[] getRandomData(int count) {
        // 1. 获取当前时间戳
        long timestamp = System.currentTimeMillis();
        List<String> timestampList = new ArrayList<>(count);
        // 2. 添加随机时间戳，返回
        for (int i = 0; i < count; i++) {
            long temp = timestamp + i;
            timestampList.add(String.valueOf(temp));
        }
        return ArrayUtil.toArray(timestampList, String.class);
    }
}
