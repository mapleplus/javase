package com.fengxin.basic.extend.Dynamic;

public class A {
    public int i = 10;

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
