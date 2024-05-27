package com.fengxin.javase.thread;

/**
 * @author FENGXIN
 **/
public class ThreadExit {
    public static void main (String[] args) throws InterruptedException {
        ThreadExitTest threadExitTest = new ThreadExitTest ();
        Thread thread = new Thread (threadExitTest);
        thread.start ();
        // 主线程休眠10秒,10秒后设置flag为false,线程退出
        System.out.println ("main sleep 10s");
        Thread.sleep (10000);
        threadExitTest.setFlag (false);
        System.out.println ("main exit");
    }
}
class ThreadExitTest implements Runnable{
    // 定义一个标志位,用于控制线程的退出
    private boolean flag = true;
    public void setFlag(boolean flag){
        this.flag = flag;
    }
    @Override
    public void run() {
        while (flag) {
            System.out.println ("Thread is running");
            try {
                Thread.sleep (1000);
            } catch (InterruptedException e) {
                throw new RuntimeException (e);
            }
        }
    }
}