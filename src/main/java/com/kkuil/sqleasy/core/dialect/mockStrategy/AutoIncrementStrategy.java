package com.kkuil.sqleasy.core.dialect.mockStrategy;

import cn.hutool.core.util.ArrayUtil;
import com.kkuil.sqleasy.core.model.bo.FieldInfoBO;

import java.util.ArrayList;

/**
 * @Author Kkuil
 * @Date 2023/9/5 9:19
 * @Description 自增策略
 */
public class AutoIncrementStrategy implements IMockStrategy {

    public static final Integer[] DEFAULT_VALUE = {};

    /**
     * 获取值
     *
     * @param count 模拟数量
     * @param field 类配置信息
     * @return 数据
     */
    @Override
    public Object[] getData(int count, FieldInfoBO field) {
        try {
            // 起始值
            int start = (int) field.getExtraInfo();
            ArrayList<Integer> data = new ArrayList<>(count);
            for (int i = start; i < count; i++) {
                data.add(i);
            }
            return ArrayUtil.toArray(data, Integer.class);
        } catch (ClassCastException e) {
            return DEFAULT_VALUE;
        }
    }
}
