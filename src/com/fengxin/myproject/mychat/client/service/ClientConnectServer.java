package com.fengxin.myproject.mychat.client.service;

import com.fengxin.myproject.mychat.commom.Message;
import com.fengxin.myproject.mychat.commom.MessageType;
import com.fengxin.myproject.mychat.commom.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;

/**
 * @author FENGXIN
 * 客户端连接服务器端的相关操作
 **/
public class ClientConnectServer {
    private static User user;
    private static Socket socket;
    
    // 验证用户密码
    public static boolean verifyPassword(String userName,String password)  {
        user = new User (userName,password);
        // 返回验证结果
        boolean check;
        try {
            socket = new Socket (InetAddress.getLocalHost () , 9999);
            // 发送用户信息到服务器
            ObjectOutputStream oos = new ObjectOutputStream (socket.getOutputStream ());
            oos.writeObject (user);
            // 等待服务器返回验证结果
            ObjectInputStream ois = new ObjectInputStream (socket.getInputStream ());
            Message message = (Message) ois.readObject ();
            // 进行验证并返回结果
            // 验证成功
            if(message.getMessageType ().equals (MessageType.LOGIN_SUCCESS)){
                check = true;
                // 创建一个线程装载socket
                ClientConnectServerThread ccst = new ClientConnectServerThread (socket);
                ccst.start ();
                // 将线程对象存放到集合中
                ClientThreadMap.addClientThread (userName,ccst);
            }else{
                // 验证失败
                socket.close ();
                check = false;
            }
            } catch (IOException e) {
                throw new RuntimeException (e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException (e);
            }
        // 返回验证结果
        return check;
    }
    // 获取在线用户列表
    public static void getOnlineUsers(String userName) {
        // 创建一个获取在线用户的消息对象
        Message message = new Message ();
        message.setMessageType (MessageType.GET_ONLINE_USER);
        message.setSender (userName);
        // 发送请求消息到服务器
        try {
            // 写入信息
            ClientConnectServerThread socketThread = ClientThreadMap.getClientThread (userName);
            ObjectOutputStream oos = new ObjectOutputStream (socketThread.getSocket ().getOutputStream ());
            oos.writeObject (message);
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
    }
    // 群消息
    public static void sendMessageToAll(String sender,String content) {
        Message message = new Message ();
        message.setSender (sender);
        message.setContent (content);
        message.setTime (new Date().toString ());
        message.setMessageType (MessageType.COMMON_MESSAGE_ALL);
        try {
            ObjectOutputStream oos = new ObjectOutputStream (ClientThreadMap.getClientThread (sender).getSocket ().getOutputStream ());
            oos.writeObject (message);
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
    }
    // 私信
    public static void sendMessageToOne(String sender,String receiver,String content) {
        Message message = new Message ();
        message.setSender (sender);
        message.setReceiver (receiver);
        message.setContent (content);
        message.setTime (new Date ().toString ());
        message.setMessageType (MessageType.COMMON_MESSAGE);
        try {
            ObjectOutputStream oos = new ObjectOutputStream (ClientThreadMap.getClientThread (sender).getSocket ().getOutputStream ());
            oos.writeObject (message);
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
    }
    // 退出系统
    public static void logout(String userName) {
        System.out.println ("退出系统");
        Message logourMessage = new Message ();
        logourMessage.setMessageType (MessageType.EXIT_LOGIN);
        logourMessage.setSender (userName);
        try {
            ObjectOutputStream oos = new ObjectOutputStream (ClientThreadMap.getClientThread (userName).getSocket ().getOutputStream ());
            oos.writeObject (logourMessage);
            System.exit (0);
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
    }
    
}
