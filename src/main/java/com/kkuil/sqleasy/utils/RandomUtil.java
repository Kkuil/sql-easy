package com.kkuil.sqleasy.utils;

/**
 * @Author Kkuil
 * @Date 2023/9/9 19:29
 * @Description 随机类
 */
public class RandomUtil {

    /**
     * 生成随机城市
     *
     * @return 随机城市
     */
    public static String randomCity() {
        String[] cities = {
                "北京",
                "上海",
                "深圳",
                "广州",
                "重庆",
                "江西",
                "湖南",
                "湖北",
                "天津",
                "杭州",
                "西藏",
                "西双版纳",
                "香港",
                "台湾"
        };
        int index = cn.hutool.core.util.RandomUtil.randomInt(cities.length);
        return cities[index];
    }

    /**
     * 生成随机邮箱
     *
     * @return 随机邮箱
     */
    public static String randomEmail() {
        String[] emailSuffix = {
                "@gmail.com",
                "@yahoo.com",
                "@msn.com",
                "@hotmail.com",
                "@aol.com",
                "@ask.com",
                "@live.com",
                "@qq.com",
                "@0355.net",
                "@163.com",
                "@163.net",
                "@263.net",
                "@3721.net",
                "@yeah.net",
                "@googlemail.com",
                "@mail.com",
                "@hotmail.com",
                "@msn.com",
                "@yahoo.com",
                "@gmail.com",
                "@aim.com",
                "@aol.com",
                "@mail.com",
                "@walla.com",
                "@inbox.com",
                "@126.com",
                "@163.com",
                "@sina.com",
                "@sohu.com",
                "@tom.com",
                "@qq.com",
                "@etang.com",
                "@eyou.com",
                "@56.com",
                "@x.cn",
                "@chinaren.com",
                "@sogou.com",
                "@citiz.com"
        };

        // 随机号码
        long number = cn.hutool.core.util.RandomUtil.randomLong(3170, 999999999);
        // 随机索引
        int index = cn.hutool.core.util.RandomUtil.randomInt(0, emailSuffix.length);
        return number + emailSuffix[index];
    }

    /**
     * 生成随机IP
     *
     * @return 随机IP
     */
    public static String randomIp() {
        int first = cn.hutool.core.util.RandomUtil.randomInt(0, 255);
        int second = cn.hutool.core.util.RandomUtil.randomInt(0, 255);
        int third = cn.hutool.core.util.RandomUtil.randomInt(0, 255);
        int forth = cn.hutool.core.util.RandomUtil.randomInt(0, 255);
        StringBuilder ip = new StringBuilder();
        ip
                .append(first)
                .append(".")
                .append(second)
                .append(".")
                .append(third)
                .append(".")
                .append(forth);
        return ip.toString();
    }

    /**
     * 生成随机人名
     *
     * @return 随机人名
     */
    public static String randomName() {
        String[] names = {
                "张三",
                "李四",
                "王五",
                "老刘",
                "王琦",
                "张坝",
                "温暖",
                "邓紫棋",
                "章若楠",
                "周杰伦"
        };
        int index = cn.hutool.core.util.RandomUtil.randomInt(0, names.length);
        return names[index];
    }
}
