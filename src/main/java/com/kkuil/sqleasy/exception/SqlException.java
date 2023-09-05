package com.kkuil.sqleasy.exception;

/**
 * @Author Kkuil
 * @Date 2023/9/5 8:26
 * @Description SQL异常
 */
public class SqlException extends RuntimeException{
    public SqlException() {
    }

    public SqlException(String message) {
        super(message);
    }
}
