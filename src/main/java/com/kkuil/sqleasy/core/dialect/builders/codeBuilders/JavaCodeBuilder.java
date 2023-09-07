package com.kkuil.sqleasy.core.dialect.builders.codeBuilders;

import com.kkuil.sqleasy.core.dialect.builders.IDataBuilder;
import com.kkuil.sqleasy.core.model.bo.FieldInfoBO;
import com.kkuil.sqleasy.core.model.bo.JavaEntityBO;
import com.kkuil.sqleasy.core.model.dto.DataGenerateConfigInfoDTO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author Kkuil
 * @Date 2023/9/4 18:34
 * @Description Java代码构造器
 */
@Component
public class JavaCodeBuilder implements IDataBuilder {

    private static Configuration configuration;

    @Resource
    public void setConfiguration(Configuration configuration) {
        JavaCodeBuilder.configuration = configuration;
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
        ArrayList<JavaEntityBO.FieldInfo> fieldList = new ArrayList<>();
        FieldInfoBO[] fields = dataGenerateConfigInfoDTO.getFields();
        for (FieldInfoBO field : fields) {
            JavaEntityBO.FieldInfo fieldInfo = new JavaEntityBO.FieldInfo();
            fieldInfo
                    .setName(field.getName())
                    .setType(field.getType())
                    .setComment(field.getComment());
            fieldList.add(fieldInfo);
        }
        // 4. 构建参数
        JavaEntityBO javaEntityBO = JavaEntityBO.builder()
                .clazz(clazz)
                .comment(comment)
                .fieldList(fieldList)
                .build();
        StringWriter stringWriter = new StringWriter();
        try {
            Template temp = configuration.getTemplate("java_entity.ftl");
            temp.process(javaEntityBO, stringWriter);
            return stringWriter.toString();
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
    }
}
