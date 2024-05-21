package com.fengxin.myproject.mychat.client;


import com.fengxin.myproject.mychat.client.service.ClientConnectServer;

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
            e.printStackTrace ();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
    }
     private static Scanner scanner = new Scanner (System.in);
    public static void chatMenu() throws IOException, ClassNotFoundException {
        //登录
        // 设置系统运行标志
        boolean flag1 = true;
        while (flag1){
            System.out.println ("==========CHAT========");
            System.out.println ("1. 登录");
            System.out.println ("0. 退出");
            System.out.println ("请输入您的选择：");
            int choice1 = scanner.nextInt ();
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
                                        System.out.println ("在线用户：");
                                        break;
                                        
                                    case 2:
                                        // 发送群聊消息
                                        System.out.println ("群聊消息");
                                        System.out.println ("请输入您要发送的消息：");
                                        break;
                                        
                                    case 3:
                                        // 发送私聊消息
                                        System.out.println ("私聊消息");
                                        System.out.println ("请输入您要发送的消息：");
                                        break;
                                        
                                    case 4:
                                        // 发送文件
                                        System.out.println ("发送文件");
                                        
                                        break;
                                        
                                    case 0:
                                        // 退出
                                        flag2 = false;
                                        System.out.println ("退出聊天界面");
                                        break;
                                        
                                    default:
                                        System.out.println ("无效的选择！");
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
