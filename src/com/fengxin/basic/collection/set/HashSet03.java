package com.fengxin.basic.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author FENGXIN
 * @data 2024.5.5
 * HashSet 集合的应用
 * 员工的姓名和年龄相同才判定为同一个员工
 **/
public class HashSet03 {
    public static void main (String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add (new Employee ("张三" , 25));
        hashSet.add (new Employee ("李四" , 28));
        hashSet.add (new Employee ("张三" , 25));
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext ()){
            System.out.println (iterator.next ());
        }
    }
}
class Employee {
    private String name;
    private int age;
    
    @Override
    public boolean equals (Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass () != o.getClass ()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals (name , employee.name);
    }
    // 重写hashCode方法是为了让两个对象name和age相同就返回相同的hashCode值
    @Override
    public int hashCode () {
        return Objects.hash (name , age);
    }
    
    public String getName () {
        return name;
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    @Override
    public String toString () {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    
    public int getAge () {
        return age;
    }
    
    public void setAge (int age) {
        this.age = age;
    }
    
    public Employee (String name , int age) {
        this.name = name;
        this.age = age;
    }
}