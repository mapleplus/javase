package com.fengxin.basic.thread;

/**
 * @author FENGXIN
 * @data 2024.5.9
 * 模拟Thread
 **/
public class Thread_demo03 {
    public static void main (String[] args) {
        Tiger tiger = new Tiger ();
        //Tiger实现了Runnable接口
        //将Tiger对象传入Thread类进行Runnable对象的动态绑定
        MyThread myThread = new MyThread (tiger);
        myThread.start ();
    }
}
class MyThread implements Runnable {//相当于Thread类实现Runnable接口
    private final Runnable target;
    
    public MyThread (Runnable target) {//构造函数,将Runnable对象传入
        this.target = target;
    }
    
    @Override
    public void run(){
        if(target != null){//动态绑定传入的对象，调用传入对象的run方法
            target.run ();
        }
    }
    public void start () {
        start0();
    }
    public void start0 () {//调用native方法，由JVM调用
        run ();
    }
}
class Tiger implements Runnable {
    @Override
    public void run(){
        System.out.println ("Tiger is running!");
    }
}