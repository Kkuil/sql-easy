package com.kkuil.sqleasy.core.model.bo;

import lombok.Builder;
import lombok.Data;

/**
 * @Author Kkuil
 * @Date 2023/9/4 21:17
 * @Description 生成的代码业务数据
 */
@Data
@Builder
public class CodeDataBO {
    /**
     * java代码
     */
    private String javaCode;

    /**
     * json代码
     */
    private String jsonCode;

    /**
     * typescript代码
     */
    private String typescriptCode;
}
