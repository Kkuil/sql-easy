package com.kkuil.sqleasy.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author Kkuil
 * @Date 2023/9/10 17:20
 * @Description 用户信息
 */
@Data
@Accessors(chain = true)
public class UserAuthInfoVO {
    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;
}
