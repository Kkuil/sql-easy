<#-- Typescript 类型生成模板 -->
/**
* ${comment}
*/
interface ${clazz} {
<#-- 循环生成字段 ---------->
<#list fieldList as field>
    // ${field.comment}
    ${field.name}: ${field.type};
</#list>
}
