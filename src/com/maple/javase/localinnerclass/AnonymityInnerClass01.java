package com.maple.javase.localinnerclass;

/**
 * @author maple
 **/
public class AnonymityInnerClass01 {
    public static void main(String[] args) {
        Outer01 outer01 = new Outer01();
        outer01.fun01();
    }
}
interface A1 {
    void show();
}

/**
 * java 底层创建：
 * class Outer01$1 implements A1{
 *
 * @Override
 *           public void show() {
 *           System.out.println("重写了接口方法...");
 *           }
 * }
 *           结束后返回Outer01$1类的实例给引用a，Outer01$1死亡，但a可以继续多次使用
 */
class Outer01 {

    public void fun01() {
        // 方法里的匿名内部类

        A1 a = new A1() {
            @Override
            public void show() {
                System.out.println("重写了接口A1方法...");
            }
        };
        a.show();
    }

}
