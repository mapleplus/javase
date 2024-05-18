package com.fengxin.basic.thread;

/**
 * @author FENGXIN
 * 测试死锁案例
 * thread1,thread2分别拿到o1,o2对象锁
 * 接着thread1想拿到o2锁，但被thread2拿着
 * thread2想拿到o1锁，但被thread1拿着
 * 两个线程进入Blocked状态被阻塞
 * 互不相让，死锁
 **/
public class ThreadDeadLock {
    public static void main (String[] args) {
        Thread thread1 = new Thread (new DeadLockDemo (true));
        Thread thread2 = new Thread (new DeadLockDemo (false));
        thread1.start ();
        thread2.start ();
    }
}
class DeadLockDemo implements Runnable{
    //保证数据共享
    private static Object o1 = new Object ();
    private static Object o2 = new Object ();
    private boolean flag;
    public DeadLockDemo(boolean flag){
        this.flag = flag;
    }
    @Override
    public void run(){
        if(flag){
            synchronized (o1){
                System.out.println(Thread.currentThread ().getName () + " just lock1...");
                synchronized (o2){
                    System.out.println("lock1 & lock2...");
                }
            }
        }
        else{
            synchronized (o2){
                System.out.println(Thread.currentThread ().getName () + " just lock2...");
                synchronized (o1){
                    System.out.println("lock1 & lock2...");
                }
            }
        }
    }
}