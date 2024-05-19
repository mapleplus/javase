package com.fengxin.basic.reflection.basic_reflection;

/**
 * @author FENGXIN
 **/
@SuppressWarnings ({"all"})
public class Cat {
    private String name;
    public int age = 5;
    public Cat () {}
    
    public Cat (String name,int age) {
        this.name = name;
        this.age = age;
    }
    
    public void hi(){
        System.out.println("喵喵喵");
    }
    public void cry(){
        System.out.println ("喵喵喵喵喵喵");
    }
}
