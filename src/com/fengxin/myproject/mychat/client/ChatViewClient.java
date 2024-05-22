package com.fengxin.myproject.mychat.client;


import com.fengxin.myproject.mychat.client.service.ClientConnectServer;
import com.fengxin.myproject.mychat.server.service.ServerConnectClientThread;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author FENGXIN
 * 主界面
 **/
public class ChatViewClient {
    public static void main (String[] args)  {
        try {
            chatMenu ();
        } catch (IOException e) {
            throw new RuntimeException (e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException (e);
        } catch (InterruptedException e) {
            throw new RuntimeException (e);
        }
    }
    private static Scanner scanner = new Scanner (System.in);
    public static void chatMenu() throws IOException, ClassNotFoundException, InterruptedException {
        //登录
        // 设置系统运行标志
        boolean flag1 = true;
        while (flag1){
            System.out.println ("==========CHAT========");
            System.out.println ("1. 登录");
            System.out.println ("0. 退出");
            System.out.println ("请输入您的选择：");
            int choice1 = 0;
            try {
                choice1 = scanner.nextInt ();
            } catch (Exception e) {
                System.out.println ("输入有误，请重新输入！");
            }
            switch (choice1){
                case 1:
                    // 登录
                    System.out.println ("========登录=======");
                    System.out.println ("请输入用户名：");
                    String username = scanner.next ();
                    System.out.println ("请输入密码：");
                    String password = scanner.next ();
                    // 在服务器验证用户名和密码
                    if(ClientConnectServer.verifyPassword (username, password)){
                        // 登录成功后进入聊天界面
                        System.out.println (username + "登录成功！");
                        boolean flag2 = true;
                        String content;
                            // 进入聊天界面
                            while (flag2) {
                                System.out.println ("======聊天界面=======");
                                System.out.println ("1. 显示在线用户");
                                System.out.println ("2. 发送群聊消息");
                                System.out.println ("3. 发送私聊消息");
                                System.out.println ("4. 发送文件");
                                System.out.println ("0. 退出");
                                System.out.println ("请输入您的选择：");
                                int choice2 = scanner.nextInt ();
                                switch (choice2){
                                    case 1:
                                        // 显示在线用户
                                        ClientConnectServer.getOnlineUsers (username);
                                        System.out.println ("在线用户：");
                                        Thread.sleep (5);
                                        break;
                                        
                                    case 2:
                                        // 发送群聊消息
                                        System.out.println ("请输入您要发送的群消息：");
                                        content = scanner.next ();
                                        ClientConnectServer.sendMessageToAll (username,content);
                                        Thread.sleep (5);
                                        break;
                                        
                                    case 3:
                                        // 发送私聊消息
                                        System.out.println ("请输入您要发送的用户：");
                                        String receiver = scanner.next ();
                                        System.out.println ("请输入您要发送的消息：");
                                        content = scanner.next ();
                                        ClientConnectServer.sendMessageToOne (username, receiver, content);
                                        Thread.sleep (5);
                                        break;
                                        
                                    case 4:
                                        // 发送文件
                                        System.out.println ("发送文件");
                                        Thread.sleep (5);
                                        break;
                                        
                                    case 0:
                                        // 退出
                                        flag2 = false;
                                        ClientConnectServer.logout (username);
                                        System.out.println ("退出聊天界面");
                                        Thread.sleep (5);
                                        break;
                                        
                                    default:
                                        System.out.println ("无效的选择！");
                                        Thread.sleep (5);
                                        break;
                                }
                            }
                    }else{
                        System.out.println ("用户名或密码错误！");
                    }
                    break;
                case 0:
                    // 退出
                    flag1 = false;
                    System.out.println ("退出系统");
                    break;
            }
        }
    }
}
