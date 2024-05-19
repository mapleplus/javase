package com.fengxin.basic.reflection.basic_reflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author FENGXIN
 **/
@SuppressWarnings ("all")
public class ReflectionForCat {
    public static void main (String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // 创建一个Properties对象
        Properties properties = new Properties ();
        
        // 加载配置文件到Properties对象
        properties.load (new FileInputStream ("E:\\JAVA\\JAVA\\JAVASE\\src\\com\\fengxin\\basic\\reflection\\basic_reflection\\reflection.properties"));
        
        // 从Properties对象中获取类名(包名.类名)和方法名
        String className = properties.getProperty ("className");
        String methodName = properties.getProperty ("methodName");
        System.out.println ("className:" + className + " methodName:" + methodName);
        
        // 加载类,返回Class对象
        Class<?> cls = Class.forName (className);
        
        // 获取类的实例，通过cls得到加载类com.fengxin.basic.reflection.Cat的对象
        Object o = cls.newInstance ();
        System.out.println (o.getClass ());
        
        // 获取方法，通过cls得到加载类com.fengxin.basic.reflection.Cat的名为methodName的方法对象
        Method method = cls.getMethod (methodName);
        
        // 调用类com.fengxin.basic.reflection.Cat对象的方法，通过method得到加载类的方法对象，调用invoke方法
        // method.invoke(Object obj)
        method.invoke (o);
        
        // 调用类com.fengxin.basic.reflection.Cat的无参构造器
        Constructor<?> constructor1 = cls.getConstructor ();
        System.out.println (constructor1);
        
        // 调用类com.fengxin.basic.reflection.Cat的有参构造器,根据参数类型获取构造器
        Constructor<?> constructor2 = cls.getConstructor (String.class, int.class);
        System.out.println (constructor2);
        
        // 获取类com.fengxin.basic.reflection.Cat的字段（需要访问权限）
        Field fieldPublic = cls.getField ("age");
       
        // 获取具体值 field.get(Object obj)
        System.out.println (fieldPublic.get (o));
    }
}
