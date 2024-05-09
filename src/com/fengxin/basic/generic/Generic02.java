package com.fengxin.basic.generic;

/**
 * @author FENGXIN
 * @data 2024.5.8
 **/

public class Generic02 {
    public static <C> void main (String[] args) {
        // 指定泛型具体类型后，可传入该类型或该类型的子类型的参数对象
        Cat<A> c1 = new Cat<A>(new A());
        Cat<A> c2 = new Cat<A>(new B());
    }
}
class A{}
class B extends A{}
class Cat <E> {
    E e;
    public Cat(E e){
        this.e = e;
    }
}