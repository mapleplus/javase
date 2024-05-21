package com.fengxin.myproject.mychat.server.service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FENGXIN
 **/
public class ServerThreadMap {
    private static Map<String,ServerConnectClientThread> map = new HashMap<> ();
    public static void addServerThread(String userName,ServerConnectClientThread serverConnectClientThread){
        map.put (userName,serverConnectClientThread);
    }
    
    public static ServerConnectClientThread getMap (String userName) {
        return map.get (userName);
    }
}
