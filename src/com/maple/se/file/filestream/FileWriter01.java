package com.maple.se.file.filestream;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author maple
 * 字符输出流
 **/
public class FileWriter01 {
    public static void main (String[] args) {
        writeFile();
    }
    public static void writeFile() {
        String filePath = "E:\\fileWriter.txt";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath, true);
            // 写入单个字符
            char c = 'A';
            fileWriter.write (c);
            // 写入多个字符
            char[] chars = {'B', 'C', 'D'};
            fileWriter.write (chars);
            // 写入指定部分的字符数组
            char[] chars2 = {'E', 'F', 'G'};
            fileWriter.write (chars2, 0, 1);
            // 写入字符串
            String str1 = "Hello, World!";
            fileWriter.write (str1);
            // 写入字符串的一部分
            String str2 = "Hello, World!";
            fileWriter.write (str2, 0, 6);
        } catch (IOException e) {
            throw new RuntimeException (e);
        } finally {
            // 必须关闭流，否则文件不会被写入
            try {
                if (fileWriter != null) {
                    fileWriter.close ();
                }
            } catch (IOException e) {
                throw new RuntimeException (e);
            }
        }
    }
}
