package com.fengxin.basic.wrapper;
/**
 * @author FENGXIN
 **/

// 编写一个Java程序，演示如何使用Integer类的方法。包括获取最大值和最小值、判断是否为数字或字母、判断是否为大写或小写、转换为大写或小写等。
public class Integer_Methods {
    public static void main (String[] args) {
        // 获取最大值
        System.out.println ("Integer的最大值："+Integer.MAX_VALUE);
        // 获取最小值
        System.out.println ("Integer的最小值："+Integer.MIN_VALUE);
        // 判断是否为数字
        System.out.println (Character.isDigit (5));
        // 判断是否为字母
        System.out.println (Character.isLetter ('a'));
        // 判断是否为大写字母
        System.out.println (Character.isUpperCase ('A'));
        // 判断是否为小写字母
        System.out.println (Character.isLowerCase ('a'));
        // 转换为大写
        System.out.println (Character.toUpperCase ('a'));
        // 转换为小写
        System.out.println (Character.toLowerCase ('A'));
        
    }
}
