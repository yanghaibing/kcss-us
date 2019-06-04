package com.kcss.core.util.common;

import java.util.Random;

/**
 * RandomUtil class.
 *
 * @author X
 * @date: 2018/11/20
 * Todo:
 * @updateAuthor:
 * @updateDate:
 * @updateDesc: 1 .
 */
public class RandomUtil {

    /**
     * 随机 6 位数
     * @return
     */
    public static String randomSixNum(){
        Random random = new Random();
        int i = random.nextInt(900000)+ 100000;
        return String.valueOf(i);
    }

    public static void main(String[] args) {
        System.out.println(randomSixNum());
    }
}
