package com.fengxin.basic.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FENGXIN
 * @data 2024.5.8
 **/
public class Generic06 {
    public static void main (String[] args) {
        List<Object> list01 = new ArrayList<> ();
        List<String> list02 = new ArrayList<> ();
        List<AA> list03 = new ArrayList<> ();
        List<BB> list04 = new ArrayList<> ();
        List<CC> list05 = new ArrayList<> ();
        System.out.println ("<?> :支持任意类型的泛型");
        method001 (list01);
        method001 (list02);
        method001 (list03);
        method001 (list04);
        method001 (list05);
        System.out.println ("＜? extends A> :支持A类及A类的子类");
        // method002 (list01);
        // method002 (list02);
        method002 (list03);
        method002 (list04);
        method002 (list05);
        System.out.println ("＜? super A> :支持A类及A类的父类，不限于直接父类");
        method03 (list01);
        // method03 (list02);//和AA没有继承关系
        method03 (list03);
        // method03 (list04);//AA子类
        // method03 (list05);//AA子类
    }
    public static void method001(List<?> list1){
        // ＜?> :支持所有类型
        for (Object o : list1){
            System.out.println (list1);
        }
    }
    public static void method002(List<? extends AA> list2){
        // ＜? extends A> :支持A类及A类的子类
        for (Object o : list2) {
            System.out.println (list2);
        }
    }
    public static void method03(List<? super AA> list3){
        // ＜? super A> :支持A类及A类的父类，不限于直接父类
        for (Object o : list3) {
            System.out.println (list3);
        }
    }
}
class AA{
    @Override
    public String toString() {
        return "AA extends Object";
    }
}
class BB extends AA{
    @Override
    public String toString() {
        return "BB extends AA";
    }
}
class CC extends AA{
    @Override
    public String toString() {
        return "CC extends AA";
    }
}