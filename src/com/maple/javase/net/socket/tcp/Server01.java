package com.maple.javase.net.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author maple
 * 服务器端
 **/
public class Server01 {
    public static void main (String[] args) throws IOException {
        // 创建ServerSocket对象，指定端口号,服务端在9999端口监听
        ServerSocket serverSocket = new ServerSocket (9999);
        // 等待客户端连接，连接成功返回一个Socket对象
        // accept()是一个阻塞方法，如果没有客户端连接，则一直等待
        Socket socket = serverSocket.accept ();
        // 获取输入流
        InputStream inputStream = socket.getInputStream ();
        // 读取数据并输出在控制台
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read (bytes)) != -1){
            System.out.println (new String (bytes, 0, len));
        }
        // 关闭资源
        inputStream.close ();
        socket.close ();
        // 关闭ServerSocket对象
        serverSocket.close ();
    }
}
