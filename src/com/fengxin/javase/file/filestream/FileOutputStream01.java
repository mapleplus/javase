package com.fengxin.javase.file.filestream;

import java.io.IOException;

/**
 * @author FENGXIN
 * 文件输出流（FileOutputStream01）
 **/
public class FileOutputStream01 {
    public static void main (String[] args) {
        writeFile();
    }
    public static void writeFile() {
        String filePath = "E:\\fileOutputStream.txt";
        java.io.FileOutputStream fileOutputStream = null;
        try {
            // 创建文件输出流,true表示追加写入,如果没有true,则每次写入会覆盖之前的内容
            fileOutputStream = new java.io.FileOutputStream (filePath,true);
            // 写入一个字符数据
            fileOutputStream.write ('A');
            // 写入一个字符串数据
            String dataString = "hello java";
            fileOutputStream.write (dataString.getBytes());
            // 写入指定位置字符串
            fileOutputStream.write (dataString.getBytes(), 0, 5);
        }  catch (IOException e) {
            throw new RuntimeException (e);
        } finally {
            // 关闭文件输出流
            try {
                fileOutputStream.close ();
            } catch (IOException e) {
                throw new RuntimeException (e);
            }
        }
    }
}
