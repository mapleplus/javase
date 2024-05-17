package com.fengxin.basic.net.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author FENGXIN
 * 服务器端
 * 更新内容：增加服务器返回数据的接收，增加结束标志
 **/
public class TCPServer02 {
    public static void main (String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket (8888);
        Socket socket = serverSocket.accept ();
        // 获取输入流
        InputStream inputStream = socket.getInputStream ();
        // 读取数据并输出在控制台
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read (bytes)) != -1){
            System.out.println (new String (bytes, 0, len));
        }
        
        // ----------------------------------------------------------------------
        // 服务器端发送数据给客户端
        OutputStream outputStream = socket.getOutputStream ();
        outputStream.write ("Hello,client".getBytes ());
        // 结束标志
        socket.shutdownOutput ();
        // ----------------------------------------------------------------------
        
        // 关闭资源
        inputStream.close ();
        socket.close ();
        // 关闭ServerSocket对象
        serverSocket.close ();
    }
}
