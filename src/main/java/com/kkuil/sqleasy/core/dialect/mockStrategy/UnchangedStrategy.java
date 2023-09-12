package com.kkuil.sqleasy.core.dialect.mockStrategy;

import cn.hutool.core.util.ArrayUtil;
import com.kkuil.sqleasy.core.model.bo.FieldInfoBO;

import java.util.ArrayList;
import java.util.List;

import static com.kkuil.sqleasy.constant.GlobalConst.EMPTY_STR;

/**
 * @Author Kkuil
 * @Date 2023/9/5 9:18
 * @Description 固定策略
 */
public class UnchangedStrategy implements IMockStrategy {
    /**
     * 获取值
     *
     * @param count 模拟数量
     * @param field 字段配置信息
     * @return 数据
     */
    @Override
    public Object[] getData(int count, FieldInfoBO field) {
        List<Object> data = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            data.add(field.getExtraInfo());
        }
        return ArrayUtil.toArray(data, Object.class);
    }
}
