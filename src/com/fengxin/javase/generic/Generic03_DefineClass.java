package com.fengxin.javase.generic;

/**
 * @author FENGXIN
 **/
public class Generic03_DefineClass {
    public static void main (String[] args) {
        Person01<String, Integer> person = new Person01<>("Alice", 25);
        System.out.println(person);
    }
}
class Person01 <T,E> {
    T name;
    E age;
    //使用泛型的数组不能被初始化
    E[] arr;
    // 静态成员中不能使用类的泛型
    // static T staticField;
    // static void staticMethod(T t,E,e) {
    //     // staticMethod can't use T or E
    // }
    public Person01(T name, E age) {
        this.name = name;
        this.age = age;
    }
    
    public T getName() {
        return name;
    }
    
    public void setName(T name) {
        this.name = name;
    }
    
    public E getAge() {
        return age;
    }
    public void setAge(E age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Person01 [name=" + name + ", age=" + age + "]";
    }
}