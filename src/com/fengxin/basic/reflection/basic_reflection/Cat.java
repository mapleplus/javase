package com.fengxin.basic.reflection.basic_reflection;

/**
 * @author FENGXIN
 **/

class Animal{
    private String name;
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
@SuppressWarnings ({"all"})
public class Cat extends Animal implements Fly, Run{
    private String name;
    protected String color;
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
    @Override
    public void fly() {
        System.out.println("猫会飞");
    }
    @Override
    public void run() {
        System.out.println("猫会跑");
    }
}
