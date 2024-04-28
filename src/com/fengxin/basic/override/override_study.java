package com.fengxin.basic.override;

/**
 * @author xjn
 * 理解重写及super的注意事项
 */
public class override_study {
    public static void main(String[] args) {
        Person per = new Person("tom",18);
        System.out.println(per.message());
        Student stu = new Student("jack",18,1234,99.5);
        System.out.println(stu.message());
    }
}
