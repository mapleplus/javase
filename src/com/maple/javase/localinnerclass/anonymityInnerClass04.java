package com.maple.javase.localinnerclass;

/**
 * @author FENGXIN
 **/
public class anonymityInnerClass04 {
    public static void main(String[] args) {
        // 匿名内部类传递实参
        test(new A04() {
            @Override
            public void show() {
                System.out.println("匿名内部类传递了实参...");
            }
        });
    }
    // 定义静态方法，main方法是静态方法，main只能调用本类静态成员
    public static void test(A04 a04) {
        a04.show();
    }
}
interface A04 {
    void show();
}