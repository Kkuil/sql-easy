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

    /**
     * 生成随机网址
     *
     * @return 随机网址
     */
    public static String randomWebsite() {
        // 协议
        String[] protocols = {
                "http",
                "https",
        };
        // 顶级域名
        String[] firstDomain = {
                "com",
                "cn",
                "site",
                "love",
                "edu",
                "gov",
                "org",
                "vip",
                "abc",
        };
        // 随机协议索引
        int proIndex = cn.hutool.core.util.RandomUtil.randomInt(0, protocols.length);
        // 随机顶级域名索引
        int domainIndex = cn.hutool.core.util.RandomUtil.randomInt(0, firstDomain.length);
        // 随机二级域名个数
        int count = cn.hutool.core.util.RandomUtil.randomInt(0, 8);
        StringBuilder secondDomain = new StringBuilder();
        for (int i = 0; i < count; i++) {
            char c = cn.hutool.core.util.RandomUtil.randomChar("qwertyuiopasddfghjklzxcvbnm");
            secondDomain.append(c);
        }
        return protocols[proIndex] + "://" + "www." + secondDomain.toString() + "." + firstDomain[domainIndex];
    }

    /**
     * 生成随机电话号码
     *
     * @return 随机电话号码
     */
    public static String randomPhone() {
        // 1. 第一位
        StringBuilder phone = new StringBuilder("1");
        // 2. 第二位
        int second = cn.hutool.core.util.RandomUtil.randomInt(3, 9);
        phone.append(second);
        // 3. 第三 - 十一位
        for (int i = 0; i < 9; i++) {
            int remain = cn.hutool.core.util.RandomUtil.randomInt(0, 9);
            phone.append(remain);
        }
        return phone.toString();
    }

    /**
     * 生成随机大学名
     *
     * @return 随机大学名
     */
    public static String randomUniversity() {
        String[] universities = {
                "国防科技大学",
                "北京大学",
                "清华大学",
                "浙江大学",
                "北京邮电大学",
                "南京邮电大学",
                "北京师范大学",
                "杭州师范大学",
                "南昌大学",
                "重庆大学",
                "深圳大学",
                "纽约大学",
                "北京戏剧学院",
                "牛津大学",
        };
        int index = cn.hutool.core.util.RandomUtil.randomInt(0, universities.length);
        return universities[index];
    }
}
