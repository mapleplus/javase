package com.maple.javase.localinnerclass;

/**
 * @author FENGXIN
 **/
public class LocalInnerClass {
    public static void main(String[] args) {
        Outer04 outer = new Outer04();
        outer.fun1();
    }
}
class Outer04{
    private int n = 100;

    private void fun2() {
        System.out.println("内部类成功直接调用外部类私有成员");
    }

    public void fun1() {// 内部类作用域：仅在定义它的方法或者代码块中

        // 局部内部类定义在外部类的局部位置（方法/代码块）
        // 局部内部类不能添加访问修饰符，但可以用`final`修饰（看作变量就好理解）
        final class Inner {// 局部内部类
            // 外部类成员 与 内部类成员 重名，默认遵循就近原则，
            // 访问外部类成员用`外部类名.this.成员`
            private int n = 200;

            public void f1() {
                // 可以直接访问外部类的所有成员，包括私有的
                System.out.println("内部类方法f1执行...");
                System.out.println("Inner's n = " + n + " 就近原则（Outer's n = 100,Inner's = 200)");
                System.out.println("Outer's n = " + Outer04.this.n + " Outer.this.n访问外部类重名成员");
                fun2();
            }
        }
        // 外部类——访问——局部内部类成员（创建对象再访问，必须在作用域内）
        Inner inner = new Inner();
        inner.f1();

    }// 内部类作用域：仅在定义它的方法或者代码块中
}