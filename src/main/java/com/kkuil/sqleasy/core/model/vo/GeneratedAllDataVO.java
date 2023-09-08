package com.kkuil.sqleasy.core.model.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @Author Kkuil
 * @Date 2023/9/4 18:12
 * @Description 生成的所有数据
 */
@Data
@Builder
public class GeneratedAllDataVO {
    /**
     * 建表语句
     */
    private String createTableSql;

    /**
     * 插入模拟数据insert语句
     */
    private String insertSql;

    /**
     * json代码
     */
    private String jsonCode;

    /**
     * java代码
     */
    private String javaCode;

    /**
     * typescript代码
     */
    private String typescriptCode;

    /**
     * excel下载地址
     */
    private String excel;
}
