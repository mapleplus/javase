package com.fengxin.basic.generic;

/**
 * @author FENGXIN
 * @data 2024.4.29
 **/
public class Generic01 {
    public static void main (String[] args) {
//        创建泛型对象
//        在定义Person对象时指定类型，即在编译期间就决定E的类型
        Person<String> p1 = new Person<String>("fengxin");
        Person<Integer> p2 = new Person<Integer>(123);
        p1.showType ();
        p2.showType ();
    }
}
//创建泛型类
class Person<E>{
//    属性泛型
    //E表示s的数据类型，在定义Person对象时指定类型，即在编译期间就决定E的类型
    E s;
//    函数返回值类型泛型
    public E getS(){
        return s;
    }
//    参数类型
    Person(E s){
        this.s = s;
    }
//    查看运行时类型
    public void showType(){
        System.out.println (s.getClass ());
    }
}