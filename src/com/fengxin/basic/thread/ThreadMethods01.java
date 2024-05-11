package com.fengxin.basic.thread;

/**
 * @author FENGXIN
 * @data 2024.5.11
 * 让线程休眠，并使用interrupt()方法中断线程。
 **/
public class ThreadMethods01 {
    public static void main (String[] args) throws InterruptedException {
        ThreadMethod01 threadMethod01 = new ThreadMethod01 ();
        Thread thread = new Thread (threadMethod01);
        thread.setName ("feng");//set thread name
        thread.setPriority (Thread.MAX_PRIORITY);//set thread priority
        thread.start ();
        while (true) {
            //main线程休眠10s
            System.out.println ("main sleep...");
            Thread.sleep(1000);
            //main线程中断thread线程休眠
            thread.interrupt ();//interrupt the thread
        }
    }
}
class ThreadMethod01 implements Runnable{
    @Override
    public void run() {
        while (true) {
            
            for (int i = 0; i < 10; i++) {
                System.out.println (Thread.currentThread ().getName () + " is running.");
            }
            try {
                Thread.sleep (5000);//thread sleep 5s,但是1s后main线程中断了thread线程的休眠
            } catch (InterruptedException e) {
                System.out.println (Thread.currentThread ().getName () + " is interrupted.");
            }
        }
    }
}