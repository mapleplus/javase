package com.fengxin.basic.thread;

/**
 * @author FENGXIN
 * @data 2024.5.9
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
class Dog implements Runnable {// Tiger线程实现Runnable接口
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