package com.fengxin.basic.wrapper;

import java.util.Calendar;

/**
 * @author FENGXIN
 **/
public class Calendar_Test {
    public static void main (String[] args) {
        // 创建一个Calendar实例
        Calendar calendar = Calendar.getInstance();

        // 获取当前日期和时间
        int year = calendar.get(Calendar.YEAR);
        // 月份从0开始，所以要加1
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        
        // 输出当前日期和时间
        System.out.println("当前日期和时间：");
        System.out.println ( year + "-" + month + "-" + day + " " + hour + "：" + minute + "：" + second);
    }
}
