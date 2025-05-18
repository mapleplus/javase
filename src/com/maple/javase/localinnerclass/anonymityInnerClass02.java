package com.maple.javase.localinnerclass;

/**
 * @author maple
 **/
public class anonymityInnerClass02 {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.fun02();
    }
}
class A2 {

    A2(String name) {
        System.out.println("接收了name = " + name);
    }

    public void show() {
        System.out.println("这是A类...");
    }

}

/**
 * java 底层创建：
 * class Outer02$1 extends A{
 *
 * @Override
 *           public void show() {
 *           System.out.println("重写了匿名内部类方法...");
 *           System.out.println("动态绑定运行类型...");
 *           System.out.println("就近原则（");
 *           }
 *           结束后返回Outer02$1的实例给引用a，Outer02$1死亡，但a可以继续多次使用
 */
class Outer02 {
    private final int a02 = 20;

    public void fun02() {
        // 传入String类型参数给构造器
        A2 a = new A2("feng") {
            private int a02 = 30;

            @Override
            public void show() {
                System.out.println("重写了匿名内部类方法...");
                System.out.println("动态绑定运行类型是：" + getClass());
                System.out.println("就近原则(匿名内部类a02 = 30) 验证：a02 = " + a02);
                System.out.println("使用外部类成员(外部类a02 = 20 验证：a02 = " + Outer02.this.a02);
            }
        };
        a.show();// 动态绑定，运行类型是Outer02$1
    }

}