package DEMO;
//登录密码小DEMO
import java.util.Scanner;

public class Login_test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        只允许3次
        for (int i = 0;i < 3;i++) {
            System.out.println("Enter your username: ");
            String username = sc.nextLine();
            System.out.println("Enter your password: ");
            String password = sc.nextLine();
//            判断是否登录成功 登录成功即退出判断
            if (Judge(username,password)) {
                System.out.println("Right!");
                break;
            }
            else {
                System.out.println("Wrong!");
            }
        }
    }
//  判断用户名和密码是否匹配
    public static boolean Judge(String username, String password) {
        String okUsername = "FENGXIN";
        String okPassword = "000000";
        return (username.equals(okUsername) && password.equals(okPassword));
    }
}
