package com.maple.javase.file.filestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author maple
 * 文件的拷贝
 **/
public class FileCopy {
    public static void main (String[] args) {
        copyFile ();
    }
    public static void copyFile() {
        String sourceFile = "E:\\sourceFile.txt";
        String targetFile = "E:\\targetFile.txt";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(sourceFile);
            fileOutputStream = new FileOutputStream(targetFile);
            //使用byte数组来读取和写入文件
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fileInputStream.read (buffer)) != -1){
                // 将读取的数据写入到目标文件中
                // 避免文件太大，采用边读边写，提高效率
                // 推荐使用write(byte[] b, int off, int len)方法，因为它更高效
                // 还能够避免在写入文件时出现缓冲区溢出的问题，或者写入不完整的数据
                fileOutputStream.write (buffer, 0, length);
            }
            System.out.println ("文件拷贝成功！");
        } catch (IOException e){
            throw new RuntimeException (e);
        } finally {
            // 关闭流
            try {
                if (fileInputStream != null) {
                    fileInputStream.close ();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close ();
                }
            } catch (IOException e) {
                throw new RuntimeException (e);
            }
        }
    }
}
