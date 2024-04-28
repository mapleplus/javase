package com.fengxin.basic.wrapper;/**
 * @author FENGXIN
 * @data 2024.4.28
 **/

/**
 * @author FENGXIN
 * &#064;data  2024.4.28
 * 包装类的常用方法
 **/
public class Integermethods {
    public static void main (String[] args) {
        System.out.println ("Integer的最大值："+Integer.MAX_VALUE);// 获取最大值
        System.out.println ("Integer的最小值："+Integer.MIN_VALUE);// 获取最小值
        System.out.println (Character.isDigit (5));// 判断是否为数字
        System.out.println (Character.isLetter ('a'));// 判断是否为字母
        System.out.println (Character.isUpperCase ('A'));// 判断是否为大写字母
        System.out.println (Character.isLowerCase ('a'));// 判断是否为小写字母
        System.out.println (Character.toUpperCase ('a'));// 转换为大写
        System.out.println (Character.toLowerCase ('A'));// 转换为小写
        
    }
}
