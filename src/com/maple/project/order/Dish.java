package com.maple.project.order;

import java.io.*;
import java.util.Scanner;

/**
 * @author FENGXIN
 *
 * 菜品类
 *
 */
public class Dish {
    protected static int id;
    private String name;
    private double price;
    
    public String getName () {
        return name;
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    // 订单信息
    public static void orderInfo(int id){
        // int orderId = id;
        FileReader fr;
        BufferedReader br;
        try {
            fr = new FileReader ("E:\\order" + id + ".txt");
            br = new BufferedReader (fr);
            String line;
            while ((line = br.readLine ()) != null) {
                System.out.println (line);
            }
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
    }
    
    // 顾客下单
    public static void orderMenu(int customerId){
        System.out.println ("-----购物车------");
        Scanner scanner = new Scanner (System.in);
        System.out.println ("请输入菜品ID：");
        int id = scanner.nextInt ();
        currentOrder (customerId,id);
    }
    
    // 添加当前顾客下单的菜品到订单中
    public static void currentOrder(int customerId,int id){
        String[] dishes = Admin.getDishes ();
        FileWriter fw;
        BufferedWriter bw = null;
        try {
            // 每个顾客的订单单独保存
            fw = new FileWriter ("E:\\order" + customerId + ".txt", true);
            bw = new BufferedWriter (fw);
            bw.write (dishes[id - 1]);
            bw.newLine ();
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
}