package com.kkuil.sqleasy.aspect;

import com.kkuil.sqleasy.anotations.Validate;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Author Kkuil
 * @Date 2023/9/5 17:34
 * @Description 验参切面类
 */
@Aspect
@Slf4j
public class ValidateAspect {

    @Pointcut("@anotation(com.kkuil.sqleasy.anotations.Validate)")
    public void validate() {}

    @Before("validate()")
    public void before(JoinPoint point) {
        // 获取方法参数
        Object[] args = point.getArgs();

        for (Object arg : args) {
            // 判断参数是否有@Validate注解
            if (arg.getClass().isAnnotationPresent(Validate.class)) {
                Validate validateAnnotation = arg.getClass().getAnnotation(Validate.class);
                // 获取注解的值
                log.error("rule: {}", validateAnnotation.rule());
                log.error("extra: {}", validateAnnotation.extra());
            }
        }
    }
}
