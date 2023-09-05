package com.kkuil.sqleasy;

import cn.hutool.core.util.ArrayUtil;
import com.kkuil.sqleasy.core.enums.MockDataTypeEnum;
import com.kkuil.sqleasy.core.model.bo.FieldInfoBO;
import com.kkuil.sqleasy.core.model.dto.DataGenerateConfigInfoDTO;
import com.kkuil.sqleasy.core.model.vo.GeneratedAllDataVO;
import com.kkuil.sqleasy.core.service.IDataGenerateService;
import com.kkuil.sqleasy.utils.ResultUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

/**
 * @Author Kkuil
 * @Date 2023/9/4 23:35
 * @Description 核心功能测试
 */
@SpringBootTest
@Slf4j
public class CoreTest {

    @Resource
    private IDataGenerateService dataGenerateService;

    @Test
    void testCreateTableSqlWithMySql() {
        ArrayList<FieldInfoBO> fieldInfoBOS = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            FieldInfoBO field = FieldInfoBO.builder()
                    .name("test")
                    .type("test")
                    .defaultValue("test")
                    .comment("test")
                    .onUpdate(true)
                    .nonNull(true)
                    .unique(true)
                    .primary(true)
                    .autoIncrement(true)
                    .mockDataType(MockDataTypeEnum.NON.getId())
                    .build();
            fieldInfoBOS.add(field);
        }
        DataGenerateConfigInfoDTO dataGenerateConfigInfoDTO = DataGenerateConfigInfoDTO.builder()
                .dialect("mysql")
                .database("test")
                .table("test")
                .engine("test")
                .comment("test")
                .count(200)
                .fields(ArrayUtil.toArray(fieldInfoBOS, FieldInfoBO.class))
                .build();
        ResultUtil<GeneratedAllDataVO> generate = dataGenerateService.generate(dataGenerateConfigInfoDTO);
        log.info("generate: {}", generate);
    }

    @Test
    void testAutoIncrementStrategy() {
        ArrayList<FieldInfoBO> fieldInfoBOS = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            FieldInfoBO field = FieldInfoBO.builder()
                    .name("test")
                    .type("test")
                    .defaultValue("test")
                    .comment("test")
                    .onUpdate(true)
                    .nonNull(true)
                    .unique(true)
                    .primary(true)
                    .autoIncrement(true)
                    .mockDataType(MockDataTypeEnum.AUTO_INCREMENT.getId())
                    .extraInfo(0)
                    .build();
            fieldInfoBOS.add(field);
        }
        DataGenerateConfigInfoDTO dataGenerateConfigInfoDTO = DataGenerateConfigInfoDTO.builder()
                .dialect("mysql")
                .database("test")
                .table("test")
                .engine("test")
                .comment("test")
                .count(20)
                .fields(ArrayUtil.toArray(fieldInfoBOS, FieldInfoBO.class))
                .build();
        ResultUtil<GeneratedAllDataVO> generate = dataGenerateService.generate(dataGenerateConfigInfoDTO);
        log.info("generate: {}", generate);
    }

}
