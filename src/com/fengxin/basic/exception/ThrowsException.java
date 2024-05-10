package com.fengxin.basic.exception;

/**
 * @author FENGXIN
 * @data 2024.5.10
 **/
public class ThrowsException {
    // 继续抛出异常给JVM
    public static void main(String[] args) {
        test();
    }

    // 抛出异常给调用者
    public static void test() throws ArithmeticException {
        int n1 = 10;
        int n2 = 0;
        System.out.println(n1 / n2);
    }
}
// 继承的throws细节
// 子类重写的方法抛出的`异常类型 == 父类异常类型`，或 父类抛出类型的子类型
class father {
    public void fun1() throws RuntimeException {
    }
}

class son extends father {
    @Override
    public void fun1() throws ArithmeticException {
    }
}