package com.kkuil.sqleasy.core.dialect.builders.otherBuilders;

import com.alibaba.excel.EasyExcel;
import com.aliyuncs.exceptions.ClientException;
import com.kkuil.sqleasy.core.dialect.builders.IDataBuilder;
import com.kkuil.sqleasy.core.model.dto.DataGenerateConfigInfoDTO;
import com.kkuil.sqleasy.utils.OssUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author Kkuil
 * @Date 2023/9/8 10:20
 * @Description excel导出构造器
 */
@Slf4j
public class ExcelExportBuilder implements IDataBuilder {

    /**
     * 文件名分隔符
     */
    public static final String FILENAME_SPLIT_CHAR = "-";

    /**
     * 文件后缀
     */
    public static final String FILE_SUFFIX = ".xlsx";

    /**
     * 生成数据
     *
     * @param dataGenerateConfigInfoDTO 生成数据配置信息
     * @param data                      模拟数据
     * @return 数据
     */
    @Override
    public String build(DataGenerateConfigInfoDTO dataGenerateConfigInfoDTO, List<Map<String, Object>> data) {
        // 1. 获取动态表头
        List<List<String>> header = buildDynamicHeader(data);
        // 2. 获取数据
        List<List<String>> records = buildData(data);
        // 3. 获取存储路径
        String objectName = buildObjectName(dataGenerateConfigInfoDTO);
        // 4. 获取输出流对象
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        EasyExcel.write(outputStream)
                .head(header)
                .sheet()
                .doWrite(records);
        try {
            // 5. 上传阿里云oss
            String url = OssUtil.uploadFile(objectName, outputStream);
            return url;
        } catch (ClientException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取动态表头
     *
     * @param data 模拟数据
     * @return 表头信息
     */
    private List<List<String>> buildDynamicHeader(List<Map<String, Object>> data) {
        // 1. 取出第一个数据
        Map<String, Object> firstRecord = data.get(0);
        List<List<String>> columnInfo = new ArrayList<>();
        // 2. 循环获取key
        for (Map.Entry<String, Object> entry : firstRecord.entrySet()) {
            List<String> col = new ArrayList<>();
            col.add(entry.getKey());
            columnInfo.add(col);
        }
        return columnInfo;
    }

    /**
     * 获取数据
     *
     * @param data 模拟数据
     * @return 数据
     */
    private List<List<String>> buildData(List<Map<String, Object>> data) {
        List<List<String>> listData = new ArrayList<>();
        for (Map<String, Object> record : data) {
            List<String> temp = new ArrayList<>();
            for (Map.Entry<String, Object> entry : record.entrySet()) {
                temp.add(entry.getValue().toString());
            }
            listData.add(temp);
        }
        return listData;
    }


    /**
     * 获取存储路径
     *
     * @param dataGenerateConfigInfoDTO 配置信息
     * @return 存储路径
     */
    private String buildObjectName(DataGenerateConfigInfoDTO dataGenerateConfigInfoDTO) {
        // 文件名 = 表名 + '-' + 时间戳
        return dataGenerateConfigInfoDTO.getTable() + FILENAME_SPLIT_CHAR + System.currentTimeMillis() + FILE_SUFFIX;
    }
}
