package com.fengxin.basic.reset_equals;
//重写equals方法，比较两个对象是否相等
public class Test_Equals {
    public static void main (String[] args) {
        Person person1 = new Person ("feng",18,'男');
        Person person2 = new Person ("feng",18,'男');
        System.out.println(person1.equals(person2));
    }
}
