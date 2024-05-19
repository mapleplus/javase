package com.fengxin.basic.reflection.method;

import java.lang.reflect.Field;

/**
 * @author FENGXIN
 * Class类的常用方法
 **/
@SuppressWarnings ("all")
public class Class_Methods {
    public static void main (String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String catPath = new String ("com.fengxin.basic.reflection.basic_reflection.Cat");
        Class<?> cls = Class.forName (catPath);
        // 显示该Class对象所表示的实体类
        System.out.println ("该Class对象所表示的实体类: " + cls);
        // 获取cls运行类型---Class
        System.out.println ( "cls运行类型: " + cls.getClass ());
        // 获取Class对象所表示的实体类名
        System.out.println ("Class对象所表示的实体类名: " + cls.getName ());
        // 获取实体类包名
        System.out.println ("包名: " + cls.getPackage ().getName ());
        // 创建cls的实例，运行类型是实体类Cat
        Object obj = cls.newInstance ();
        // 获取属性名
        Field field = cls.getField ("age");
        System.out.println ("属性名: " + field);
        // 获取属性值
        System.out.println ("属性值 age = " + field.get (obj));
        // 获取所有属性(包括私有和保护)
        System.out.println ("所有属性(包括私有和保护)");
        Field[] fields1 = cls.getDeclaredFields ();
        for(Field f: fields1) {
            System.out.println (f);
        }
        // 获取所有属性(不包括私有和保护)
        System.out.println ("获取所有属性(不包括私有和保护)");
        Field[] fields2 = cls.getFields ();
        for(Field f: fields2) {
            System.out.println (f);
        }
        
    }
}
