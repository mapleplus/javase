package com.fengxin.demo;

/**
 * @author FENGXIN
 * @data 2024.5.11
 * 创建两个线程，一个线程输出hello，另一个线程输出world，交替输出10次。
 **/
public class Thread_Demo01 {
    public static void main (String[] args) {
        threadDemo01_Test01 threadTest01 = new threadDemo01_Test01 ();
        Thread thread01 = new Thread (threadTest01);
        threadDemo01_Test02 threadTest02 = new threadDemo01_Test02 ();
        thread01.start ();
        threadTest02.start ();
    }
}
class threadDemo01_Test01 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println ("hello,world");
            try {
                Thread.sleep (1000);
            } catch (InterruptedException e) {
                throw new RuntimeException (e);
            }
        }
    }
}
class threadDemo01_Test02 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println ("hi");
            try {
                Thread.sleep (1000);
            } catch (InterruptedException e) {
                throw new RuntimeException (e);
            }
        }
    }
}
