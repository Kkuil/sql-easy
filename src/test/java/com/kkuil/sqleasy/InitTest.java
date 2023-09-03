package com.kkuil.sqleasy;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Kkuil
 * @Description 初始化测试类
 * @Date 2023/09/02
 */
@SpringBootTest
class InitTest {

    @Autowired
    private StringEncryptor stringEncryptor;

    @Test
    void testMysqlConnWithJasypt() {
        String username = "root";
        String password = "root123";
        String encryptUsername = stringEncryptor.encrypt(username);
        String encryptPassword = stringEncryptor.encrypt(password);
        System.out.println("encryptUsername = " + encryptUsername);
        System.out.println("encryptPassword = " + encryptPassword);
    }

    @Test
    void testRedisConnWithJasypt() {
        String password = "123456";
        String encryptPassword = stringEncryptor.encrypt(password);
        System.out.println("encryptPassword = " + encryptPassword);
    }

}
