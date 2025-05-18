package com.maple.javase.generic;

/**
 * @author FENGXIN
 **/
public class DefineInterface {
    interface GenericInterface1<T> {
        public void print (T t);
    }
    // 继承接口
    interface GenericInterface2<T> extends GenericInterface1<String> {
        public void print2 (T t);
    }
    // 实现接口
    class GenericClass1<T> implements GenericInterface1<String> {
        @Override
        public void print (String s) {
        }
    }
}
