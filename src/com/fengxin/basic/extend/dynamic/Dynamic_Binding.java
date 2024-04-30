package com.fengxin.basic.extend.dynamic;

public class Dynamic_Binding {
    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.sum());
        System.out.println(a.sum1());
    }
}
