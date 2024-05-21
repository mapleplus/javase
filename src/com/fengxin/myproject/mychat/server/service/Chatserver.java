package com.fengxin.myproject.mychat.server.service;

import com.fengxin.myproject.mychat.commom.Message;
import com.fengxin.myproject.mychat.commom.MessageType;
import com.fengxin.myproject.mychat.commom.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author FENGXIN
 * 连接客户端，验证用户
 **/
public class Chatserver {
    private ServerSocket serverSocket = null;
    // 使用一个集合，实现多用户的连接
    private static ConcurrentHashMap<String,User> validUsers = new ConcurrentHashMap<> ();
    // 服务器加载时，将用户名和密码放入集合中
    static {
        validUsers.put ("fengxin", new User ("fengxin", "123456"));
        validUsers.put ("200", new User ("200", "000000"));
        validUsers.put ("枫", new User ("枫", "888888"));
    }
    // 判断用户名和密码是否正确
    public static boolean isValidUser(String username, String pwd){
        User user = validUsers.get(username);
        if(user == null){
            return false;
        }
        return user.getPwd ().equals (pwd);
    }
    public  Chatserver(){
        // 一直监听客户端的连接
        try {
            System.out.println ("等待客户端的连接");
            // 不能将9999写死，应该从配置文件中读取
            // 连接后，一个端口对应一个客户端，不能重复，即不能写入while，导致端口被占用
            this.serverSocket = new ServerSocket (9999);
            while (true) {
                // 连接客户端
                Socket socket = serverSocket.accept ();
                // 获取客户端发来的用户名和密码
                ObjectInputStream ois = new ObjectInputStream (socket.getInputStream ());
                User user = (User) ois.readObject ();
                // 发送验证信息
                    Message message = new Message ();
                    ObjectOutputStream oos = new ObjectOutputStream (socket.getOutputStream ());
                    // 验证用户
                    // 用户名和密码正确
                    if(isValidUser (user.getUsername (),user.getPwd ())){
                        // 向客户端发送登录成功的消息
                        message.setMessageType (MessageType.LOGIN_SUCCESS);
                        oos.writeObject (message);
                        // 启动一个新线程来处理该客户端的请求
                        ServerConnectClientThread scct = new ServerConnectClientThread (socket , user.getUsername ());
                        scct.start ();
                        // 将该客户端线程对象放入集合中
                        ServerThreadMap.addServerThread (user.getUsername (), scct);
                    }else{
                        // 向客户端发送登录失败的消息
                        message.setMessageType (MessageType.LOGIN_FAIL);
                        oos.writeObject (message);
                        // 用户名和密码不正确，关闭连接(注意关闭的顺序）
                        socket.close ();
                    }
            }
        } catch (IOException e) {
            e.printStackTrace ();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close ();
                }
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }
        
    }
}
