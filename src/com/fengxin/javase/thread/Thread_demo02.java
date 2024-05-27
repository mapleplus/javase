package com.fengxin.javase.thread;

/**
 * @author FENGXIN
 **/
public class Thread_demo02 {
    public static void main (String[] args) {
        // 创建一个Dog对象
        Dog dog = new Dog ();
        // 创建一个Thread对象，并将Dog对象作为参数传递给Thread构造函数
        Thread thread = new Thread (dog);
        // 启动线程
        thread.start ();
    }
}
// 线程实现--->实现Runnable接口
class Dog implements Runnable {
    @Override
    public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Dog: " + i);
                try {
                    Thread.sleep (1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException (e);
                }
            }
    }
}