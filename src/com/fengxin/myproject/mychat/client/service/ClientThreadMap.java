package com.fengxin.myproject.mychat.client.service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FENGXIN
 * 存放客户端线程
 **/
public class ClientThreadMap {
    private static Map<String, ClientConnectServerThread> map = new HashMap<String, ClientConnectServerThread> ();
    public ClientConnectServerThread getClientThread (String userName) {
        return map.get (userName);
    }
    
    public ClientThreadMap () {
    }
    
    public static void addClientThread (String usrname, ClientConnectServerThread ccst) {
        map.put(usrname,ccst);
    }
}
