package com.maple.project.chat.client;


import com.maple.project.chat.client.service.ClientConnectServer;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author maple
 * 主界面
 **/
public class ChatViewClient {
    public static void main (String[] args)  {
        try {
            chatMenu ();
        } catch (Exception e) {
            throw new RuntimeException (e);
        }
    }
    private static Scanner scanner = new Scanner (System.in);
    public static void chatMenu() {
        // 登录
        // 设置系统运行标志
        boolean flag1 = true;
        while (flag1) {
            System.out.println("==========CHAT========");
            System.out.println("1. 登录");
            System.out.println("0. 退出");
            System.out.println("请输入您的选择：");
            int choice1 = 0;
            try {
                if (scanner.hasNextInt()) {
                    choice1 = scanner.nextInt();
                } else {
                    System.out.println("输入有误，请重新输入！");
                    scanner.next(); // 清除错误输入
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("输入有误，请重新输入！");
                scanner.next(); // 清除错误输入
            }

            switch (choice1) {
                case 1:
                    // 登录
                    System.out.println("========登录=======");
                    System.out.println("请输入用户名：");
                    String username = scanner.next();
                    System.out.println("请输入密码：");
                    String password = scanner.next();
                    // 在服务器验证用户名和密码
                    try {
                        if (ClientConnectServer.verifyPassword(username, password)) {
                            // 登录成功后进入聊天界面
                            System.out.println(username + "登录成功！");
                            boolean flag2 = true;
                            String content;
                            String receiver;
                            // 进入聊天界面
                            while (flag2) {
                                System.out.println("======聊天界面=======");
                                System.out.println("1. 显示在线用户");
                                System.out.println("2. 发送群聊消息");
                                System.out.println("3. 发送私聊消息");
                                System.out.println("4. 发送文件");
                                System.out.println("0. 退出");
                                System.out.println("请输入您的选择：");
                                int choice2 = 0;
                                try {
                                    choice2 = scanner.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("输入有误，请重新输入！");
                                    scanner.next(); // 清除错误输入
                                    continue;
                                }

                                switch (choice2) {
                                    case 1:
                                        showOnlineUsers(username);
                                        break;

                                    case 2:
                                        sendGroupMessage(username);
                                        break;

                                    case 3:
                                        sendPrivateMessage(username);
                                        break;

                                    case 4:
                                        sendFile(username);
                                        break;

                                    case 0:
                                        // 退出
                                        flag2 = false;
                                        ClientConnectServer.logout(username);
                                        System.out.println("退出聊天界面");
                                        Thread.sleep(5);
                                        break;

                                    default:
                                        System.out.println("无效的选择！");
                                        Thread.sleep(5);
                                        break;
                                }
                            }
                        } else {
                            System.out.println("用户名或密码错误！");
                        }
                    } catch (Exception e) {
                        System.err.println("发生网络错误: " + e.getMessage());
                        e.printStackTrace();
                    }
                    break;

                case 0:
                    // 退出
                    flag1 = false;
                    System.out.println("退出系统");
                    break;

                default:
                    System.out.println("无效的选择！");
                    break;
            }
        }
    }

    private static void showOnlineUsers(String username) {
        ClientConnectServer.getOnlineUsers(username);
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void sendGroupMessage(String username) {
        System.out.println("请输入您要发送的群消息：");
        String content = ChatViewClient.scanner.next();
        ClientConnectServer.sendMessageToAll(username, content);
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void sendPrivateMessage(String username) {
        System.out.println("请输入您要发送的用户：");
        String receiver = ChatViewClient.scanner.next();
        System.out.println("请输入您要发送的消息：");
        String content = ChatViewClient.scanner.next();
        ClientConnectServer.sendMessageToOne(username, receiver, content);
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void sendFile(String username) {
        System.out.println("请输入您要发送的用户：");
        String receiver = ChatViewClient.scanner.next();
        System.out.println("请输入文件名：");
        String content = ChatViewClient.scanner.next();
        System.out.println("请输入您要发送的文件路径：");
        String filePath = ChatViewClient.scanner.next();
        ClientConnectServer.sendFile(username, receiver, content, filePath);
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
