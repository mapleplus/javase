package com.maple.javase.reflection.method;

import com.maple.javase.reflection.common.Config;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author FENGXIN
 * Class类的常用方法
 **/
@SuppressWarnings ("all")
public class ClassMethod {
    public static void main (String[] args) throws Exception {
        String catPath = Config.CAT.getKey();
        
        // 获取Class对象(加载类)
        Class<?> cls = Class.forName (catPath);
        
        // 显示该Class对象所表示的实体类
        System.out.println ("该Class对象所表示的实体类: " + cls);
        
        // 获取cls运行类型---Class
        System.out.println ( "cls运行类型: " + cls.getClass ());
        
        // 获取Class对象所表示的实体全类名
        System.out.println ("Class对象所表示的实体全类名: " + cls.getName ());
        
        // 获取简单类名
        System.out.println ("cls简单类名: " + cls.getSimpleName ());
        
        // 获取实体类包名
        System.out.println ("cls包名: " + cls.getPackage ().getName ());
        
        // 创建cls的实例，运行类型是实体类Cat
        Object obj = cls.getDeclaredConstructor ().newInstance ();
        
        // 获取属性名
        Field field = cls.getField ("age");
        System.out.println ("属性名: " + field);
        
        // 获取属性值
        System.out.println ("属性值 age = " + field.get (obj));
        
        // 获取本类所有属性(包括私有和保护)，包含本类以及父类的
        System.out.println ("所有属性(包括私有和保护)，包含本类以及父类的");
        Field[] fields1 = cls.getDeclaredFields ();
        for(Field f: fields1) {
            System.out.println (f);
        }
        
        // 获取本类所有public修饰的属性
        System.out.println ("获取本类所有public修饰的属性");
        Field[] fields2 = cls.getFields ();
        for(Field f: fields2) {
            System.out.println (f);
        }
        
        // 获取所有public修饰的方法，包含本类以及父类的
        System.out.println ("获取所有public修饰的方法，包含本类以及父类的");
        Method[] methods = cls.getMethods ();
        for (Method method : methods) {
            System.out.println (method);
        }
        
        // 获取本类中所有方法
        System.out.println ("获取本类中所有方法");
        Method[] clsDeclaredMethods = cls.getDeclaredMethods ();
        for (Method method : clsDeclaredMethods) {
            System.out.println (method);
        }
        
        // 获取本类所有public修饰的构造器
        System.out.println ("获取本类所有public修饰的构造器");
        Constructor<?>[] constructors = cls.getConstructors ();
        for (Constructor<?> constructor : constructors) {
            System.out.println (constructor);
        }
        
        // 获取所有构造器，包含本类以及父类的
        System.out.println ("获取所有构造器，包含本类以及父类的");
        Constructor<?>[] clsDeclaredConstructors = cls.getDeclaredConstructors ();
        for (Constructor<?> clsDeclaredConstructor : clsDeclaredConstructors) {
            System.out.println (clsDeclaredConstructor);
        }
        
        // 以Class形式返回父类信息
        Class<?> superclass = cls.getSuperclass ();
        System.out.println ("父类信息: " + superclass);
        
        // 以Class[]形式返回接口信息
        System.out.println ("以Class[]形式返回接口信息");
        Class<?>[] interfaces = cls.getInterfaces ();
        for (Class<?> anInterface : interfaces) {
            System.out.println ("接口信息: " + anInterface);
        }
        
        // 以Annotation[]形式返回注解信息
        System.out.println ("以Annotation[]形式返回注解信息");
        Annotation[] annotations = cls.getAnnotations ();
        for (Annotation annotation : annotations) {
            System.out.println ("注解信息: " + annotation);
        }
        
    }
}
