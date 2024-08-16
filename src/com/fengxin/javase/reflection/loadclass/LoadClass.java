package com.fengxin.javase.reflection.loadclass;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @author FENGXIN
 * 类加载的分类
 **/
public class LoadClass {
    public static void main (String[] args) throws Exception {
        int flag;
        Scanner sc = new Scanner(System.in);
        System.out.println ("请输入1或2");
        flag = sc.nextInt ();
        switch (flag){
            case 1:
                // 静态加载
                // 编译时就会报异常
                // Dog dog = new Dog;
                // dog.cry();
                break;
            case 2:
                // 动态加载
                // 运行时才会报异常
                Class<?> cls = Class.forName ("com.fengxin.javase.reflection.loadclass.Person");
                Object obj = cls.getDeclaredConstructor ().newInstance ();
                Method method = cls.getMethod ("hi");
                method.invoke (obj);
                break;
        }
    }
}
