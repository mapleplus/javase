package com.maple.javase.net.upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author maple
 * TCP 文件上传 客户端
 **/
public class UploadClient {
    public static void main (String[] args) throws IOException {
        // 创建socket
        Socket socket = new Socket (InetAddress.getLocalHost (),8888);
        
        // 读取磁盘文件写入到字节流,边读边写
        String filePath = "E:\\图片\\壁纸\\2.jpeg";
        FileInputStream fileReader = new FileInputStream (filePath);
        OutputStream outputStream = socket.getOutputStream ();
        BufferedInputStream bis = new BufferedInputStream (fileReader);
        BufferedOutputStream bos = new BufferedOutputStream (outputStream);
        
        // 字节流经过socket进入数据通道
        byte[] buffer = new byte[1024];
        int length;
        while ((length = bis.read (buffer)) != -1){
            bos.write (buffer,0,length);
            // 刷新缓冲区，写入数据通道
            bos.flush ();
        }
        // 结束标志
        socket.shutdownOutput ();
        
        // 接收服务器端返回的上传成功标志
        InputStream inputStream = socket.getInputStream ();
        BufferedReader br = new BufferedReader (new InputStreamReader (inputStream));
        String line;
        while ((line = br.readLine ()) != null){
            System.out.println (line);
        }
        
        // 关闭流
        bos.close ();
        br.close ();
        bis.close ();
        socket.close ();
    }
}
