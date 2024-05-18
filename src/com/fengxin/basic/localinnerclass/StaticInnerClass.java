package com.fengxin.basic.localinnerclass;

/**
 * @author FENGXIN
 **/
public class StaticInnerClass {
    public static void main(String[] args) {
        Outer06 outer06 = new Outer06();
        outer06.fun04();
        // 外部其他类访问静态内部类的三种方式
        // 方式一----固定语法
        System.out.println("------------------------------------");
        Outer06.staticClass inClass1 = new Outer06.staticClass();
        inClass1.show03();
        // 方式二----在外部类创建方法返回内部类对象，通过外部类对象调用非静态方法
        System.out.println("------------------------------------");
        Outer06.staticClass inClass2 = outer06.fun05();
        inClass2.show04();
        System.out.println("------------------------------------");
        // 方式三----通过外部类直接调用静态方法返回静态类对象
        Outer06.staticClass inClass3 = Outer06.fun06();
        inClass3.show05();
    }
}
class Outer06 {
    private static final int n = 1000;

    /**
     * staticClass
     */
    static class staticClass {
        private int n = 10;

        public void show() {
            System.out.println("静态内部类访问外部类静态成员n = " + Outer06.n);
            System.out.println("静态内部类访问本类静态成员n = " + n);
        }

        public void show03() {
            System.out.println("外部类第一种访问内部类方式...");
        }

        public void show04() {
            System.out.println("外部类第二种访问内部类方式...");
        }

        public void show05() {
            System.out.println("外部类第三种访问内部类方式...");
        }
    }

    public void fun04() {
        staticClass staticclass = new staticClass();
        staticclass.show();
    }

    // 编写方法返回静态内部类对象
    public staticClass fun05() {
        return new staticClass();
    }

    // 静态方法返回静态内部类对象
    public static staticClass fun06() {
        return new staticClass();

    }
}