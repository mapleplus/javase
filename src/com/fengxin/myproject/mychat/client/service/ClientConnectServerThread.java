package com.fengxin.myproject.mychat.client.service;

import com.fengxin.myproject.mychat.commom.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @author FENGXIN
 * 客户端验证成功后，打开一个线程，无线循环，用于随时接收服务器端发送的消息。
 **/
public class ClientConnectServerThread extends Thread{
    private Socket socket;
    
    public ClientConnectServerThread () {
    }
    
    public ClientConnectServerThread (Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        while (true){
            // 接收服务器端发送的消息
            try {
                // 如果没有消息，线程会阻塞在这里
                ObjectInputStream ois = new ObjectInputStream (socket.getInputStream ());
                Message message =(Message) ois.readObject ();
            } catch (IOException e) {
                throw new RuntimeException (e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException (e);
            }
        }
    }
    
    public Socket getSocket () {
        return socket;
    }
    
    public void setSocket (Socket socket) {
        this.socket = socket;
    }
}
