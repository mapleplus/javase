package com.maple.javase.net.socket.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author FENGXIN
 * 客户端
 * 更新内容：使用字符流传输数据
 * 包装流
 **/
public class TCPClient03 {
    public static void main (String[] args) throws IOException {
        // 连接本机端口，返回一个Socket对象 指定服务器的IP地址和端口号
        Socket socket = new Socket (InetAddress.getLocalHost (),8888);
        // 连接上后，获取输出流对象，该对象和当前的socket关联
        OutputStream outputStream = socket.getOutputStream ();
        
        // 客户端发送数据
        // 使用转换流包装数据
        BufferedWriter bufferedWriter = new BufferedWriter (new OutputStreamWriter (outputStream));
        // 写入数据到数据通道，向服务器发送数据
        bufferedWriter.write ("Hello, Server!");
        // 刷新缓存，将数据发送出去
        bufferedWriter.flush ();
        // 结束标志
        socket.shutdownOutput ();
        
        // 客户端接收服务器返回的数据
        InputStream inputStream = socket.getInputStream ();
        // 使用转换流包装数据
        BufferedReader bufferedReader = new BufferedReader (new InputStreamReader (inputStream));
        String line;
        while ((line = bufferedReader.readLine ()) != null){
            System.out.println (line);
        }

        // 关闭输出流和Socket
        bufferedReader.close ();
        bufferedWriter.close ();
        socket.close ();
    }
}
