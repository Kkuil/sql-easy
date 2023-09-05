package com.kkuil.sqleasy.enums;

/**
 * @Author Kkuil
 * @Date 2023/9/5 17:47
 * @Description 验参规则
 */
public enum ValidateRuleEnum {

    /**
     * 判空
     */
    EMPTY("EMPTY"),

    /**
     * 判长
     */
    LENGTH("LENGTH"),

    /**
     * 判正则
     */
    REGULAR("REGULAR");

    public final String name;

    ValidateRuleEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
