package com.maple.se.thread;

/**
 * @author maple
 **/
public class ThreadMethods02 {
    public static void main (String[] args) throws InterruptedException {
        ThreadMethod02 threadMethod02 = new ThreadMethod02 ();
        Thread thread = new Thread (threadMethod02);
        for (int i = 0 ; i < 10 ; i++) {
            // main线程执行
            System.out.println (Thread.currentThread ().getName () + " is running");
            // 如果i = 5，则调用thread.start ()方法启动新线程
            // 如果i = 5，则调用thread.join ()方法等待新线程执行完毕
            if (i == 5) {
                thread.start ();
                thread.join ();
            }
        }
    }

    static class ThreadMethod02 implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println ("Thread is running");
                try {
                    Thread.sleep (1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException (e);
                }
            }
        }
    }
}

