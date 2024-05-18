package com.fengxin.basic.file.properties;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @author FENGXIN
 **/
public class Properties02 {
    public static void main (String[] args) throws IOException {
        // 创建Properties对象
        Properties properties = new Properties();
        
        // 添加键值对
        properties.setProperty ("枫", "000000");
        properties.setProperty ("Tom", "000001");
        properties.setProperty ("Merry", "888888");
        // 此时覆盖原值
        //properties.setProperty ("枫", "123456");
        // 添加k-v到文件中，第二个参数是注释
        properties.store (new FileWriter ("E:\\mysql.properties"), "MySQL Properties");
        properties.list (System.out);
    }
}
