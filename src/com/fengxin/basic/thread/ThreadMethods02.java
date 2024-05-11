package com.fengxin.basic.thread;

/**
 * @author FENGXIN
 * @data 2024.5.11
 **/
public class ThreadMethods02 {
    public static void main (String[] args) throws InterruptedException {
        ThreadMethod02 threadMethod02 = new ThreadMethod02 ();
        Thread thread = new Thread (threadMethod02);
        for (int i = 0 ; i < 10 ; i++) {
            System.out.println (Thread.currentThread ().getName () + " is running");
            //如果i = 5，则调用thread.start ()方法启动新线程
            //如果i = 5，则调用thread.join ()方法等待新线程执行完毕
            if (i == 5) {
                thread.start ();
                thread.join ();
            }
        }
    }
}
class ThreadMethod02 implements Runnable{
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
