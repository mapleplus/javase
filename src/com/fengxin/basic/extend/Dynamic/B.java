package com.fengxin.basic.extend.Dynamic;

public class B extends A {
    public int i = 10;
    public int sum(){
        return geti() + 20;
    }
    public int sum1(){
        return i + 10;
    }
    public int geti(){
        return i;
    }
}
