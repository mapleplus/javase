package com.fengxin.basic.reflection.accessible;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author FENGXIN
 **/
public class Accessible_Constructor {
    public static void main (String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String personPath = "com.fengxin.basic.reflection.accessible.Person";
        Class<?> person = Class.forName (personPath);
        
        // 默认构造函数
        Object obj1 = person.getDeclaredConstructor ().newInstance ();
        System.out.println (obj1);
        
        // 公有带参数构造函数
        Constructor<?> constructor1 = person.getConstructor (String.class);
        Object obj2 = constructor1.newInstance ("fengxin");
        System.out.println (obj2);
        
        // 私有带参构造函数
        Constructor<?> constructor2 = person.getDeclaredConstructor (String.class,int.class);
        // 暴破
        constructor2.setAccessible (true);
        Object obj3 = constructor2.newInstance ("fengxin",18);
        System.out.println (obj3);
    }
}
