package com.maple.se.thread;

/**
 * @author maple
 * 模拟Thread
 **/
public class Thread03 {
    public static void main (String[] args) {
        Tiger tiger = new Tiger ();
        //Tiger实现了Runnable接口
        //将Tiger对象传入Thread类进行Runnable对象的动态绑定
        MyThread myThread = new MyThread (tiger);
        myThread.start ();
    }

    // 相当于Thread类实现Runnable接口
    static class MyThread implements Runnable {
        private final Runnable target;

        public MyThread (Runnable target) {//构造函数,将Runnable对象传入
            this.target = target;
        }
        public void start () {
            start0();
        }
        public void start0 () {//调用native方法，由JVM调用
            run ();
        }
        @Override
        public void run(){
            //动态绑定传入的对象，调用传入对象的run方法
            if(target != null){
                target.run ();
            }
        }
    }

    static class Tiger implements Runnable {
        @Override
        public void run(){
            System.out.println ("Tiger is running!");
        }
    }
}
