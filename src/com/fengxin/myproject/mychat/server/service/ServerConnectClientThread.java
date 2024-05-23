package com.fengxin.myproject.mychat.server.service;

import com.fengxin.myproject.mychat.commom.Message;
import com.fengxin.myproject.mychat.commom.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
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
        while (true) {
            try {
                // 推送消息
                Thread thread = new Thread (new pushMessage ());
                thread.start ();
                // 读取客户端发送的消息
                ObjectInputStream ois = new ObjectInputStream (socket.getInputStream ());
                Message message = (Message) ois.readObject ();
                // 接收离线消息
                // 获取发送端的接收者，存在则查看是否在线
                if (message.getReceiver () != null) {
                    Map<String, ServerConnectClientThread> map = ServerThreadMap.getMap ();
                    Set<String> users = map.keySet ();
                    boolean flag = false;
                    // 如果接收者在线，则直接发送
                    for (String user : users) {
                        if (user.equals (message.getReceiver ())) {
                            flag = true;
                            break;
                        }
                    }
                    // 接收者不在线，则暂存
                    if (!flag) {
                        ServerThreadMap.addOfflineMessage (message.getReceiver () , message);
                        System.out.println ("接收消息用户" + message.getReceiver () + "离线，服务器暂存离线消息");
                        // 缓存消息后，继续接收客户端请求
                        continue;
                    }
                }
                // 查看登录用户是否有离线消息
                if (message.getMessageType ().equals (MessageType.LOGIN_FIRST)) {
                    // 获取离线map
                    Map<String, ArrayList<Message>> map = ServerThreadMap.getOfflineMessage ();
                    // 离线消息不为空，则发送给客户端
                    if (!map.isEmpty ()) {
                        // 获取离线消息集合
                        ArrayList<Message> messageToOffline = map.get (message.getSender ());
                        for (Message value : messageToOffline) {
                            ObjectOutputStream oosToOffline = new ObjectOutputStream (socket.getOutputStream ());
                            oosToOffline.writeObject (value);
                        }
                        System.out.println ("服务器发送" + message.getSender () + "离线消息");
                        // 发送完毕后，清空离线消息
                        ServerThreadMap.removeOfflineMessage (message.getSender ());
                    }
                }
                // 处理客户端发送的消息
                switch (message.getMessageType ()) {
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
                        ObjectOutputStream oosSendToOne = new ObjectOutputStream (serverConnectClientThread.getThreadSocket ().getOutputStream ());
                        oosSendToOne.writeObject (message);
                        System.out.println ("服务器转发" + message.getSender () + "发送的私信给" + message.getReceiver ());
                        break;
                    case MessageType.COMMON_MESSAGE_ALL:
                        // 发送群消息
                        Map<String, ServerConnectClientThread> threadMap = ServerThreadMap.getMap ();
                        Set<String> receiverSet = threadMap.keySet ();
                        for (String receiver : receiverSet) {
                            // 排除发送者自己
                            if (!receiver.equals (message.getSender ())) {
                                ObjectOutputStream oosSendToAll = new ObjectOutputStream (ServerThreadMap.getThread (receiver).getThreadSocket ().getOutputStream ());
                                oosSendToAll.writeObject (message);
                            }
                        }
                        System.out.println ("服务器转发" + message.getSender () + "发送的群消息");
                        break;
                    case MessageType.FILE_MESSAGE:
                        // 发送文件给在线用户
                        ObjectOutputStream outputStream = new ObjectOutputStream (ServerThreadMap.getThread (message.getReceiver ()).getThreadSocket ().getOutputStream ());
                        outputStream.writeObject (message);
                        System.out.println ("服务器转发" + message.getSender () + "发送的文件给" + message.getReceiver ());
                        break;
                    case MessageType.EXIT_LOGIN:
                        // 用户退出登录
                        System.out.println (message.getSender () + "退出登录");
                        ServerThreadMap.removeServerThread (message.getSender ());
                        socket.close ();
                        return;
                }
            } catch(IOException | ClassNotFoundException e){
                throw new RuntimeException (e);
            }
        }
    }
}
