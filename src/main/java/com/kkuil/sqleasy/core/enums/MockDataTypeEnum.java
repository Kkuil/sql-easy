package com.kkuil.sqleasy.core.enums;

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
     * 正则匹配
     */
    REGULAR(1004, "正则匹配"),

    /**
     * 词库
     */
    VOCABULARY(1005, "词库"),

    /**
     * 不模拟
     */
    NON(1006, "不模拟");

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
    public static List<Map<String, Object>> collect() {
        ArrayList<Map<String, Object>> list = new ArrayList<>();
        Arrays.stream(MockDataTypeEnum.values()).forEach(type -> {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", type.id);
            map.put("name", type.name);
            list.add(map);
        });
        return list;
    }
}
