package com.maple.project.order;

import java.io.*;
import java.util.Scanner;

/**
 * @author maple
 */
public class Admin extends Person{
    static int dishId = 0;
    
    // 注册
    public static void sign(String name, String password){
        String fileCustomerPath = "E:\\admin.txt";
        File file = new File(fileCustomerPath);
        FileOutputStream fos;
        BufferedWriter bw = null;
        try {
            fos = new FileOutputStream (fileCustomerPath, true);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            bw = new BufferedWriter(osw);
            bw.write (name + " " + password);
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
    
    // 登录
    public static boolean login(String name, String password){
        String filePath = "E:\\admin.txt";
        FileReader fr;
        BufferedReader br = null;
        try {
            fr = new FileReader (filePath);
            br = new BufferedReader (fr);
            String line;
            String customerInfo;
            while ((line = br.readLine ()) != null) {
                customerInfo = line;
                String[] customerInfos = customerInfo.split (" ");
                if(customerInfos[0].equals (name) && customerInfos[1].equals (password)){
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
    // 管理员
    public static void menu(){
        while (true) {
            System.out.println ("-----管理员------");
            System.out.println ("1 添加菜品");
            System.out.println ("2 删除菜品");
            System.out.println ("3 更新菜品");
            System.out.println ("4 浏览菜品");
            System.out.println ("5 浏览用户");
            System.out.println ("6 浏览订单");
            System.out.println ("7 删除用户");
            System.out.println ("0 退出");
            System.out.println ("请输入：");
            Scanner scanner = new Scanner (System.in);
            int choice = scanner.nextInt ();
            switch (choice){
                case 1:
                    // 添加菜品
                    addDish ();
                    break;
                    
                case 2:
                    // 删除菜品
                    deleteDish ();
                    break;
                    
                case 3:
                    // 更新菜品
                    updateDish ();
                    break;
                    
                case 4:
                    // 浏览菜品
                    viewDishes ();
                    break;
                    
                case 5:
                    // 浏览顾客
                    viewCustomers ();
                    break;
                    
                case 6:
                    // 浏览订单
                    viewOrders ();
                    break;
                    
                case 7:
                    // 删除用户
                    deleteCustomer ();
                    break;
                    
                case 0:
                    System.out.println ("退出");
                    return;
                    
                default:
                    System.out.println ("输入有误，请重新输入");
                    break;
            }
        }
    }
    
    // 添加菜品
    public static void addDish(){
        while (true) {
            System.out.println ("-----添加菜品------");
            Scanner scanner = new Scanner (System.in);
            System.out.println ("请输入菜品名称：");
            String dishName = scanner.next ();
            System.out.println ("请输入菜品价格：");
            double dishPrice = scanner.nextDouble ();
            System.out.println ("请输入菜品描述：");
            String dishDescription = scanner.next ();
            // 设置当前待添加的菜品ID
            dishId ++;
            // 将菜品信息写入文件
            File dishFile = new File("E:\\dish.txt");
            FileWriter fw;
            BufferedWriter bw = null;
            try {
                fw = new FileWriter (dishFile, true);
                bw = new BufferedWriter (fw);
                bw.write (dishId + " " + dishName + " " + dishPrice + " " + dishDescription);
                // 添加换行符
                bw.newLine ();
                System.out.println ("添加成功");
                System.out.println ("是否继续添加？(y/n)");
                String choice = scanner.next ();
                if ("n".equals (choice)) {
                    break;
                }
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
    }
    
    // 删除菜品
    public static void deleteDish(){
        System.out.println ("-----删除菜品------");
        Scanner scanner = new Scanner (System.in);
        System.out.println ("请输入要删除的菜品ID：");
        int id = scanner.nextInt ();
        // 获取id菜品
        String[] dishArr = getDishes ();
        // 删除菜品
        for(int i = id - 1; i < dishArr.length - 1; i++){
            dishArr[i] = dishArr[i + 1];
            // 更新菜品id
            int dishId = Integer.parseInt (dishArr[i].split (" ")[0]);
            dishId--;
            dishArr[i] = dishId + " " + dishArr[i].substring (2);
        }
        dishArr[dishArr.length - 1] = "";
        // 更新文件
        writeDishes (dishArr);
        System.out.println ("删除成功");
    }
    
    // 更新菜品信息
    public static void updateDish(){
        while (true) {
            // 读取菜品信息
            String[] dishes = getDishes ();
            System.out.println ("-----更新菜品------");
            Scanner scanner = new Scanner (System.in);
            System.out.println ("1 更新菜品名称");
            System.out.println ("2 更新菜品价格");
            System.out.println ("3 更新菜品描述");
            System.out.println ("0 返回");
            System.out.println ("请输入：");
            int choice = scanner.nextInt ();
            int id;
            String[] dishArray ;
            switch (choice){
                case 1:
                    System.out.println ("-----更新菜品名称-----");
                    System.out.println ("请输入要更新的菜品ID：");
                    id = scanner.nextInt ();
                    System.out.println ("请输入新的菜品名称：");
                    String name = scanner.next ();
                    dishArray = dishes[id - 1].split(" ");
                    dishArray[1] = name;
                    dishes[id - 1] = dishArray[0] + " " + dishArray[1] + " " + dishArray[2] + " " + dishArray[3];
                    break;
                    
                case 2:
                    System.out.println ("-----更新菜品价格-----");
                    System.out.println ("请输入要更新的菜品ID：");
                    id = scanner.nextInt ();
                    System.out.println ("请输入新的菜品价格：");
                    double price = scanner.nextDouble ();
                    dishArray = dishes[id - 1].split(" ");
                    dishArray[2] = String.valueOf (price);
                    dishes[id - 1] = dishArray[0] + " " + dishArray[1] + " " + dishArray[2] + " " + dishArray[3];
                    break;
                    
                case 3:
                    System.out.println ("-----更新菜品描述-----");
                    System.out.println ("请输入要更新的菜品ID：");
                    id = scanner.nextInt ();
                    System.out.println ("请输入新的菜品描述：");
                    String desc = scanner.next ();
                    dishArray = dishes[id - 1].split(" ");
                    dishArray[3] = desc;
                    dishes[id - 1] = dishArray[0] + " " + dishArray[1] + " " + dishArray[2] + " " + dishArray[3];
                    break;
                    
                case 0:
                    return;
                    
                default:
                    System.out.println ("输入有误，请重新输入");
                    break;
            }
            // 更新文件
            writeDishes (dishes);
            System.out.println ("更新成功");
        }
    }
    
    // 浏览菜品
    public static void viewDishes () {
        System.out.println ("-----浏览菜品------");
        // 提取菜品信息
        String[] dishes = getDishes ();
        for(String dish : dishes){
            System.out.println (dish);
        }
    }
    
    // 浏览顾客
    private static void viewCustomers () {
        System.out.println ("-----浏览用户------");
        // 提取用户信息
        String[] users = Customer.readCustomer ();
        if(users.length == 0){
            System.out.println ("暂无顾客信息");
            return;
        }
        for (String user : users) {
            System.out.println (user);
        }
    }
    
    // 浏览所有订单
    private static void viewOrders (){
        System.out.println ("-----浏览订单------");
        // 提取订单信息
        for (int i = 1 ; i <= Customer.getCustomerNum () ; i++) {
            System.out.println ("顾客" + i + "的订单：");
            Dish.orderInfo (i);
        }
    }
    
    // 删除顾客
    // 每位顾客都有唯一识别的id 不可更改
    public static void deleteCustomer () {
        String[] customers = Customer.readCustomer ();
        System.out.println ("-----删除顾客------");
        Scanner scanner = new Scanner (System.in);
        System.out.println ("请输入要删除的顾客ID：");
        int id = scanner.nextInt ();
        System.out.println ("确认删除顾客吗？(Y/N)");
        String confirm = scanner.next ();
        int i;
        if("Y".equals (confirm)){
            if(customers.length != 0){
                for (i = 0 ; i < customers.length ; i++) {
                    String[] customer = customers[i].split (" ");
                    if(customer[0].equals (String.valueOf (id))){
                        customers[i] = " ";
                        break;
                    }
                }
                
                // 更新文件格式
                if(customers.length != 0){
                    for( i = id - 1; i < customers.length - 1; i++){
                        customers[i] = customers[i + 1];
                    }
                    customers[customers.length - 1] = "";
                    Customer.writeAllCustomer (customers);
                }
                
                // 删除顾客订单
                File file = new File ("E:\\order" + id + ".txt");
                if (file.exists ()) {
                    if(file.delete ()){
                        System.out.println ("删除成功");
                    }
                }
            }
        }
        
    }
    
    // 读取菜品信息
    public static String[] getDishes () {
        FileReader fr;
        BufferedReader br = null;
        String line;
        String dishes;
        try {
            fr = new FileReader ("E:\\dish.txt");
            br = new BufferedReader (fr);
            dishes = "";
            while ((line = br.readLine ()) != null){
                dishes += line + "\n";
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
        // 以换行符分割字符串
        return dishes.split ("\n");
    }
    // 一次性写入菜品信息
    private static void writeDishes (String[] dishes) {
        FileWriter fw;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter ("E:\\dish.txt",false);
            bw = new BufferedWriter (fw);
            for (String s : dishes) {
                bw.write (s);
                // 添加换行符
                bw.newLine ();
            }
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
}
