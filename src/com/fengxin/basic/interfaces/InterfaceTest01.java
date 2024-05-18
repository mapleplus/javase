package com.fengxin.basic.interfaces;

/**
 * @author FENGXIN
 **/
public class InterfaceTest01 {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.a);// 使用对象访问实现的接口属性
        System.out.println(A.a);// 使用接口访问接口属性（static)
        System.out.println(B.a);// 使用实现接口的类访问实现的接口属性
    }
}

interface A {
    public static final int a = 10;
}

class B implements A {

}
