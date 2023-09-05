package com.kkuil.sqleasy.anotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author Kkuil
 * @Date 2023/9/5 17:23
 * @Description 验参
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.PARAMETER)
public @interface Validate {

    /**
     * EMPTY, LENGTH, REGULAR
     */
    String rule() default "EMPTY";

    /**
     * 额外信息
     */
    String extra() default "";
}
