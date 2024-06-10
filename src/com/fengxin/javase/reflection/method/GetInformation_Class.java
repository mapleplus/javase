package com.fengxin.javase.reflection.method;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author FENGXIN
 * 获取类中的信息
 * 包括字段，方法，构造器的相关信息
 **/
public class GetInformation_Class {
    public static void main (String[] args) throws ClassNotFoundException {
        String filePath = "com.fengxin.javase.reflection.basic_reflection.Cat";
        Class<?> cls = Class.forName (filePath);
        Field[] fields = cls.getDeclaredFields ();
        System.out.println ("---------------------------");
        System.out.println ("Fields:");
        for (Field field : fields) {
            // getModifiers:以int形式返回修饰符
            System.out.println (field.getModifiers ());
            // getType:以Class形式返回类型
            System.out.println (field.getType ());
            // getName:返回属性名
            System.out.println (field.getName ());
        }
        System.out.println ("---------------------------");
        System.out.println ("Methods:");
        Method[] methods = cls.getDeclaredMethods ();
        for (Method method : methods) {
            // getModifiers:以int形式返回修饰符
            System.out.println (method.getModifiers ());
            // getReturnType:以Class形式获取返回类型
            System.out.println (method.getReturnType ());
            // getName:返回方法名
            System.out.println (method.getName ());
            // getParameterTypes:以Class[]返回参数类型数组
            System.out.println (Arrays.toString (method.getParameterTypes ()));
        }
        System.out.println ("---------------------------");
        System.out.println ("Constructors:");
        Constructor<?>[] constructors = cls.getDeclaredConstructors ();
        for (Constructor<?> constructor : constructors) {
            // getModifiers:以int形式返回修饰符
            System.out.println (constructor.getModifiers ());
            // getName:返回构造器名
            System.out.println (constructor.getName ());
            // getParameterTypes:以Class[]返回参数类型数组
            System.out.println (Arrays.toString (constructor.getParameterTypes ()));
        }
    }
}
