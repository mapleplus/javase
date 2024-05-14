package com.fengxin.basic.collection.set;

import java.util.HashSet;

/**
 * @author FENGXIN
 * @data 2024.5.5
 **/
public class HashSet01 {
    public static void main (String[] args) {
        // 1. HashSet不保证元素有序，取决于hash后再确定索引结果
        // 2. 不能有重复的元素或对象
        HashSet set = new HashSet();
        set.add ("feng");
        // 不会重复添加feng
        set.add ("feng");
        set.add(new Cat("feng", 1));
        // 两个对象不同，可以添加，如果想要不重复，需要重写equals和hashCode方法
        set.add(new Cat("feng", 1));
        set.add (new String ("xin"));
        // String类的xin在常量池只有一份，不会重复添加xin
        set.add (new String ("xin"));
        System.out.println (set);
    }
}
class Cat{
    private String name;
    private int age;
    
    @Override
    public String toString () {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    
    public String getName () {
        return name;
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    public int getAge () {
        return age;
    }
    
    public void setAge (int age) {
        this.age = age;
    }
    
    public Cat (String name , int age) {
        this.name = name;
        this.age = age;
    }
}
