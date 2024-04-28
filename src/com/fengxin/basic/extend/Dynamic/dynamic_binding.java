package com.fengxin.basic.extend.Dynamic;

public class dynamic_binding {
    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.sum());
        System.out.println(a.sum1());
    }
}
