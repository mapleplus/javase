package com.maple.javase.reflection.method;

import com.maple.javase.reflection.base.Cat;
import com.maple.javase.reflection.common.Config;

/**
 * @author maple
 * 获取Class的方法
 **/
public class GetClass {
    public static void main (String[] args) throws ClassNotFoundException {
        String classPath = Config.CAT.getKey();
        Class<?> cls1 = Class.forName (classPath);
        System.out.println (cls1);
        
        // 2.类名.class，常用于参数传递
        System.out.println (Cat.class);
        
        // 3.对象.getClass() 创建对象之后
        Cat cat = new Cat();
        System.out.println (cat.getClass ());
        
        // 4.基本类型的包装类.TYPE
        Class<Integer> integerType = Integer.TYPE;
        System.out.println (integerType);
        
        // 5.基本类型也有对应的Class对象
        Class<Integer> integerClass = int.class;
        System.out.println (integerClass);
        
        // 6.使用ClassLoader
        ClassLoader classLoader = cat.getClass ().getClassLoader ();
        Class<?> cls2 = classLoader.loadClass (classPath);
        System.out.println (cls2);
    }
}
