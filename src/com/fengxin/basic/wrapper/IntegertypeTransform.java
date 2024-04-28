package com.fengxin.basic.wrapper;
/**
 * @author FENGXIN
 * @data 2024.4.28
 * 包装类的装箱和拆箱
 **/

public class IntegertypeTransform {
    public static void main(String[] args) {
        //    jdk5以前，手动装、拆箱
        // 手动装箱
        Integer i1 = new Integer(10);
        Integer i2 = Integer.valueOf (20);
        // 手动拆箱
        int j1 = i1.intValue();
        int j2 = i2.intValue();
        System.out.println("手动装箱和拆箱：" +"j1 = " + j1 + ", j2 = " + j2);
        
        // jdk5以后，自动装、拆箱
        // 自动装箱
        Integer i3 = 30;
        // 自动拆箱
        int j3 = i3;
        System.out.println("自动装箱和拆箱：" +"j3 = " + j3);
        
    }
}
