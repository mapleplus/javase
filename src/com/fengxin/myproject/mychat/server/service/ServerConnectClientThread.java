package com.fengxin.myproject.mychat.server.service;

import com.fengxin.myproject.mychat.commom.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @author FENGXIN
 * 服务器验证客户端正确，创建线程类包装socket
 **/
public class ServerConnectClientThread extends Thread{
    private Socket socket;
    
    public ServerConnectClientThread (Socket socket , String userName) {
        this.socket = socket;
        this.userName = userName;
    }
    
    private String userName;
    
    public ServerConnectClientThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run(){
        while (true){
            try {
                ObjectInputStream ois = new ObjectInputStream (socket.getInputStream ());
                Message message = (Message) ois.readObject ();
            } catch (IOException e) {
                throw new RuntimeException (e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException (e);
            }
        }
    }
}
