package com.fengxin.javase.reflection.method;

import java.io.Serializable;

/**
 * @author FENGXIN
 * 获取基本类型的Class
 **/
public class Get_BasicDataClass {
    public static void main (String[] args) {
        // 外部类，成员内部类，静态内部类，局部内部类，匿名内部类
        Class<String> stringClass = String.class;
        System.out.println ("String class is +" + stringClass);
        
        // interface:接口
        Class<Serializable> serializableClass = Serializable.class;
        System.out.println ("Serializable class is +" + serializableClass);
        
        // 数组
        Class<String[]> stringArrayClass = String[].class;
        System.out.println ("String[] class is +" + stringArrayClass);
        
        // enum:枚举
        Class<Thread> threadClass = Thread.class;
        System.out.println ("Thread class is +" + threadClass);
        
        // annotation:注解
        Class<SuppressWarnings> suppressWarningsClass = SuppressWarnings.class;
        System.out.println ("SuppressWarnings class is +" + suppressWarningsClass);
        
        // 基本数据类型
        Class<Integer> integerClass = Integer.class;
        System.out.println ("Integer class is +" + integerClass);
        
        // void
        Class<Void> voidClass = void.class;
        System.out.println ("Void class is +" + voidClass);
    }
}
