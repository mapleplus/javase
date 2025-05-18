package com.maple.javase.file.filestream;

import java.io.IOException;

/**
 * @author FENGXIN
 * 将文件内容读取到程序中，并在程序控制台中输出，使用Java中的FileInputStream类
 * read(byte[] bytes)：从输入流读取一个字节数组的数据，最多b.length字节，如果不够则读取实际字节，没有输入可用此方法将阻塞，读取到文件末尾返回-1
 * read和read(byte[] bytes)返回实际读取的字节数
 **/
public class FileInputStream01 {
    public static void main (String[] args) {
        // readFile ();
        
        readFilePro ();
    }
    // 未优化
    public static void readFile()  {
        String filePath = "E:\\hello.txt";
        java.io.FileInputStream fileInputStream = null;
        try {
            fileInputStream = new java.io.FileInputStream (filePath);
            //一个一个字节读取
            int content;
            while ((content = fileInputStream.read ()) != -1) {
                //将字节转换为字符
                System.out.print ((char) content);
            }
        } catch (IOException e) {
            throw new RuntimeException (e);
        }finally {
            //关闭文件流,释放资源
            try {
                fileInputStream.close ();
            } catch (IOException e) {
                throw new RuntimeException (e);
            }
        }
    }
    // 优化：使用read(byte[] b)方法，一次读取一个字节数组,效率更高
    public static void readFilePro()  {
        String filePath = "E:\\hello.txt";
        java.io.FileInputStream fileInputStream = null;
        try {
            fileInputStream = new java.io.FileInputStream (filePath);
            //一次8个字节读取，不够则读取实际字节
            int contentLength;
            byte [] bytes = new byte[8];
            while ((contentLength = fileInputStream.read (bytes)) != -1) {
                //将字节转换为字符串
                System.out.print (new String (bytes,0,contentLength));
            }
        } catch (IOException e) {
            throw new RuntimeException (e);
        }finally {
            //关闭文件流,释放资源
            try {
                fileInputStream.close ();
            } catch (IOException e) {
                throw new RuntimeException (e);
            }
        }
    }
}
