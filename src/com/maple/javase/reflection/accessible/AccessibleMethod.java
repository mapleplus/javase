package com.maple.javase.reflection.accessible;

import java.lang.reflect.Method;

/**
 * @author FENGXIN
 **/
public class AccessibleMethod {
    public static void main (String[] args) throws Exception {
        String personPath = "com.maple.javase.reflection.accessible.Person";
        Class<?> person = Class.forName (personPath);
        Object obj = person.getDeclaredConstructor ().newInstance ();
        Method method = person.getDeclaredMethod ("hi",String.class);
        
        // 暴破
        method.setAccessible (true);
        // m.invoke(o,实参列表);
        method.invoke (obj,"fengxin");
    }
}
