package com.fengxin.myproject.mychat.client.service;

import com.fengxin.myproject.mychat.commom.Message;
import com.fengxin.myproject.mychat.commom.MessageType;
import com.fengxin.myproject.mychat.commom.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
/**
 * @author FENGXIN
 * 客户端连接服务器端的相关操作
 **/
public class ClientConnectServer {
    private static User user = new User ();
    private static Socket socket;
    // 返回验证结果
    private static boolean check;
    // 验证用户密码
        public static boolean verifyPassword(String userName,String password)  {
            user = new User (userName,password);
            try {
                socket = new Socket (InetAddress.getLocalHost (),9999);
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
                    e.printStackTrace ();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace ();
                }
            return check;
        }
    
}
