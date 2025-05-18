package com.maple.javase.reflection.base;

import com.maple.javase.reflection.common.Config;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author maple
 **/
public class ReflectionForCat {
    public static void main (String[] args) throws Exception {
        
        String className = Config.CAT.getKey();
        String methodName = Config.CRY.getKey();
        System.out.println ("className:" + className + " methodName:" + methodName);
        
        // 加载类,返回Class对象
        Class<?> cls = Class.forName (className);
        
        // 获取类的实例，通过cls得到加载类com.maple.javase.reflection.base.Cat的对象
        Object o = cls.getDeclaredConstructor ().newInstance ();
        System.out.println (o.getClass ());
        
        // 获取方法，通过cls得到加载类com.maple.javase.reflection.base.Cat的名为methodName的方法对象
        Method method = cls.getMethod (methodName);
        
        // 调用类com.maple.javase.reflection.base.Cat对象的方法，通过method得到加载类的方法对象，调用invoke方法
        // method.invoke(Object obj)
        method.invoke (o);
        
        // 调用类com.maple.javase.reflection.base.Cat的无参构造器
        Constructor<?> constructor1 = cls.getConstructor ();
        System.out.println (constructor1);
        
        // 调用类com.maple.javase.reflection.base.Cat的有参构造器,根据参数类型获取构造器
        Constructor<?> constructor2 = cls.getConstructor (String.class, int.class);
        System.out.println (constructor2);
        
        // 获取类com.maple.javase.reflection.base.Cat的字段（需要访问权限）
        Field fieldPublic = cls.getField ("age");
       
        // 获取具体值 field.get(Object obj)
        System.out.println (fieldPublic.get (o));
    }
}
