package com.fengxin.basic.file.bufferedstream.in_out_rw;

import java.io.*;

/**
 * @author FENGXIN
 * @data 2024.5.15
 * 转换流
 **/
public class OutputStreamWriter01 {
    public static void main (String[] args) throws IOException {
        String filePath = "E:\\In_Out_RW.txt";
        String charSetName = "UTF-8";
        FileOutputStream fileOutputStream = new FileOutputStream (filePath);
        // 创建一个OutputStreamWriter对象，指定字符编码写入内容
        OutputStreamWriter outputStream = new OutputStreamWriter (fileOutputStream, charSetName);
        
        String content = "Hello, World!你好，世界";
        outputStream.write (content);
        outputStream.close ();
        System.out.println ("写入完成");
    }
}
