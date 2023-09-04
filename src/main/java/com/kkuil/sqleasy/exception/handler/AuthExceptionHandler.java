package com.kkuil.sqleasy.exception.handler;

import com.kkuil.sqleasy.utils.ResultUtil;
import org.springframework.expression.AccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author kkuil
 * @Date 2023/08/03 23:00
 * @Description 权限异常处理器
 */
@ControllerAdvice
public class AuthExceptionHandler {
    /**
     * @param e Exception
     * @return ResponseEntity
     * @description 处理未登录异常
     */
    @ExceptionHandler(value = AccessException.class)
    public ResultUtil<Boolean> handleAuthException(AccessException e) {
        return ResultUtil.error(e.getMessage(), false);
    }
}
