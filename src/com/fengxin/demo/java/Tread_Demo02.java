package com.fengxin.demo.java;

/**
 * @author FENGXIN
 * 主线程每隔一秒输出hi，当hi输出5次时
 * 创建一个新线程threadDemo02_Test01
 * 实现插队先让该线程每隔一秒输出hello
 * 当hello输出10次时，结束线程threadDemo02_Test01
 * 再主线程继续输出hi，当hi输出10次时，结束主线程。
 **/
public class Tread_Demo02 {
    public static void main (String[] args) throws InterruptedException {
        int countMain = 0;
        while (true) {
            countMain++;
            System.out.println ("hi " + countMain);
            Thread.sleep (1000);
            if (countMain == 5) {
                System.out.println ("please wait for threadDemo02_Test01 to end");
                Thread thread = new Thread (new threadDemo02_Test01 ());
                thread.start ();
                thread.join ();
            }
            if (countMain == 10) {
                System.out.println ("main is over");
                break;
            }
        }
        
    }
}
class threadDemo02_Test01 implements Runnable {
    private int count = 0;
    @Override
    public void run(){
        while (true) {
            count++;
            System.out.println ("hello " + count);
            try {
                Thread.sleep (1000);
            } catch (InterruptedException e) {
                throw new RuntimeException (e);
            }
            if (count == 10) {
                System.out.println ("threadDemo02_Test01 is over");
                break;
            }
        }
    }
}
