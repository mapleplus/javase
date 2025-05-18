package com.maple.javase.reflection.base;

/**
 * @author FENGXIN
 **/

class Animal{
    String name;
    public Animal () {}
    public void hi(){
        System.out.println("动物叫");
    }
}

interface Fly{
    void fly();
}

interface Run{
    void run();
}

/**
 * @author maple
 */
public class Cat extends Animal implements Fly, Run{
    protected String color;
    public Integer age = 5;
    public Cat () {}
    public Cat (String name,int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public void hi(){
        System.out.println("喵喵喵");
    }
    public void cry(){
        System.out.println ("喵喵喵喵喵喵");
    }
    @Override
    public void fly() {
        System.out.println("猫会飞");
    }
    @Override
    public void run() {
        System.out.println("猫会跑");
    }
}
