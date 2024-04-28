package com.fengxin.myproject.menu;

import java.util.ArrayList;
import java.util.Scanner;

//对菜品的操作
public class MenuOperator {
    private ArrayList<Menu> menus = new ArrayList<>();
//    1.上架菜品
    public MenuOperator() {}
    public void addMenu() {
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);

//        name
        System.out.println("请输入菜品名称：");
        String name = sc.next();
        menu.setmName(name);
//        price
        System.out.println("请输入菜品价格：");
        double price = sc.nextDouble();
        menu.setPrice(price);
//        info
        System.out.println("请输入菜品其它信息：");
        String info = sc.next();
        menu.setInfo(info);
//      插入菜品进集合
        menus.add(menu);
        System.out.println("上架菜品成功！");
    }
//    2.展示菜品
    public void displayMenu() {
        if (menus.isEmpty()) {
            System.out.println("没有任何菜品，请您上架菜品！");
            System.out.println("----------------------------");
            return;
        }
        for (Menu menu : menus) {
            System.out.println(menu.getName());
            System.out.println(menu.getPrice());
            System.out.println(menu.getInfo());
        }
    }
//    3.开始
    public void start(){
        while (true) {
            System.out.println("欢迎来到菜单！");
            System.out.println("1：添加菜品");
            System.out.println("2：浏览菜品");
            System.out.println("3：退出");
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入选项ID以继续：");
            String ID = sc.next();
//            调用相应方法
            switch (ID){
                case "1":
                    addMenu();
                    break;
                case "2":
                    displayMenu();
                    break;
                case "3":
                    System.out.println("欢迎下次使用！");
                    System.out.println("----------------------------");
                    return;
                default:
                    System.out.println("ID没有匹配的操作！");
            }
            System.out.println("----------------------------");
        }

    }
}
