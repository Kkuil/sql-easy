package com.kkuil.sqleasy.core.model.bo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author Kkuil
 * @Date 2023/9/8 12:57
 * @Description 其他数据业务实体类
 */
@Data
@Accessors(chain = true)
public class OtherDataBO {
    /**
     * excel下载地址
     */
    private String excel;
}
