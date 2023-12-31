package com.kkuil.sqleasy.model.bo;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author Kkuil
 * @Date 2023/9/4 0:38
 * @Description 存入token中的数据
 */
@Data
@Accessors(chain = true)
@Builder
public class MapDataInTokenBO {
    /**
     * 用户名
     */
    private String username;
}
