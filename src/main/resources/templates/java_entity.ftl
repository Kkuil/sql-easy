<#-- Java 实体模板 -->
import lombok.Data;

/**
* ${comment}
*/
@Data
public class ${clazz} implements Serializable {

    <#-- 序列化 -->
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

<#-- 循环生成字段 ---------->
<#list fieldList as field>
    <#if field.comment!?length gt 0>
    /**
    * ${field.comment}
    */
    </#if>
    @TableField(value = ${field.name})
    private ${field.type} ${field.name};

</#list>
}
