package com.fengxin.javase.extend;

/**
 * @author FENGXIN
 */
public class Dynamic_Binding {
    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.sum());
        System.out.println(a.sum1());
    }
}
class A {
    public int i = 5;

    public int sum() {
        return geti() + 10;
    }

    public int sum1() {
        return i + 10;
    }

    public int geti() {
        return i;
    }
}
class B extends A {
    public int i = 10;
    @Override
    public int sum(){
        return geti() + 20;
    }
    @Override
    public int sum1(){
        return i + 10;
    }
    @Override
    public int geti(){
        return i;
    }
}