package com.maple.javase.generic;

/**
 * @author maple
 **/

public class Generic01 {
    public static <C> void main (String[] args) {
        // 指定泛型具体类型后，可传入该类型或该类型的子类型的参数对象
        Cat<A> c1 = new Cat<>(new A());
        Cat<A> c2 = new Cat<>(new B());
    }

    static class A{}

    static class B extends A{}

    static class Cat <E> {
        E e;
        public Cat(E e){
            this.e = e;
        }
    }
}
