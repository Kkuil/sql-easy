package com.kkuil.sqleasy.controller;

import com.kkuil.sqleasy.core.enums.MySqlFieldTypeEnum;
import com.kkuil.sqleasy.core.model.vo.SqlFieldVO;
import com.kkuil.sqleasy.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Kkuil
 * @Date 2023/9/8 19:25
 * @Description Sql控制器类
 */
@RestController
@Slf4j
@RequestMapping("/mysql")
public class MySqlController {

    /**
     * 获取字段类型列表
     *
     * @param keyword 关键词
     * @return 字段信息列表
     */
    @GetMapping("/field-type")
    public ResultUtil<List<SqlFieldVO>> listFieldInfo(String keyword) {
        List<SqlFieldVO> list = MySqlFieldTypeEnum.collect()
                .stream()
                .filter(field -> StringUtils.contains(field.getType(), keyword))
                .toList();
        return ResultUtil.success(list);
    }

}
