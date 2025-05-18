package com.maple.javase.thread;

/**
 * @author FENGXIN
 * 创建两个线程，一个线程输出hello，另一个线程输出world，交替输出10次。
 **/
public class ThreadDemo01 {
    static class Thread1 implements Runnable{
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
    static class Thread2 extends Thread{
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
    public static void main (String[] args) {
        Thread1 threadTest01 = new Thread1();
        Thread thread01 = new Thread (threadTest01);
        Thread2 threadTest02 = new Thread2();
        thread01.start ();
        threadTest02.start ();
    }
}

