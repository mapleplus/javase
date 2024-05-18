package com.fengxin.basic.thread;

/**
 * @author FENGXIN
 **/
public class ThreadDaemon {
    public static void main (String[] args) throws InterruptedException {
        ThreadDaemonTest threadDaemonTest = new ThreadDaemonTest ();
        //设置为守护线程
        threadDaemonTest.setDaemon (true);
        threadDaemonTest.start ();
        //主线程执行,执行结束后守护线程自动结束
        for (int i = 0 ; i < 10 ; i++) {
            System.out.println ("main is running");
            Thread.sleep (10);
        }
    }
}
class ThreadDaemonTest extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println ("This is a daemon thread");
            try {
                Thread.sleep (10);
            } catch (InterruptedException e) {
                throw new RuntimeException (e);
            }
        }
    }
}