package com.fengxin.myproject.order;

import java.util.Scanner;

public class OrderMenu {
    public static void main(String[] args) {
        System.out.println("-----枫点菜-----");
        System.out.println("1 注册");
        System.out.println("2 登录");
        System.out.println("0 退出");
        System.out.println("请选择：");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                // 注册用户

                break;
            case 2:

                break;
            case 0:

                break;
            default:
                break;
        }
    }

    public static void signIn() {
        while (true) {
            System.out.println("-----注册-----");
            Customer customer = new Customer();
            Scanner scanner = new Scanner(System.in);

            System.out.println("请输入昵称：");
            String customerName = scanner.next();
            customer.setCustomerName(customerName);
            System.out.println("请输入密码：");
            String customerPassward = scanner.next();
            customer.setCustomerPassward(customerPassward);
            System.out.println("请确认密码：");
            String secondPassward = scanner.next();
            if (!customerPassward.equals(secondPassward)) {
                System.out.println("您输入的两次密码不一致，请重新注册");
                continue;
            } else {

                System.out.println("注册成功，欢迎您！");
            }
        }
    }
}
