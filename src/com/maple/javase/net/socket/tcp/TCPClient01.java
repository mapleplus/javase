package com.maple.javase.net.socket.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author FENGXIN
 * 客户端
 **/
public class TCPClient01 {
    public static void main (String[] args) throws IOException {
        // 连接本机端口，返回一个Socket对象 指定服务器的IP地址和端口号
        Socket socket = new Socket (InetAddress.getLocalHost (),9999);
        // 连接上后，获取输出流对象，该对象和当前的socket关联
        OutputStream outputStream = socket.getOutputStream ();
        // 写入数据到数据通道，向服务器发送数据
        outputStream.write ("Hello, server!".getBytes ());
        // 关闭输出流和Socket
        outputStream.close ();
        socket.close ();
    }
}
