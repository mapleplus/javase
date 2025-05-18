package com.maple.project.chat.client.service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author maple
 * 存放客户端线程
 **/
public class ClientThreadMap {
    private static final Map<String, ClientConnectServerThread> map = new HashMap<> ();
    public static ClientConnectServerThread getClientThread (String userName) {
        return map.get (userName);
    }
    
    public ClientThreadMap () {
    }
    
    public static void addClientThread (String usrname, ClientConnectServerThread ccst) {
        map.put(usrname,ccst);
    }
}
