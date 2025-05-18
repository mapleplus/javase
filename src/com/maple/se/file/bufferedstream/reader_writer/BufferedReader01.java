package com.maple.se.file.bufferedstream.reader_writer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author maple
 **/
public class BufferedReader01 {
    public static void main (String[] args) throws IOException {
        // 创建一个FileReader对象，指定要读取的文件路径
        String filePath = "E:\\bufferedReaderTest.txt";
        // 创建一个BufferedReader对象，将FileReader对象作为参数传入
        FileReader fileReader = new FileReader (filePath);
        BufferedReader bufferedReader = new BufferedReader (fileReader);
        // 逐行读取文件内容
        String line;
        while ((line = bufferedReader.readLine ()) != null){
            System.out.println (line);
        }
        // 关闭外层流，内层流会自动关闭
        bufferedReader.close ();
    }
}
