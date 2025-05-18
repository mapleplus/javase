package com.maple.javase.file.bufferedstream.in_out_rw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @author FENGXIN
 * 转换流
 **/
public class InputStreamReader01 {
    public static void main (String[] args) throws IOException {
        String filePath = "E:\\In_Out_RW.txt";
        FileInputStream fileInputStream = new FileInputStream (filePath);
        // 1.将FileInputStream对象传递给转换流，指定编码格式
        InputStreamReader inputStreamReader = new InputStreamReader (fileInputStream, StandardCharsets.UTF_8);
        // 2.将InputStreamReader对象传递给BufferedReader对象
        BufferedReader bufferedReader = new BufferedReader (inputStreamReader);
        String line;
        // 3.读取文件内容
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println (line);
        }
        // 关闭外层流BufferedReader对象
        bufferedReader.close();
    }
}
