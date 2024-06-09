package com.fengxin.javase.file.properties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author FENGXIN
 **/
public class Properties01 {
    public static void main (String[] args) throws IOException {
        // 创建一个Properties对象
        Properties properties =  new Properties ();
        // 加载一个属性文件内容到Properties对象中
        properties.load (new FileReader ("src/com/fengxin/javase/file/properties/data.properties"));
        // 输出所有的属性到控制台
        properties.list (System.out);
        // 获取指定属性的值
        String value = properties.getProperty ("user");
        System.out.println ("user的值为：" + value);
    }
}
