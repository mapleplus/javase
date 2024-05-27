package com.fengxin.javase.localinnerclass;

/**
 * @author FENGXIN
 **/
public class MemberInnerClass {
    public static void main(String[] args) {
        // 调用成员内部类的成员
        Outer05 member = new Outer05();
        member.memberFun01();

        // 外部类访问成员内部类
        // 第一种方式 固定语法
        System.out.println("------------------------------------");
        Outer05.memberInner01 inner01 = member.new memberInner01();
        inner01.show01();
        // 第二种方式，在外部类创建方法返回内部类对象，通过外部类对象调用非静态方法
        System.out.println("------------------------------------");
        Outer05.memberInner01 inner02 = member.returnMember();
        inner02.show02();
    }
}
class Outer05 {

    private final int m1 = 100;
    private final String name = "member";

    /**
     * memberInner01
     */
    public class memberInner01 {
        public void show() {
            System.out.println("成员内部类...");
            System.out.println("直接调用外部类成员（私有）：" + "m1 = " + m1 + " name: " + name);
        }

        public void show01() {
            System.out.println("外部其他类访问成员内部类第一种方式");

        }

        public void show02() {
            System.out.println("外部其他类访问成员内部类第二种方式");

        }
    }

    // 写一个方法供main函数调用
    public void memberFun01() {
        memberInner01 mInner01 = new memberInner01();
        mInner01.show();
    }

    // 返回内部类对象
    public memberInner01 returnMember() {
        return new memberInner01();
    }
}
