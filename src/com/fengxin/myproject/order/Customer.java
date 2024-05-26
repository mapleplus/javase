package com.fengxin.myproject.order;

import java.io.*;
import java.util.Scanner;

/**
 * @author FENGXIN
 */
public class Customer extends Person{
    protected static int customerNumber = 0;
    protected static int customerId = 0;
    
    // 写入注册顾客
    public static void writeCustomer(String name, String password){
        String fileCustomerPath = "E:\\customer.txt";
        FileWriter fw;
        BufferedWriter bw = null;
        try {
            customerId = getCustomerNum () + 1;
            customerNumber = getCustomerNum ();
            fw = new FileWriter (fileCustomerPath, true);
            bw = new BufferedWriter(fw);
            bw.write (customerId + " " + name + " " + password);
            bw.newLine ();
        } catch (IOException e) {
            throw new RuntimeException (e);
        }finally {
            try {
                if (bw != null) {
                    bw.close ();
                }
            } catch (IOException e) {
                throw new RuntimeException (e);
            }
        }
    }
    
    // 一次性写入全部顾客
    public static void writeAllCustomer(String[] customers){
        FileWriter fw;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter ("E:\\customer.txt", false);
            bw = new BufferedWriter (fw);
            for(String customer : customers){
                bw.write (customer);
                bw.newLine ();
            }
        } catch (IOException e) {
            throw new RuntimeException (e);
        } finally {
            try {
                if (bw != null) {
                    bw.close ();
                }
            } catch (IOException e) {
                throw new RuntimeException (e);
            }
        }
    }
    
    // 读取顾客
    public static String[] readCustomer (){
        if(!new File("E:\\customer.txt").exists () || new File("E:\\customer.txt").length () == 0){
            return new String[]{};
        }
        String filePath = "E:\\customer.txt";
        FileReader fr;
        BufferedReader br = null;
        String customerInfo = "";
        try {
            fr = new FileReader (filePath);
            br = new BufferedReader (fr);
            String line;
            while ((line = br.readLine ()) != null) {
                customerInfo += line + "\n";
            }
        } catch (IOException e) {
            throw new RuntimeException (e);
        }finally {
            try {
                if (br != null) {
                    br.close ();
                }
            } catch (IOException e) {
                throw new RuntimeException (e);
            }
        }
        return customerInfo.split ("\n");
    }
    
    // 注册
    public static void isSign(String name,String password){
        writeCustomer(name,password);
    }
    
    // 判断登录是否成功
    public static boolean isLogin(String name, String password){
        String filePath = "E:\\customer.txt";
        FileReader fr;
        BufferedReader br = null;
        String[] customerInfo;
        try {
            fr = new FileReader (filePath);
            br = new BufferedReader (fr);
            String line;
            while ((line = br.readLine ()) != null) {
                customerInfo = line.split (" ");
                if(customerInfo[1].equals (name) && customerInfo[2].equals (password)){
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            throw new RuntimeException (e);
        }finally {
            try {
                if (br != null) {
                    br.close ();
                }
            } catch (IOException e) {
                throw new RuntimeException (e);
            }
        }
    }
    
    // 菜单功能
    public static void menu(String name) {
        while (true) {
            System.out.println ("-----菜单-----");
            Admin.viewDishes ();
            System.out.println ("1 点餐");
            System.out.println ("2 订单查询");
            System.out.println ("0 退出点餐");
            Scanner scanner = new Scanner (System.in);
            System.out.println ("请选择：");
            int choice = scanner.nextInt ();
            switch (choice){
                case 1:
                    // 点餐功能
                    Dish.orderMenu (Customer.getCustomerId (name));
                    break;
                case 2:
                    // 订单查询功能
                    Dish.orderInfo (Customer.getCustomerId (name));
                    break;
                case 0:
                    return;
                    
                default:
                    System.out.println ("输入有误，请重新输入");
                    break;
            }
        }
    }
    
    // 获取顾客id
    public static int getCustomerId(String name){
        String[] customerInfo = Customer.readCustomer ();
        for (String s : customerInfo) {
            String[] info = s.split (" ");
            if (info[1].equals (name)) {
                return Integer.parseInt (info[0]);
            }
        }
        return 0;
    }
    
    // 获取用户数量
    public static int getCustomerNum(){
        String[] customerInfo = Customer.readCustomer ();
        return customerInfo.length;
    }
}


