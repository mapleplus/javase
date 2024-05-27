package com.fengxin.javase.thread;

/**
 * @author FENGXIN
 * 让线程休眠，并使用interrupt()方法中断线程。
 **/
public class ThreadMethods01 {
    public static void main (String[] args) throws InterruptedException {
        ThreadMethod01 threadMethod01 = new ThreadMethod01 ();
        Thread thread = new Thread (threadMethod01);
        //set thread name
        thread.setName ("feng");
        //set thread priority
        thread.setPriority (Thread.MAX_PRIORITY);
        thread.start ();
        while (true) {
            //main线程休眠1s
            System.out.println ("main sleep 1s...");
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
                //thread sleep 5s,但是1s后main线程中断了thread线程的休眠
                Thread.sleep (5000);
            } catch (InterruptedException e) {
                System.out.println (Thread.currentThread ().getName () + " is interrupted.");
            }
        }
    }
}