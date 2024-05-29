package com.fengxin.demo;
//生成随机验证码
import java.util.Random;
import java.util.Scanner;
/**
 * @author FENGXIN
 */
public class Random_Code {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入需要生成随机数的个数：");
            int n = sc.nextInt();
//            打印验证码
            System.out.println(code (n));
            if (n == 0) {
                break;
            }
        }
    }
    public static String code (int n){
        String code1 = "";
        String code2 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random rand = new Random();
//        截取字符 形成验证码
        for (int i = 0; i < n; i++) {
//            随机生成code_2的索引
            int r = rand.nextInt(code2.length());
//            使用索引将code_2对应的字符截取到code_1
            code1 += code2.charAt(r);
        }
        return code1;
    }
}
