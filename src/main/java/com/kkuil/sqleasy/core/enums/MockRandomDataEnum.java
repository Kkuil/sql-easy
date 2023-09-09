package com.kkuil.sqleasy.core.enums;

import com.kkuil.sqleasy.core.model.vo.MockRandomDataVO;

import java.util.*;

/**
 * @Author Kkuil
 * @Date 2023/9/9 16:01
 * @Description 模拟随机数据的策略
 */
public enum MockRandomDataEnum {
    /**
     * 时间戳
     */
    TIMESTAMP(1001, "时间戳"),
    /**
     * 网址
     */
    WEBSITE(1002, "网址"),
    /**
     * IP
     */
    IP(1003, "IP"),
    /**
     * 邮箱
     */
    EMAIL(1004, "邮箱"),
    /**
     * 手机号
     */
    PHONE(1005, "手机号"),
    /**
     * 人名
     */
    NAME(1006, "人名"),
    /**
     * 城市
     */
    CITY(1007, "城市"),
    /**
     * 大学名
     */
    UNIVERSITY(1008, "大学名"),
    /**
     * 默认策略
     */
    DEFAULT(1008, "默认");

    /**
     * ID
     */
    private final int id;

    /**
     * 名
     */
    private final String name;

    MockRandomDataEnum(int id, String name) {
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
    public static List<MockRandomDataVO> collect() {
        List<MockRandomDataVO> list = new ArrayList<>();
        Arrays.stream(MockRandomDataEnum.values()).forEach(data -> {
            MockRandomDataVO mockRandomDataVO = new MockRandomDataVO();
            mockRandomDataVO
                    .setId(data.getId())
                    .setName(data.getName());
            list.add(mockRandomDataVO);
        });
        return list;
    }
}
