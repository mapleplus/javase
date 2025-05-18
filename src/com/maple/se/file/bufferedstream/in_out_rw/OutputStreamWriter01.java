package com.maple.se.file.bufferedstream.in_out_rw;

import java.io.*;

/**
 * @author maple
 * 转换流
 **/
public class OutputStreamWriter01 {
    public static void main (String[] args) throws IOException {
        String filePath = "E:\\In_Out_RW.txt";
        String charSetName = "UTF-8";
        FileOutputStream fileOutputStream = new FileOutputStream (filePath);
        // 创建一个OutputStreamWriter对象，指定字符编码写入内容
        OutputStreamWriter outputStream = new OutputStreamWriter (fileOutputStream, charSetName);
        BufferedWriter bufferedWriter = new BufferedWriter (outputStream);
        String content = "Hello, World!你好，世界";
        bufferedWriter.write (content);
        // 关闭外层流，自动关闭内层流，且自动刷新缓冲区
        // 数据写入文件
        bufferedWriter.close ();
        System.out.println ("写入完成");
    }
}
