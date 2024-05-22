package com.fengxin.myproject.mychat.server.service;

import com.fengxin.myproject.mychat.commom.Message;
import com.fengxin.myproject.mychat.commom.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author FENGXIN
 * 服务器验证客户端正确，一旦验证通过，那么之后的客户端请求都将在这里(该线程)处理，创建线程类包装socket 方便处理客户端的请求
 **/
public class ServerConnectClientThread extends Thread
        implements MessageType{
    private  Socket socket = null;
    private final String userName;
    
    public ServerConnectClientThread (Socket socket , String userName) {
        this.socket = socket;
        this.userName = userName;
    }
    public  Socket getThreadSocket () {
        return socket;
    }
    @Override
    public void run(){
        while (true){
            try {
                // 读取客户端发送的消息
                ObjectInputStream ois = new ObjectInputStream (socket.getInputStream ());
                Message message = (Message) ois.readObject ();
                switch (message.getMessageType ()){
                    case MessageType.GET_ONLINE_USER:
                        // 获取在线用户列表
                        Message onlineUser = new Message ();
                        onlineUser.setMessageType (MessageType.RETURN_ONLINE_USER);
                        onlineUser.setContent (ServerThreadMap.getOnlineUser ());
                        onlineUser.setSender (message.getSender ());
                        // 发送在线用户列表
                        ObjectOutputStream oos = new ObjectOutputStream (socket.getOutputStream ());
                        oos.writeObject (onlineUser);
                        System.out.println ("服务器发送" + userName + "请求的在线用户列表");
                        break;
                    case MessageType.COMMON_MESSAGE:
                        // 发送私信给在线用户
                        ServerConnectClientThread serverConnectClientThread = ServerThreadMap.getThread (message.getReceiver ());
                        ObjectOutputStream oosSendToOne = new ObjectOutputStream (serverConnectClientThread.getThreadSocket().getOutputStream ());
                        oosSendToOne.writeObject (message);
                        break;
                    case MessageType.COMMON_MESSAGE_ALL:
                        // 发送群消息
                        Map<String,ServerConnectClientThread> threadMap = ServerThreadMap.getMap ();
                        Set<String> receiverSet = threadMap.keySet ();
                        for (String receiver : receiverSet) {
                            if(!receiver.equals (message.getSender ())) {
                                ObjectOutputStream oosSendToAll = new ObjectOutputStream (ServerThreadMap.getThread (receiver).getThreadSocket ().getOutputStream ());
                                oosSendToAll.writeObject (message);
                            }
                        }
                        break;
                    case MessageType.EXIT_LOGIN:
                        // 用户退出登录
                        System.out.println (message.getSender () + "退出登录");
                        ServerThreadMap.removeServerThread (message.getSender ());
                        socket.close ();
                        return;
                }
            } catch (IOException e) {
                throw new RuntimeException (e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException (e);
            }
        }
    }
}
