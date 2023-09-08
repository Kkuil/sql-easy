package com.kkuil.sqleasy.core.enums;

import com.kkuil.sqleasy.core.model.vo.SqlFieldVO;

import java.util.*;

/**
 * @Author Kkuil
 * @Date 2023/9/4 16:50
 * @Description SQL字段类型枚举类
 */
public enum MySqlFieldTypeEnum {
    /**
     * tinyint
     */
    TINYINT(1001, "tinyint"),
    /**
     * smallint
     */
    SMALLINT(1002, "smallint"),
    /**
     * mediumint
     */
    MEDIUMINT(1003, "mediumint"),
    /**
     * int
     */
    INT(1004, "int"),
    /**
     * bigint
     */
    BIGINT(1005, "bigint"),
    /**
     * float
     */
    FLOAT(1006, "float"),
    /**
     * double
     */
    DOUBLE(1007, "double"),
    /**
     * decimal
     */
    DECIMAL(1008, "decimal"),
    /**
     * date
     */
    DATE(1009, "date"),
    /**
     * time
     */
    TIME(1010, "time"),
    /**
     * datetime
     */
    DATETIME(1011, "datetime"),
    /**
     * timestamp
     */
    TIMESTAMP(1012, "timestamp"),
    /**
     * char
     */
    CHAR(1013, "char"),
    /**
     * varchar
     */
    VARCHAR(1014, "varchar"),
    /**
     * tinytext
     */
    TINYTEXT(1015, "tinytext"),
    /**
     * text
     */
    TEXT(1016, "text"),
    /**
     * mediumtext
     */
    MEDIUMTEXT(1017, "mediumtext"),
    /**
     * longtext
     */
    LONGTEXT(1018, "longtext"),
    /**
     * tinyblob
     */
    TINYBLOB(1019, "tinyblob"),
    /**
     * blob
     */
    BLOB(1020, "blob"),
    /**
     * mediumblob
     */
    MEDIUMBLOB(1021, "mediumblob"),
    /**
     * longblob
     */
    LONGBLOB(1022, "longblob"),
    /**
     * binary
     */
    BINARY(1023, "binary"),
    /**
     * varbinary
     */
    VARBINARY(1024, "varbinary");

    /**
     * ID
     */
    private final int id;

    /**
     * 类型
     */
    private final String type;

    MySqlFieldTypeEnum(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    /**
     * 获取当前类型的key: value结构
     *
     * @return key: value list
     */
    public static List<SqlFieldVO> collect() {
        ArrayList<SqlFieldVO> list = new ArrayList<>();
        Arrays.stream(MySqlFieldTypeEnum.values()).forEach(field -> {
            SqlFieldVO sqlFieldVO = new SqlFieldVO();
            sqlFieldVO.setId(field.getId())
                    .setType(field.getType());
            list.add(sqlFieldVO);
        });
        return list;
    }
}
