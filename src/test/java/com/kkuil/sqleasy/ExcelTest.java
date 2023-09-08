package com.kkuil.sqleasy;

import com.alibaba.excel.EasyExcel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Kkuil
 * @Date 2023/9/8 10:36
 * @Description Excel测试
 */
public class ExcelTest {
    /**
     * 动态头，实时生成头写入
     * <p>
     * 思路是这样子的，先创建List<String>头格式的sheet仅仅写入头,然后通过table 不写入头的方式 去写入数据
     *
     * <p>
     * <p>
     * 2. 然后写入table即可
     */
    @Test
    public void dynamicHeadWrite() {
        String fileName = "dynamicHeadWrite" + System.currentTimeMillis() + ".xlsx";
        List<List<String>> values = new ArrayList<>();
        List<String> v1 = new ArrayList<>();
        v1.add("123");
        v1.add("123");
        v1.add("123");
        List<String> v2 = new ArrayList<>();
        v2.add("123");
        v2.add("123");
        v2.add("123");
        List<String> v3 = new ArrayList<>();
        v3.add("123");
        v3.add("123");
        v3.add("123");
        values.add(v1);
        values.add(v2);
        values.add(v3);
        EasyExcel.write(fileName)
                // 这里放入动态头
                .head(head())
                .sheet("模板")
                // 当然这里数据也可以用 List<List<String>> 去传入
                .doWrite(values);
    }

    private List<List<String>> head() {
        List<List<String>> list = new ArrayList<List<String>>();
        List<String> head0 = new ArrayList<String>();
        head0.add("字符串");
        List<String> head1 = new ArrayList<String>();
        head1.add("数字");
        List<String> head2 = new ArrayList<String>();
        head2.add("日期");
        list.add(head0);
        list.add(head1);
        list.add(head2);
        return list;
    }
}
