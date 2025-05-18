package com.maple.project.chat.server;

import com.maple.project.chat.server.service.ChatServer;

import java.io.IOException;

/**
 * @author FENGXIN
 **/
public class ChatViewServer {
    public static void main (String[] args) throws IOException, ClassNotFoundException {
        new ChatServer();
    }
}
