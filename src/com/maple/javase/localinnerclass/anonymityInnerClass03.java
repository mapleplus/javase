package com.maple.javase.localinnerclass;

/**
 * @author FENGXIN
 **/
public class anonymityInnerClass03 {
    public static void main(String[] args) {
        Outer03 outer03 = new Outer03();
        outer03.fun03();
    }
}

/**
 * 匿名内部类
 */
abstract class Abstract {
    abstract void show();
}

/**
 * java 底层创建：
 * class Outer03$1 extends A{
 *
 * @Override
 *           public void show() {
 *           System.out.println("重写了抽象类Abstract_A的方法...");
 *           }
 *           结束后返回Outer03$1的实例给abstract_A引用，Outer03$1死亡，但abstract_A可以继续多次使用
 */
class Outer03 {
    public void fun03() {
        Abstract abstract1 = new Abstract() {
            // 重写抽象类的抽象方法
            @Override
            public void show() {
                System.out.println("重写了抽象类Abstract_A的方法...");
            }
        };
        abstract1.show();
    }

}