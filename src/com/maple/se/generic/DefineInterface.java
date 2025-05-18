package com.maple.se.generic;

/**
 * @author maple
 **/
public class DefineInterface {
    interface GenericInterface1<T> {
        public void print (T t);
    }
    // 继承接口
    interface GenericInterfaceExtends<T> extends GenericInterface1<String> {
        public void print2 (T t);
    }
    // 实现接口
    static class GenericClassImpl<T> implements GenericInterface1<String> {
        @Override
        public void print (String s) {
        }
    }
}
