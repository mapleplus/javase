package com.fengxin.demo.java;

/**
 * @author FENGXIN
 *
 *  有一个铃声接口Bell， 里面有个ring方法。
 *  有一个手机类cellPhone， 具有闹钟功能alarmClock, 参数是Bell类型
 *  测试手机类的闹钟功能，通过匿名内部类(对象)作为参数，打印：懒猪起床了
 *  再传入另一个匿名内部类(对象)，打印：小伙伴上课了
 **/
public class Ring_InnerClass {
    public static void main (String[] args) {
        cellPhone cellPhone = new cellPhone ();
        cellPhone.alarmClock (new Bell () {
            @Override
            public void ring () {
                System.out.println ("懒猪起床了");
            }
        });
        cellPhone.alarmClock (new Bell () {
            @Override
            public void ring () {
                System.out.println ("小伙伴上课了");
            }
        });
    }
}
interface Bell{
    public void ring();
}
class cellPhone implements Bell{
    public void alarmClock(Bell bell){
        bell.ring();
    }
    @Override
    public void ring(){}
}