package com.maple.javase.net.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author FENGXIN
 * TCP 文件上传 服务器
 **/
public class UploadServer {
    public static void main (String[] args) throws IOException {
        // 等待连接
        ServerSocket serverSocket = new ServerSocket (8888);
        Socket socket = serverSocket.accept ();
        // 读取socket数据通道数据写入字节流
        // 字节流写入磁盘文件,边读边写
        
        // 创建目标文件
        String targetPath = "E:\\upload.jpg";
        FileOutputStream fileOutputStream = new FileOutputStream (targetPath);
        BufferedOutputStream bos = new BufferedOutputStream (fileOutputStream);
        
        // 读取socket数据通道数据
        InputStream inputStream = socket.getInputStream ();
        BufferedInputStream bis = new BufferedInputStream (inputStream);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = bis.read (buffer)) != -1){
            bos.write (buffer,0,length);
            // 刷新缓冲区，写入磁盘文件
            bos.flush ();
        }
        
        // 返回给客户端上传成功标志
        OutputStream outputStream = socket.getOutputStream ();
        BufferedWriter bufferedWriter = new BufferedWriter (new OutputStreamWriter (outputStream));
        bufferedWriter.write ("上传成功");
        // 刷新缓冲区，写入socket数据通道
        bufferedWriter.flush ();
        
        // 结束标志
        socket.shutdownOutput ();
        
        // 关闭流
        bos.close ();
        bufferedWriter.close ();
        bis.close ();
        socket.close ();
        serverSocket.close ();
    }
}
