package com.kkuil.sqleasy.core.controller;

import com.kkuil.sqleasy.anotations.AuthLogin;
import com.kkuil.sqleasy.core.model.dto.DataGenerateConfigInfoDTO;
import com.kkuil.sqleasy.core.model.vo.GeneratedAllDataVO;
import com.kkuil.sqleasy.core.service.IDataGenerateService;
import com.kkuil.sqleasy.utils.ResultUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Kkuil
 * @Date 2023/9/4 16:31
 * @Description 数据生成器控制类
 */
@RestController
@Slf4j
@AuthLogin
public class DataGenerateController {

    @Resource
    private IDataGenerateService dataGenerateService;

    /**
     * 生成全部数据的接口
     *
     * @param dataGenerateConfigInfoDTO 生成数据配置信息
     * @return 全部数据
     */
    @PostMapping("/generate")
    @Operation(summary = "数据生成", description = "生成各种相关数据")
    @Parameter(name = "dataGenerateConfigInfoDTO")
    public ResultUtil<GeneratedAllDataVO> generateAllData(@RequestBody DataGenerateConfigInfoDTO dataGenerateConfigInfoDTO) {
        return dataGenerateService.generate(dataGenerateConfigInfoDTO);
    }
}
