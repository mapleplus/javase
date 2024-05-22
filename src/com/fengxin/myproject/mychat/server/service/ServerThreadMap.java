package com.fengxin.myproject.mychat.server.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author FENGXIN
 **/
public class ServerThreadMap {
    private static Map<String,ServerConnectClientThread> map = new HashMap<> ();
    public static void addServerThread(String userName,ServerConnectClientThread serverConnectClientThread){
        map.put (userName,serverConnectClientThread);
    }
    // 返回一个ServerConnectClientThread对象
    public static ServerConnectClientThread getThread (String userName) {
        return map.get (userName);
    }
    public static Map<String,ServerConnectClientThread> getMap(){
        return map;
    }
    // 返回在线用户
    public static String getOnlineUser () {
        Set<String> userName = map.keySet ();
        StringBuffer userOnline = new StringBuffer ();
        for (String s : userName) {
            userOnline.append (s).append (" ");
        }
        System.out.println ("在线用户：" + userOnline);
        return userOnline.toString ();
    }
    // 用户下线
    public static void removeServerThread (String userName) {
        map.remove (userName);
    }
}
