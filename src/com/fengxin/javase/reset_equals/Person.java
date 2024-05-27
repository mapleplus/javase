package com.fengxin.javase.reset_equals;

public class Person {
    private String name;
    private int age;
    private char gender;
    
    public Person (String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    
    public Person () {
    }
    
    public String getName () {
        return name;
    }
    
    public int getAge () {
        return age;
    }
    
    public char getGender () {
        return gender;
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    public void setAge (int age) {
        this.age = age;
    }
    
    public void setGender (char gender) {
        this.gender = gender;
    }
//    equals method
//    传入引用类型时，类型自动向上转型为Object
    @Override
    public boolean equals (Object obj) {
//        判断两个对象是否是同一个（地址是否相同）
        if(this == obj)
        {
            return true;
        }
//        类型判断
        if(obj instanceof Person) {
//            向下转型,为了得到obj的所有属性（包括特有的属性）
            Person person = (Person) obj;
//            属性判断
            return this.age == person.age && this.name.equals (person.name) && this.gender == person.gender;
        }
//        如果都不满足，则返回false
        return false;
    }
}
