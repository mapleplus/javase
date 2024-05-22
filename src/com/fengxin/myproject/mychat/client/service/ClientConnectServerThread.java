package com.fengxin.myproject.mychat.client.service;

import com.fengxin.myproject.mychat.commom.Message;
import com.fengxin.myproject.mychat.commom.MessageType;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

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
                if (message == null) {
                    throw new RuntimeException("接收到的消息为null");
                }
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
                }
            } catch (IOException e) {
                throw new RuntimeException (e);
            } catch (ClassNotFoundException e) {
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
