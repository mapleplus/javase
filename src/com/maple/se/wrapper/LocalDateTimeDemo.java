package com.maple.se.wrapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author maple
 **/
public class LocalDateTimeDemo {
    public static void main (String[] args) {
        // 创建一个LocalDateTime对象
        LocalDateTime now = LocalDateTime.now();

        // 打印当前日期和时间
        System.out.println("当前日期和时间: " + now);

        // 创建一个特定的LocalDateTime对象
        LocalDateTime specificDate = LocalDateTime.of(2023, 11, 2, 10, 30, 0);

        // 打印特定日期和时间
        System.out.println("特定日期和时间: " + specificDate);
        
        // 格式化日期和时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = formatter.format (now);
        System.out.println("Formatted Date Time: " + formattedDateTime);
    }
}
