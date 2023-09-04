package com.kkuil.sqleasy.core.model.bo;

import lombok.Builder;
import lombok.Data;

/**
 * @Author Kkuil
 * @Date 2023/9/4 21:29
 * @Description sql
 */
@Data
@Builder
public class SqlDataBO {
    /**
     * 建表语句
     */
    private String createTableSql;

    /**
     * 模拟数据insert
     */
    private String insertSql;
}
