package com.kkuil.sqleasy.core.enums;

import com.kkuil.sqleasy.core.model.vo.MockDataVO;

import java.util.*;

/**
 * @Author Kkuil
 * @Date 2023/9/4 16:50
 * @Description 模拟数据类型的枚举类
 */
public enum MockDataTypeEnum {
    /**
     * 固定
     */
    UNCHANGED(1001, "固定"),

    /**
     * 随机
     */
    RANDOM(1002, "随机"),

    /**
     * 自增
     */
    AUTO_INCREMENT(1003, "自增"),

    /**
     * 默认策略
     */
    DEFAULT(1007, "默认");

    /**
     * ID
     */
    private final int id;

    /**
     * 名
     */
    private final String name;

    MockDataTypeEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    /**
     * 获取当前类型的key: value结构
     *
     * @return key: value list
     */
    public static List<MockDataVO> collect() {
        List<MockDataVO> list = new ArrayList<>();
        Arrays.stream(MockDataTypeEnum.values()).forEach(data -> {
            MockDataVO mockDataVO = new MockDataVO();
            mockDataVO
                    .setId(data.getId())
                    .setName(data.getName());
            list.add(mockDataVO);
        });
        return list;
    }
}
