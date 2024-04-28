package com.fengxin.basic.wrapper;/**
 * @author FENGXIN
 * @data 2024.4.28
 **/

/**
 * @author FENGXIN
 * &#064;data  2024.4.28
 * Integer和String类的相互转换，其他包装类类似
 **/
public class Integer_String {
    public static void main (String[] args) {
        //    Integer 转 String
        //    1. 使用 toString() 方法
        Integer integer1 = 10;
        String str1 = integer1.toString();
        //    2. 使用 String.valueOf() 方法
        Integer integer2 = 20;
        String str2 = String.valueOf (integer2);
        //     3.普通方式
        Integer integer3 = 30;
        String str3 = integer3 + "";
        //        String 转 Integer
        //        1. 使用 Integer.parseInt() 方法
        String str4 = "40";
        Integer integer4 = Integer.parseInt (str4);
        //        2. 使用 Integer.valueOf() 方法
        String str5 = "50";
        Integer integer5 = Integer.valueOf (str5);
        //        3. 使用 Integer的构造器
        String str6 = "60";
        Integer integer6 = new Integer (str6);
    }

    
}
