package com.maple.project.atm;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author FENGXIN
 */
public class Atm {

    ArrayList<Account> accounts = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public void start(){
        while (true) {
            System.out.println("----欢迎进入ATM系统----");
            System.out.println("1.用户开户");
            System.out.println("2.用户登录");
            System.out.println("3.退出");
            System.out.println("--------请选择--------");
            int choice = scanner.nextInt();
            switch(choice){
    //            用户开户方法
                case 1:
                    createAccount();
                    break;
    //            用户登录方法
                case 2:
                    loginAccount();
                    break;
    //            用户退出
                case 3:
                    return;
                default:
                    System.out.println("输入的命令不对哦，请重新输入");
                    System.out.println();
                    break;
            }
        }
    }

    /**
     * 开户模块
     *
     */

    private void createAccount(){
        Account account = new Account();
//        欢迎
        System.out.println("----用户注册----");
//        用户姓名
        System.out.println("请输入您的姓名：");
        String name = scanner.next();
        account.setName(name);
//        用户性别
        while (true) {
            System.out.println("请输入您的性别（男/女）：");
            char gender = scanner.next().charAt(0);
            if (gender == '男' || gender == '女') {
                account.setSex(gender);
                break;
            }
            else {
                System.out.println("您输入的性别不太合适哦");
                System.out.println();
            }
        }
//        用户密码
        while (true) {
            System.out.println("请输入您的密码：");
            String password1 = scanner.next();
            System.out.println("请确认您的密码：");
            String password2 = scanner.next();
            if (password2.equals(password1) ) {
                account.setPassword(password2);
                break;
            }
            else{
                System.out.println("两次密码不一致，请重新设置密码");
                System.out.println();
            }
        }
//        取现额度
        System.out.println("设置您的取现额度：");
        double balance = scanner.nextDouble();
        account.setLimitMoney(balance);
//        生成随机8位卡号 ----这里使用方法实现
        String newCard = creatCard();
        account.setCard(newCard);
//        添加账户进入ATM集合
        System.out.println("恭喜您" + account.getName()+"开户成功！");
        System.out.println("您的卡号是：" +account.getCard());
        System.out.println();
        accounts.add(account);
    }
    private String creatCard(){
//        创建空字符串 随机生成8位数加入
        while (true) {
            String cardNum ="";
            Random random = new Random();
            for (int i = 0; i < 8; i++) {
                int data = random.nextInt(10);
                cardNum += data;
            }
//***        判断是否有重复的卡号
            Account cardJudgeCard = getAccountCardId(cardNum);
//            如果返回null，则卡号唯一，返回生成的卡号 开户成功
            if (cardJudgeCard == null) {
                return cardNum;
            }
        }
    }
//***    判断ATM集合的账户里的卡号是否重复 （查询卡号）
    private Account getAccountCardId(String cardNum){
//        遍历账户卡号f
        for (Account account : accounts) {
            if (account.getCard().equals(cardNum) ) {
                return account;
            }
        }
        return null;
    }

    /**
     *登录模块
     */

    private  void loginAccount()
    {
        System.out.println("----登录----");
//        ATM中没有账户
        if (accounts.isEmpty())
        {
            System.out.println("当前没有任何账户，请您开户后再登录");
            System.out.println();
            return;
        }
//        账户登录及后续操作
        while (true)
        {
            System.out.println("请您输入卡号：");
            String cardNum = scanner.next();
            Account account = getAccountCardId(cardNum);
            if (account == null)
            {
                System.out.println("您输入的卡号不存在，请重新输入");
                System.out.println();
            }
//            账号存在 进入下一步：输入密码
            else {
                while (true)
                {
                    System.out.println("请您输入密码：");
                    String password = scanner.next();
//                    判断密码
                    if (account.getPassword().equals(password))
                    {
                        System.out.println("恭喜您" +account.getName()+"登录成功");
                        System.out.println();
//                      进入登录后的操作----独立功能模块
                        loginCommend(account);
                        return;
                    }
                    else{
                        System.out.println("您输入的密码不匹配，请重新输入");
                        System.out.println();
                    }
                }
            }
        }
    }
/**
 * 登录后续操作模块
 */
    private void loginCommend(Account account)
    {
        while (true) {
            System.out.println("----欢迎您进入ATM----");
            System.out.println(account.getName() +"请选择功能：" );
            System.out.println("1.查询账户");
            System.out.println("2.存款");
            System.out.println("3.取款");
            System.out.println("4.转账");
            System.out.println("5.修改密码");
            System.out.println("6.退出");
            System.out.println("7.注销");
            int choice = scanner.nextInt();
            switch(choice)
            {
                case 1:
    //                查询
                    showAccount(account);
                    break;
                case 2:
    //                存款
                    depositAccount(account);
                    break;
                case 3:
    //                取款
                    drawAccount(account);
                    break;
                case 4:
    //                转账
                    transferAccount(account);
                    break;
                case 5:
    //                修改密码
                    changePassword(account);
                    break;
                case 6:
    //                退出
                    System.out.println("您已退出");
                    System.out.println();
                    return;
                case 7:
    //                注销
                    deleteAccount(account);
                    return;
                default:
                    System.out.println("没有命令对应的功能");
                    System.out.println();
                    break;
            }
        }
    }
/** 销户*/
    private void deleteAccount(Account account) {
        System.out.println("----注销账户----");
        System.out.println("您确认要注销账户吗？");
        System.out.println("y:确认");
        System.out.println("n:取消");
        System.out.println("请输入选项:");
        String choice = scanner.next();
        if (choice.equals("y")) {
//            注销
            if (account.getMoney() != 0) {
//                账户还有余额
                System.out.println("您的账户还有余额，请您清空余额再注销");
                System.out.println();
            } else {
                accounts.remove(account);
                System.out.println("您已成功注销账户");
                System.out.println();
            }
        } else {
//            其它任意指令
            System.out.println("您已取消注销");
            System.out.println();
        }

    }
/** 修改密码*/
    private void changePassword(Account account) {
        System.out.println("----密码修改----");
        while (true) {
            System.out.println("请您输入原始密码：");
            String oldPassword = scanner.next();
            if(account.getPassword().equals(oldPassword)){
    //            进行修改密码
                while (true) {
                    System.out.println("输入新密码：");
                    String newPassword1 = scanner.next();
                    System.out.println("确认新密码：");
                    String newPassword2 = scanner.next();
                    if (newPassword2.equals(newPassword1)) {
        //                修改密码成功
                        account.setPassword(newPassword2);
                        System.out.println("修改密码成功！");
                        System.out.println();
                        return;
                    }
                    else {
                        System.out.println("先后密码不一致，请重新输入：");
                    }
                }
            }
            else {
    //            原始密码不对
                System.out.println("密码错误，请您重新输入");
                System.out.println();
            }
        }
    }

    /** 转账*/
    private void transferAccount(Account account) {
//        判断是否有其他账户
        if (accounts.size() == 1) {
            System.out.println("您是唯一账户，无法为不存在的账户转账");
            System.out.println();
        }
//      自己账户是否有金额
        else if (account.getMoney() == 0) {
            System.out.println("您的余额为0，无法转账");
            System.out.println();
        }
//        转账操作
        else {
            while (true) {
                System.out.println("----转账----");
                System.out.println("请您输入需要转账的卡号：");
                String cardNum = scanner.next();
//            转账账户不存在
                Account account1 = getAccountCardId(cardNum);
                if (account1 == null) {
                    System.out.println("您输入的账号不存在");
                    System.out.println();
                }
                else {
//                    账户存在 输入姓氏继续
                    String name = '*' + account1.getName().substring(1);
                    System.out.println("请您输入" + name + "的姓氏");
                    String firstName = scanner.next();
                    if (account1.getName().startsWith(firstName)) {
//                        姓氏正确 转账开始
                        System.out.println("请输入需要转账的金额：");
                        double money = scanner.nextDouble();
                        if (account.getMoney() >= money) {
//                            余额充足 进行转账
//                            更新自己的余额
                            account.setMoney(account.getMoney() - money);
//                            更新对方余额
                            account1.setMoney(account1.getMoney() + money);
                            System.out.println("转账成功！");
                            System.out.println();
                            break;
                        }
                        else {
//                            余额不足
                            System.out.println("您的余额不足，无法转账");
                            System.out.println();
                        }
                    }
                    else {
//                        姓氏不对
                        System.out.println("您输入的姓氏不匹配");
                        System.out.println();
                    }
                }
            }
        }
    }
/** 取款*/
    private void drawAccount(Account account) {
            System.out.println("----取款----");
        while (true) {
//        余额不足100元无法取款
            if (account.getMoney() < 100) {
                System.out.println("您的账户余额不足100元人民币，无法取款");
                System.out.println();
                break;
            }
    //        余额大于100元进行取款
            else {
                System.out.println("请输入您的取款金额：");
                double money = scanner.nextDouble();
//                余额小于取款金额
                if (money > account.getMoney()) {
                    System.out.println("您的余额不足，无法取款");
                    System.out.println();
                    break;
                }
//                余额充足
                else {
//                    取款金额大于取现额度
                    if (money < account.getLimitMoney()) {
                        System.out.println("您的取款金额受限");
                        System.out.println();
                        break;
                    }
//                    正常取款
                    else {
                        account.setMoney(account.getMoney() - money);
                        System.out.println("取款成功，您的账户还有余额" + account.getMoney() + "元");
                        System.out.println();
                    }
                }
            }
        }
    }

    private void depositAccount(Account account) {
//        更新余额
        System.out.println("----存款----");
        while (true) {
            System.out.println("1.存款");
            System.out.println("2.退出");
            System.out.println("请您选择选项：");
            int choice = scanner.nextInt();
            if(choice == 1) {
                System.out.println("请输入您的存款金额：");
                double amount = scanner.nextDouble();
                account.setMoney(account.getMoney() + amount);
                System.out.println("存款成功！");
                System.out.println();
            }
            else if (choice == 2) {
                break;
            }
        }
    }

    private void showAccount(Account account)
    {
        System.out.println("户主："+account.getName());
        System.out.println("账户："+account.getCard());
        System.out.println("性别："+account.getSex());
        System.out.println("余额："+account.getMoney() );
        System.out.println("取现额度："+account.getLimitMoney());
        System.out.println();
    }
}
