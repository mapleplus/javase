package com.maple.javase.reflection.base;

import com.maple.javase.reflection.common.Config;

import java.lang.reflect.Method;

/**
 * @author FENGXIN
 **/
public class ReflectionOptimize {
    public static void main (String[] args) throws Exception {
        String className = Config.CAT.getKey();
        String methodName = Config.CRY.getKey();
        
        // 反射调用方法
        Class<?> cls = Class.forName (className);
        Object obj = cls.getDeclaredConstructor ().newInstance ();
        Method method = cls.getMethod (methodName);
        // 优化反射调用, 关闭权限检查
        method.setAccessible (true);
        long startTime = System.currentTimeMillis ();
        for (int i = 0; i < 999999999; i++) {
            method.invoke (obj);
        }
        long endTime = System.currentTimeMillis ();
        System.out.println ("反射调用方法耗时：" + (endTime - startTime) + "ms");
    }
}
