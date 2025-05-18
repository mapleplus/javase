package com.maple.project.chat.server.service;

import com.maple.project.chat.commom.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author FENGXIN
 **/
public class ServerThreadMap {
    // 存储在线用户和对应的线程
    private static final Map<String,ServerConnectClientThread> MAP = new HashMap<> ();

    // 存储离线用户和对应的待接收的离线消息
    private static final Map<String, ArrayList<Message>> OFFLINE_MESSAGE_MAP = new HashMap<> ();

    public static void addServerThread(String userName,ServerConnectClientThread serverConnectClientThread){
        MAP.put (userName,serverConnectClientThread);
    }

    // 返回一个ServerConnectClientThread对象
    public static ServerConnectClientThread getThread (String userName) {
        return MAP.get (userName);
    }

    public static Map<String,ServerConnectClientThread> getMap(){
        return MAP;
    }

    // 返回在线用户
    public static String getOnlineUser () {
        Set<String> userName = MAP.keySet ();
        StringBuilder userOnline = new StringBuilder ();
        for (String s : userName) {
            userOnline.append (s).append (" ");
        }
        System.out.println ("在线用户：" + userOnline);
        return userOnline.toString ();
    }

    // 用户下线
    public static void removeServerThread (String userName) {
        MAP.remove (userName);
    }

    // 接收离线消息
    public static void addOfflineMessage (String userName,Message message) {
        if (OFFLINE_MESSAGE_MAP.containsKey (userName)) {
            ArrayList<Message> arrayList = OFFLINE_MESSAGE_MAP.get (userName);
            arrayList.add (message);
            OFFLINE_MESSAGE_MAP.put (userName,arrayList);
        }else{
            ArrayList<Message> arrayList = new ArrayList<> ();
            arrayList.add (message);
            OFFLINE_MESSAGE_MAP.put (userName,arrayList);
        }
    }

    // 返回离线消息
    public static Map<String,ArrayList<Message>> getOfflineMessage () {
        return OFFLINE_MESSAGE_MAP;
    }

    // 删除离线消息
    public static void removeOfflineMessage (String userName) {
        OFFLINE_MESSAGE_MAP.remove (userName);
    }
}
