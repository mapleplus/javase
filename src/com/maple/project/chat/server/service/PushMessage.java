package com.maple.project.chat.server.service;

import com.maple.project.chat.commom.Message;
import com.maple.project.chat.commom.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author maple
 * 服务器推送消息给所有在线用户
 **/
public class PushMessage implements Runnable,MessageType{
    @Override
    public void run() {
        while (true) {
            Message message = new Message ();
            Scanner scanner = new Scanner (System.in);
            System.out.println ("请输入要推送的消息（输入exit退出）");
            String pushContent = scanner.next ();
            if("exit".equals (pushContent)){
                System.out.println ("关闭推送");
                break;
            }
            message.setContent (pushContent);
            message.setMessageType (PUSH_MESSAGE);
            Map<String, ServerConnectClientThread> mapAllUsers = ServerThreadMap.getMap ();
            Set<String> keySet = mapAllUsers.keySet ();
            for(String username:keySet){
                ServerConnectClientThread scct = mapAllUsers.get (username);
                ObjectOutputStream push;
                try {
                    push = new ObjectOutputStream (scct.getThreadSocket ().getOutputStream ());
                } catch (IOException e) {
                    throw new RuntimeException (e);
                }
                try {
                    push.writeObject (message);
                } catch (IOException e) {
                    throw new RuntimeException (e);
                }
            }
            System.out.println ("推送消息完成");
        }
    }
}
