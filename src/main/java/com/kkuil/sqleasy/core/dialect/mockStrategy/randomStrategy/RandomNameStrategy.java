package com.kkuil.sqleasy.core.dialect.mockStrategy.randomStrategy;

import cn.hutool.core.util.ArrayUtil;
import com.kkuil.sqleasy.utils.RandomUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Kkuil
 * @Date 2023/9/9 16:34
 * @Description 随机人名戳策略
 */
public class RandomNameStrategy implements IMockRandomStrategy{
    /**
     * 获取值
     *
     * @param count 模拟数量

     * @return 数据
     */
    @Override
    public String[] getRandomData(int count) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String name = RandomUtil.randomPhone();
            list.add(name);
        }
        return ArrayUtil.toArray(list, String.class);
    }
}
