package com.fengxin.javase.net.download;

import com.fengxin.javase.file.define_util.StreamUtilToByteArray;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author FENGXIN
 * 下载文件 客户端
 **/
public class DownloadClient {
    public static void main (String[] args) throws IOException {
        Socket socket = new Socket (InetAddress.getLocalHost (),8888);
        
        // 发送下载请求
        Scanner scanner = new Scanner (System.in);
        System.out.println ("请输入要下载的文件名：");
        String fileName = scanner.next ();
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (socket.getOutputStream ()));
        bw.write (fileName);
        bw.flush ();
        socket.shutdownOutput ();
        
        // 接收下载文件
            // 下载路径
        String filePath = "E:\\" + fileName + ".mp4";
        FileOutputStream fileOutputStream = new FileOutputStream (filePath);
        
            // 接收文件
        BufferedInputStream bis = new BufferedInputStream (socket.getInputStream ());
        byte[] bytes = StreamUtilToByteArray.toByteArray (bis);
        fileOutputStream.write (bytes,0,bytes.length);
        System.out.println ("文件下载成功！");
        
        // 关闭流
        bis.close ();
        fileOutputStream.close ();
        bw.close ();
        socket.close ();
        
    }

}
