package com.maple.javase.net.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author maple
 * 客户端
 * 更新内容：增加服务器返回数据的接收，增加结束标志
 **/
public class Client02 {
    public static void main (String[] args) throws IOException {
        // 连接本机端口，返回一个Socket对象 指定服务器的IP地址和端口号
        Socket socket = new Socket (InetAddress.getLocalHost (),8888);
        // 连接上后，获取输出流对象，该对象和当前的socket关联
        OutputStream outputStream = socket.getOutputStream ();
        // 写入数据到数据通道，向服务器发送数据
        outputStream.write ("Hello, server!".getBytes ());
        // 结束标志
        socket.shutdownOutput ();
        // ----------------------------------------------------------------------
        // 客户端接收服务器返回的数据
        InputStream inputStream = socket.getInputStream ();
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read (bytes)) != -1){
            System.out.println (new String (bytes,0,len));
        }
        // ----------------------------------------------------------------------
        // 关闭输出流和Socket
        outputStream.close ();
        socket.close ();
    }
}
