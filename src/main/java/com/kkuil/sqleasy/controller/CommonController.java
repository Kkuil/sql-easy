package com.kkuil.sqleasy.controller;

import com.kkuil.sqleasy.core.enums.MockRandomDataEnum;
import com.kkuil.sqleasy.core.model.vo.MockRandomDataVO;
import com.kkuil.sqleasy.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Kkuil
 * @Date 2023/9/9 16:06
 * @Description 通用控制器
 */
@RestController
@Slf4j
public class CommonController {
    /**
     * 获取随机策略列表
     *
     * @param keyword 关键词
     * @return 随机策略列表
     */
    @GetMapping("/random-strategy/list")
    public ResultUtil<List<MockRandomDataVO>> listFieldInfo(String keyword) {
        List<MockRandomDataVO> list = MockRandomDataEnum.collect()
                .stream()
                .filter(field -> StringUtils.contains(field.getName(), keyword))
                .toList();
        return ResultUtil.success(list);
    }
}
