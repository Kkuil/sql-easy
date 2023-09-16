package com.kkuil.sqleasy.exception;

/**
 * @Author Kkuil
 * @Date 2023/9/5 8:26
 * @Description SQL异常
 */
public class SqlException extends RuntimeException{

    public static final String SQL_EXCEPTION_MESSAGE = "数据出了点小差，稍后再试~~";

    public SqlException() {
    }

    public SqlException(String message) {
        super(message);
    }
}
