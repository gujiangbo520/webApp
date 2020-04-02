package com.gujiangbo.application.utils;

import java.util.Random;
import java.util.UUID;

public class IDTools {

    public static String getRandom32() {

        return UUID.randomUUID().toString().replaceAll("-", "").trim();
    }

    public static String getRandom15() {
        return getRandomString(15);
    }

    /**
     * 生成指定位数的随机数
     *
     * @param length
     * @return
     */
    private static String getRandomString(int length) { // length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString().toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(getRandom32());
    }
}
