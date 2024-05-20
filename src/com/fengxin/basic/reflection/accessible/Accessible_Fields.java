package com.fengxin.basic.reflection.accessible;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author FENGXIN
 **/
public class Accessible_Fields {
    public static void main (String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String personPath = "com.fengxin.basic.reflection.accessible.Person";
        Class<?> person = Class.forName (personPath);
        Object obj = person.getDeclaredConstructor ().newInstance ();
        Field name = person.getDeclaredField ("name");
        
        // 暴破，操作私有Field
        name.setAccessible (true);
        name.set (obj,"fengxin");
        System.out.println (name.get (obj));
        
        // 静态Field
        Field age = person.getDeclaredField ("age");
        age.setAccessible (true);
        // Object可以设为null
        age.set (null,18);
        System.out.println (age.get (null));
        
    }
}
