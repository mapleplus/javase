package com.maple.project.chat.server;

import com.maple.project.chat.server.service.ChatServer;

import java.io.IOException;

/**
 * @author maple
 **/
public class ChatViewServer {
    public static void main (String[] args) throws IOException, ClassNotFoundException {
        new ChatServer();
    }
}
