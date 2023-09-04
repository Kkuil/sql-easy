package com.kkuil.sqleasy.core.service.impl;

import com.kkuil.sqleasy.core.dialect.factory.IDialectBuilderFactory;
import com.kkuil.sqleasy.core.dialect.factory.builders.IDialectBuilder;
import com.kkuil.sqleasy.core.model.dto.DataGenerateConfigInfoDTO;
import com.kkuil.sqleasy.core.model.vo.GeneratedAllDataVO;
import com.kkuil.sqleasy.core.service.IDataGenerateService;
import com.kkuil.sqleasy.utils.ResultUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author Kkuil
 * @Date 2023/9/4 17:12
 * @Description 数据生成服务类
 */
@Service
public class DataGenerateServiceImpl implements IDataGenerateService {

    @Resource
    private IDialectBuilderFactory dialectBuilderFactory;

    /**
     * 生成全部数据
     *
     * @param dataGenerateConfigInfoDTO 生成数据配置信息
     * @return ResultUtil<GeneratedAllDataVO>
     */
    @Override
    public ResultUtil<GeneratedAllDataVO> generate(DataGenerateConfigInfoDTO dataGenerateConfigInfoDTO) {
        // 获取方言
        String dialect = dataGenerateConfigInfoDTO.getDialect();

        // 生产相应的方言构造器
        IDialectBuilder<GeneratedAllDataVO> dialectBuilder = dialectBuilderFactory.produce(dialect);

        // 生成数据
        GeneratedAllDataVO generatedAllDataVO = dialectBuilder.build();

        // 返回数据
        return ResultUtil.success("获取成功", generatedAllDataVO);
    }
}
