package com.kkuil.sqleasy.core.dialect.mockStrategy;

import cn.hutool.core.util.ArrayUtil;
import com.kkuil.sqleasy.core.model.bo.FieldInfoBO;

import java.util.ArrayList;

import static com.kkuil.sqleasy.constant.GlobalConst.EMPTY_STR;

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
            int start;
            if (EMPTY_STR.equals(field.getExtraInfo().toString())) {
                start = 0;
            } else {
                start = Integer.parseInt(field.getExtraInfo().toString());
            }
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
