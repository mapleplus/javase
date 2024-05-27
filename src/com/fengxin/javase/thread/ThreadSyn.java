package com.fengxin.javase.thread;

/**
 * @author FENGXIN
 **/
public class ThreadSyn {
    public static void main (String[] args) {
        ThreadSynchronized threadSynchronized = new ThreadSynchronized ();
        Thread thread1 = new Thread (threadSynchronized);
        Thread thread2 = new Thread (threadSynchronized);
        Thread thread3 = new Thread (threadSynchronized);
        thread1.start ();
        thread2.start ();
        thread3.start ();
    }
}
class ThreadSynchronized implements Runnable {
    private static int num = 100;
    private boolean synFlag = true;
    @Override
    public void run () {
        while (synFlag) {
           // 对象锁
           synchronized (this){
                if(num <= 0){
                    System.out.println ("票已售完");
                    synFlag = false;
                    return;
                }
                try {
                    Thread.sleep (10);
                } catch (InterruptedException e) {
                    throw new RuntimeException (e);
                }
                System.out.println (Thread.currentThread ().getName () + "售票中... " + "剩余票数：" + --num);
            }
        }
    }
}