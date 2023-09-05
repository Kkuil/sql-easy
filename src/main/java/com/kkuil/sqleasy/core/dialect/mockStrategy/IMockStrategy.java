package com.kkuil.sqleasy.core.dialect.mockStrategy;

import com.kkuil.sqleasy.core.model.bo.FieldInfoBO;

/**
 * @Author Kkuil
 * @Date 2023/9/5 9:22
 * @Description 模拟策略接口
 */
public interface IMockStrategy {

    /**
     * 获取值
     *
     * @param count 模拟数量
     * @param field 字段配置信息
     * @return 数据
     */
    Object[] getData(int count, FieldInfoBO field);
}
