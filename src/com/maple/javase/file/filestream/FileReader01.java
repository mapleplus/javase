package com.maple.javase.file.filestream;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author FENGXIN
 * 字符输入流
 **/
public class FileReader01 {
    public static void main (String[] args) {
        readFile ();
    }
    
    public static void readFile() {
        String filePath = "E:\\fileReader";
        FileReader fileReader = null;
        try {
            fileReader = new FileReader (filePath);
            // 一个一个字节读取
            int chLength;
            while ((chLength = fileReader.read ()) != -1) {
                System.out.println ((char) chLength);
            }
            // 一次性读取具体数目字符
            char[] chs = new char[10];
            while ((chLength = fileReader.read (chs)) != -1) {
                System.out.println (new String (chs, 0, chLength));
            }
        } catch (IOException e) {
            throw new RuntimeException (e);
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close ();
                } catch (IOException e) {
                    throw new RuntimeException (e);
                }
            }
        }
    }
}
