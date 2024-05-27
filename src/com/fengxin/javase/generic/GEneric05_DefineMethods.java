package com.fengxin.javase.generic;

/**
 * @author FENGXIN
 **/
public class GEneric05_DefineMethods {
    public static void main (String[] args) {
        GenericMethods01<String,Integer> method_01 = new GenericMethods01<>();
        method_01.method1 ("hello",123.1);
        method_01.method2 ("world",123);
    }
}
class GenericMethods01<T,E>{
    T filed1;
    E filed2;
    // 定义一个泛型方法
    public <R,S> void method1(R r,S s){
        System.out.println ("This is a generic method with two parameters of different types:");
        System.out.println ("R: " + r + " S: " + s);
    }
    //泛型方法可以使用类声明的泛型，也可以使用方法声明的泛型
    public <O> void method2(T t,O o){//O是方法声明的泛型，T是类声明的泛型
        System.out.println ("This is a generic method with two parameters of different types:");
        System.out.println ("T: " + t + " O: " + o);
    }
}