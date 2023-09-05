package com.kkuil.sqleasy.exception.handler;

import com.kkuil.sqleasy.exception.NecessaryFieldsIsEmptyException;
import com.kkuil.sqleasy.exception.SqlException;
import com.kkuil.sqleasy.utils.ResultUtil;
import org.springframework.expression.AccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author kkuil
 * @Date 2023/08/03 23:00
 * @Description 业务异常处理器
 */
@ControllerAdvice
public class BusinessExceptionHandler {
    /**
     * @param e NecessaryFieldsIsEmptyException
     * @return ResultUtil<Boolean>
     * @description 必要字段为空异常
     */
    @ExceptionHandler(value = NecessaryFieldsIsEmptyException.class)
    public ResultUtil<Boolean> handleNecessaryFieldsIsEmptyException(NecessaryFieldsIsEmptyException e) {
        return ResultUtil.error(e.getMessage(), false);
    }

    /**
     * @param e SqlException
     * @return ResultUtil<Boolean>
     * @description sql异常
     */
    @ExceptionHandler(value = SqlException.class)
    public ResultUtil<Boolean> handleSqlException(SqlException e) {
        return ResultUtil.error(e.getMessage(), false);
    }
}
