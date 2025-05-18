package com.maple.se.net.download;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import com.maple.se.file.define_util.StreamUtilToByteArray;
/**
 * @author maple
 * 下载文件 服务器
 **/
public class DownloadServer {
    public static void main (String[] args) throws IOException {
        // 等待客户端连接
        ServerSocket serverSocket = new ServerSocket (8888);
        System.out.println ("等待客户端连接...");
        Socket socket = serverSocket.accept ();
        
        // 接收客户端请求的文件名(包装流接收)
        BufferedReader br = new BufferedReader (new InputStreamReader (socket.getInputStream ()));
        StringBuilder fileName = new StringBuilder ();
        String line;
        
        // 保存文件名
        while ((line = br.readLine ()) != null) {
            fileName.append (line);
        }
        fileName.append (".mp4");
        
        // 从文件下载库中比对文件名，有则下载
        int num = 8;
        while ( num >= 0){
            String fileServer = "实践分组任务0" + num +".mp4";
            num --;
            if(fileName.toString ().equals (fileServer)){
                // 获取文件
                BufferedInputStream bis = new BufferedInputStream (new FileInputStream ("E:\\视频\\Desktop\\" + fileServer));
                // 读取文件并发送给客户端
                BufferedOutputStream bos = new BufferedOutputStream (socket.getOutputStream ());
                // 将文件读取为字节数组
                byte[] bytes = StreamUtilToByteArray.toByteArray (bis);
                bos.write (bytes);
                bos.flush ();
                socket.shutdownOutput ();
                bos.close ();
                bis.close ();
                break;
            }
        }
        // 关闭流
        br.close ();
        socket.close ();
        serverSocket.close ();
    }
}
