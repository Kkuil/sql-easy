package com.kkuil.sqleasy.core.dialect.builders.codeBuilders;

import com.kkuil.sqleasy.core.dialect.builders.IDataBuilder;
import com.kkuil.sqleasy.core.model.bo.FieldInfoBO;
import com.kkuil.sqleasy.core.model.bo.TypescriptCodeBO;
import com.kkuil.sqleasy.core.model.dto.DataGenerateConfigInfoDTO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.kkuil.sqleasy.constant.GlobalConst.EMPTY_STR;

/**
 * @Author Kkuil
 * @Date 2023/9/4 18:35
 * @Description Typescript代码构造器
 */
@Component
public class TypescriptCodeBuilder implements IDataBuilder {


    /**
     * MySQL字段类型与Typescript类型的映射关系
     */
    public static final Map<String, String> MYSQL_FIELD_TYPE_MAP_TYPESCRIPT_TYPE = new HashMap<>(8);

    /**
     * 默认类型
     */
    public static final String DEFAULT_TYPE = "string";

    // 初始化
    static {
        MYSQL_FIELD_TYPE_MAP_TYPESCRIPT_TYPE.put("tinyint", "number");
        MYSQL_FIELD_TYPE_MAP_TYPESCRIPT_TYPE.put("smallint", "number");
        MYSQL_FIELD_TYPE_MAP_TYPESCRIPT_TYPE.put("mediumint", "number");
        MYSQL_FIELD_TYPE_MAP_TYPESCRIPT_TYPE.put("int", "number");
        MYSQL_FIELD_TYPE_MAP_TYPESCRIPT_TYPE.put("bigint", "string");
        MYSQL_FIELD_TYPE_MAP_TYPESCRIPT_TYPE.put("float", "number");
        MYSQL_FIELD_TYPE_MAP_TYPESCRIPT_TYPE.put("double", "number");
        MYSQL_FIELD_TYPE_MAP_TYPESCRIPT_TYPE.put("decimal", "number");
        MYSQL_FIELD_TYPE_MAP_TYPESCRIPT_TYPE.put("date", "string");
        MYSQL_FIELD_TYPE_MAP_TYPESCRIPT_TYPE.put("time", "string");
        MYSQL_FIELD_TYPE_MAP_TYPESCRIPT_TYPE.put("datetime", "string");
        MYSQL_FIELD_TYPE_MAP_TYPESCRIPT_TYPE.put("timestamp", "string");
        MYSQL_FIELD_TYPE_MAP_TYPESCRIPT_TYPE.put("char", "string");
        MYSQL_FIELD_TYPE_MAP_TYPESCRIPT_TYPE.put("varchar", "string");
        MYSQL_FIELD_TYPE_MAP_TYPESCRIPT_TYPE.put("tinytext", "string");
        MYSQL_FIELD_TYPE_MAP_TYPESCRIPT_TYPE.put("text", "string");
        MYSQL_FIELD_TYPE_MAP_TYPESCRIPT_TYPE.put("mediumtext", "string");
        MYSQL_FIELD_TYPE_MAP_TYPESCRIPT_TYPE.put("longtext", "string");
        MYSQL_FIELD_TYPE_MAP_TYPESCRIPT_TYPE.put("tinyblob", "string");
        MYSQL_FIELD_TYPE_MAP_TYPESCRIPT_TYPE.put("blob", "string");
        MYSQL_FIELD_TYPE_MAP_TYPESCRIPT_TYPE.put("mediumblob", "string");
        MYSQL_FIELD_TYPE_MAP_TYPESCRIPT_TYPE.put("longblob", "string");
        MYSQL_FIELD_TYPE_MAP_TYPESCRIPT_TYPE.put("binary", "string");
        MYSQL_FIELD_TYPE_MAP_TYPESCRIPT_TYPE.put("varbinary", "string");
    }


    private static Configuration configuration;

    @Resource
    public void setConfiguration(Configuration configuration) {
        TypescriptCodeBuilder.configuration = configuration;
    }

    /**
     * 生成数据
     *
     * @param dataGenerateConfigInfoDTO 生成数据配置信息
     * @param data                      模拟数据
     * @return Java代码
     */
    @Override
    public String build(DataGenerateConfigInfoDTO dataGenerateConfigInfoDTO, List<Map<String, Object>> data) {
        // 数据转化
        // 1. 类名
        String clazz = dataGenerateConfigInfoDTO.getTable();
        // 2. 类描述
        String comment = dataGenerateConfigInfoDTO.getComment();
        // 3. 字段信息
        ArrayList<TypescriptCodeBO.FieldInfo> fieldList = new ArrayList<>();
        FieldInfoBO[] fields = dataGenerateConfigInfoDTO.getFields();
        for (FieldInfoBO field : fields) {
            TypescriptCodeBO.FieldInfo fieldInfo = new TypescriptCodeBO.FieldInfo();
            String sqlType = field.getType().toLowerCase();
            String type = MYSQL_FIELD_TYPE_MAP_TYPESCRIPT_TYPE.get(sqlType);
            if (EMPTY_STR.equals(type) || null == type) {
                type = DEFAULT_TYPE;
            }
            fieldInfo
                    .setName(field.getName())
                    .setType(type)
                    .setComment(field.getComment());
            fieldList.add(fieldInfo);
        }
        // 4. 构建参数
        TypescriptCodeBO typescriptCodeBO = new TypescriptCodeBO();
        typescriptCodeBO.setClazz(clazz)
                .setComment(comment)
                .setFieldList(fieldList);
        StringWriter stringWriter = new StringWriter();
        try {
            Template temp = configuration.getTemplate("typescript.ftl");
            temp.process(typescriptCodeBO, stringWriter);
            return stringWriter.toString();
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
    }
}
