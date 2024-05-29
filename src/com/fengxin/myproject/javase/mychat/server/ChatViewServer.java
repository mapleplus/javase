package com.fengxin.myproject.javase.mychat.server;

import com.fengxin.myproject.javase.mychat.server.service.Chatserver;

import java.io.IOException;

/**
 * @author FENGXIN
 **/
public class ChatViewServer {
    public static void main (String[] args) throws IOException, ClassNotFoundException {
        new Chatserver ();
    }
}
