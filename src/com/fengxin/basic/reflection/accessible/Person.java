package com.fengxin.basic.reflection.accessible;

/**
 * @author FENGXIN
 **/
public class Person {
    private String name;
    private static int age;
    public Person(){}
    public Person(String name){
        this.name = name;
    }
    private Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    private void hi(String name){
        System.out.println ("你好" + name);
    }
    
    public static int getAge () {
        return age;
    }
    
    @Override
    public String toString () {
        return "Person{" +
                "name='" + name + '\'' +
                " age='" + getAge () + '\'' +
                '}';
    }
}
