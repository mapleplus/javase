package com.fengxin.basic.thread;

/**
 * @author FENGXIN
 * @data 2024.5.9
 * 创建一个Java线程，每隔一秒打印一次“小猫线程执行...”
 **/
public class Thread_demo01 {
    public static void main (String[] args)  {
        CatThread catThread = new CatThread ();
        // main线程启动一个子线程Thread-0，不会阻塞在start(),而是继续执行
        // start()方法调用后，子线程Thread-0开始执行run()方法中的代码
        // 两个线程交替执行，main线程执行5次，子线程执行8次
        catThread.start ();//调用Thread.start()方法启动线程
        // System.out.println ("主线程执行...");
        // for (int i = 1; i <= 6; i++)
        // {
        //     System.out.println ("主线程执行..." + i + Thread.currentThread ().getName ());// main线程
        //     Thread.sleep (1000);// 线程休眠1秒
        // }
    }
}
class CatThread extends Thread {// 创建一个线程类(该类继承Thread类才是一个线程)
    int count = 0;
        @Override
        public void run () {
            while (true) {
                // THread-0线程
                System.out.println ("小猫线程执行..." + (++count) + Thread.currentThread ().getName ());
                try {// 保证线程在sleep时不会被中断（即在sleep时还能感知响应，能响应中断，不会睡死）
                    // 线程休眠1秒
                    Thread.sleep (1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException (e);
                }
                if(count == 8)
                {
                    break;
                }
            }
        }
}