package com.fengxin.javase.wrapper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author FENGXIN
 **/
public class Data_Test {
    public static void main (String[] args) throws ParseException {
        
        // 创建一个Date对象获取当前日期和时间
        Date date1 = new Date();
        System.out.println(date1);
        
        // 创建一个Date对象，通过毫秒数指定特定的日期和时间 1970-1-1 8:00:00
        Date date2 = new Date (99999);
        System.out.println(date2);
        
        // 格式化日期和时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate1 = sdf.format(date1);
        System.out.println(formattedDate1);
        
        // 通过字符串指定特定的日期和时间
        String data3 = "2024-05-02 10:00:00";
        Date parsedDate = sdf.parse(data3);
        System.out.println(sdf.format (parsedDate));
    }
    
}
