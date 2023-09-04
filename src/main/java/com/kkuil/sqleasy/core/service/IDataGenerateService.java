package com.kkuil.sqleasy.core.service;

import com.kkuil.sqleasy.core.model.dto.DataGenerateConfigInfoDTO;
import com.kkuil.sqleasy.core.model.vo.GeneratedAllDataVO;
import com.kkuil.sqleasy.utils.ResultUtil;

/**
 * @Author Kkuil
 * @Date 2023/9/4 17:13
 * @Description 数据生成接口
 */
public interface IDataGenerateService {

    /**
     * 生成全部数据
     *
     * @param dataGenerateConfigInfoDTO 生成数据配置信息
     * @return ResultUtil<String>
     */
    ResultUtil<GeneratedAllDataVO> generate(DataGenerateConfigInfoDTO dataGenerateConfigInfoDTO);
}
