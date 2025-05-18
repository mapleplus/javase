package com.maple.project.order;

import java.util.Scanner;

/**
 * @author maple
 */
public class Application extends Thread{
    public static void main(String[] args) {
        while (true) {
            System.out.println("-----枫点菜-----");
            System.out.println("1 注册");
            System.out.println("2 登录");
            System.out.println("0 退出");
            System.out.println("请选择：");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // 注册
                    signIn ();
                    break;
                case 2:
                    // 登录
                    login ();
                    break;
                case 0:
                    System.out.println("退出程序");
                    System.exit (0);
                    break;
                default:
                    System.out.println ("无效的选项，请重新选择");
                    break;
            }
        }
    }
    
    // 注册逻辑
    public static void signIn() {
        while (true) {
            System.out.println("-----注册-----");
            System.out.println ("1 管理员");
            System.out.println ("2 顾客");
            System.out.println ("0 返回");
            System.out.println ("请选择：");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt ();
            switch (choice) {
                case 1:
                    // 注册管理员
                    signInCustomer (1);
                    break;
                case 2:
                    // 注册顾客
                    signInCustomer (2);
                    break;
                case 0:
                    return;
                default:
                    System.out.println ("无效的选项，请重新选择");
                    break;
            }
        }
    }
    
    // 注册
    public static void signInCustomer(int i) {
        while (true) {
            Scanner scanner = new Scanner (System.in);
            String secondPassword;
            switch (i){
                case 1:
                    // 注册管理员
                    System.out.println("-----注册管理员-----");
                    Admin admin = new Admin ();
                    System.out.println ("请输入昵称：");
                    String adminName = scanner.next ();
                    admin.setName (adminName);
                    System.out.println ("请输入密码：");
                    String adminPassword = scanner.next ();
                    admin.setPassword (adminPassword);
                    System.out.println ("请确认密码：");
                    secondPassword = scanner.next ();
                    if (!adminPassword.equals (secondPassword)) {
                        System.out.println ("您输入的两次密码不一致，请重新注册");
                    } else {
                        // 注册成功，将管理员信息保存到管理员信息文件中
                        Admin.sign (admin.getName () , admin.getPassword ());
                        System.out.println ("注册成功，欢迎您！");
                        return;
                    }
                    break;
                case 2:
                    // 注册顾客
                    System.out.println("-----注册顾客-----");
                    Customer customer = new Customer ();
                    System.out.println ("请输入昵称：");
                    String customerName = scanner.next ();
                    customer.setName (customerName);
                    System.out.println ("请输入密码：");
                    String customerPassword = scanner.next ();
                    customer.setPassword (customerPassword);
                    System.out.println ("请确认密码：");
                    secondPassword = scanner.next ();
                    if (!customerPassword.equals (secondPassword)) {
                        System.out.println ("您输入的两次密码不一致，请重新注册");
                    } else {
                        // 注册成功，将顾客信息保存到顾客信息文件中
                        Customer.isSign (customer.getName () , customer.getPassword ());
                        System.out.println ("注册成功，欢迎您！");
                        return;
                    }
                    break;
                default:
                    System.out.println ("输入有误，请重新输入");
                    break;
            }
        }
    }
    
    // 登录
    public static void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的昵称：");
        String name = scanner.next();
        System.out.println("请输入您的密码：");
        String password = scanner.next();
        System.out.println ("请输入您的身份（1 管理员 2 顾客）：");
        int identity = scanner.nextInt ();
        
        switch (identity) {
            case 1:
                // 管理员登录逻辑
                if (Admin.login (name, password)) {
                    System.out.println("登录成功！");
                    // 登录成功后，显示管理界面
                    Admin.menu ();
                } else {
                    System.out.println("昵称或密码错误，请重新登录");
                }
                break;
            case 2:
                // 顾客登录逻辑
                if (Customer.isLogin (name, password)) {
                    System.out.println("登录成功！");
                    // 登录成功后，显示顾客菜单
                    Customer.menu (name);
                } else {
                    System.out.println("昵称或密码错误，请重新登录");
                }
                break;
            default:
                System.out.println("身份输入错误，请重新登录");
                break;
        }
    }
}
