package com.fengxin.javase.reflection.accessible;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author FENGXIN
 **/
public class Accessible_Methods {
    public static void main (String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String personPath = "com.fengxin.basic.reflection.accessible.Person";
        Class<?> person = Class.forName (personPath);
        Object obj = person.getDeclaredConstructor ().newInstance ();
        Method method = person.getDeclaredMethod ("hi",String.class);
        
        // 暴破
        method.setAccessible (true);
        // m.invoke(o,实参列表);
        method.invoke (obj,"fengxin");
    }
}
