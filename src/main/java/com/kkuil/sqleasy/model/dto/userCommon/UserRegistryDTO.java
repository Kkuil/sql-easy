package com.kkuil.sqleasy.model.dto.userCommon;

import lombok.Data;

/**
 * @Author Kkuil
 * @Date 2023/9/3 16:37
 * @Description 用户注册提交信息
 */
@Data
public class UserRegistryDTO {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
