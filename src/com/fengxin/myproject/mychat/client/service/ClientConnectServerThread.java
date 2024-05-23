package com.fengxin.myproject.mychat.client.service;

import com.fengxin.myproject.mychat.commom.Message;
import com.fengxin.myproject.mychat.commom.MessageType;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author FENGXIN
 * 客户端验证成功后，打开一个线程，无限循环，用于随时接收服务器端发送的消息,并对消息进行处理
 **/
public class ClientConnectServerThread extends Thread implements MessageType{
    private Socket socket;
    public ClientConnectServerThread (Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        while (true){
            // 接收服务器端发送的消息
            try {
                // 无限循环，用于随时接收服务器端发送的消息
                // 如果没有消息，线程会阻塞在这里
                ObjectInputStream ois = new ObjectInputStream (socket.getInputStream ());
                Message message =(Message) ois.readObject ();
                switch (message.getMessageType ()){
                    case MessageType.RETURN_ONLINE_USER:
                        // 获取在线用户列表
                        String[] onlineUsers = message.getContent ().split (" ");
                        System.out.println ("当前在线用户：");
                        for (String onlineUser : onlineUsers) {
                            System.out.println (onlineUser);
                        }
                        break;
                    case MessageType.COMMON_MESSAGE:
                        // 接收私信
                        System.out.println ("私信来自" + message.getSender () + ":" + message.getContent ());
                        System.out.println ();
                        break;
                    case MessageType.COMMON_MESSAGE_ALL:
                        // 接收群消息
                        System.out.println ("群消息来自" + message.getSender () + ":" + message.getContent ());
                        System.out.println ();
                        break;
                    case MessageType.FILE_MESSAGE:
                        // 接收文件
                            // 输入有问题
                        System.out.println ("您收到了来自" + message.getSender () + "的文件：" + message.getContent ());
                        System.out.println ("请输入保存的目标路径：");
                        System.out.println ("选择1：保存到C盘");
                        System.out.println ("选择2：保存到E盘");
                        System.out.println ("选择3：自定义路径");
                        Scanner scanner = new Scanner (System.in);
                        int choice = scanner.nextInt ();
                        String targetPath;
                        if (choice == 1) {
                            targetPath = "C:\\example.jpeg";
                            // 保存文件
                            FileOutputStream fos = new FileOutputStream (targetPath);
                            fos.write (message.getFileBytes ());
                            fos.close ();
                        } else if (choice == 2) {
                            targetPath = "E:\\example.jpeg";
                            // 保存文件
                            FileOutputStream fos = new FileOutputStream (targetPath);
                            fos.write (message.getFileBytes ());
                            fos.close ();
                        }else {
                            System.out.println ("请输入自定义路径：");
                            targetPath = scanner.next ();
                            // 保存文件
                            FileOutputStream fos = new FileOutputStream (targetPath);
                            fos.write (message.getFileBytes ());
                            fos.close ();
                        }
                        System.out.println ("文件" + message.getContent () + "保存到" + targetPath);
                        break;
                    case MessageType.PUSH_MESSAGE:
                        // 接收推送消息
                        System.out.println ("收到推送消息：" + message.getContent ());
                        break;
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException (e);
            }
        }
    }
    
    public Socket getSocket () {
        return socket;
    }
    
    public void setSocket (Socket socket) {
        this.socket = socket;
    }
    public OutputStream getOutputStream() {
        try {
            return socket.getOutputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public InputStream getInputStream() {
        try {
            return socket.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
