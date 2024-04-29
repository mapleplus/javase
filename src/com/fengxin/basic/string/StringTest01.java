package com.fengxin.basic.string;

/**
 * @author FENGXIN
 * @data 2024.4.29
 * String类的面试题测试
 **/
public class StringTest01 {
    public static void main (String[] args) {
        String a = "fx";//指向常量池
        String b = new String ("fx");//指向堆内存
        System.out.println (a.equals (b));//true 比较字符串内容
        System.out.println (a == b);//false 比较引用地址
        System.out.println (a == b.intern ());//true 比较引用地址
        System.out.println (b == b.intern ());//false 比较引用地址
    }
}
