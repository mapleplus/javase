package com.fengxin.javase.string;

/**
 * @author FENGXIN
 * String类的面试题测试
 **/
public class StringTest01 {
    public static void main (String[] args) {
        //指向常量池
        String a = "fx";
        //指向堆内存
        String b = new String ("fx");
        //true 比较字符串内容
        System.out.println (a.equals (b));
        //false 比较引用地址
        System.out.println (a == b);
        //true 比较引用地址
        System.out.println (a == b.intern ());
        //false 比较引用地址
        System.out.println (b == b.intern ());
    }
}
