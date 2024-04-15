package DEMO;
//猜数字游戏
import java.util.Random;
import java.util.Scanner;

public class Random_Test {
    public static void main(String[] args) {
//        生成随机数
        Random numValue1 = new Random();
        int num1 = numValue1.nextInt(100) + 1;
//        获取用户输入的数据
        Scanner numCount = new Scanner(System.in);
        while (true)
        {
            System.out.println("输入一个整数：");
            int numTest = numCount.nextInt();
            if(numTest < num1)
            {
                System.out.println("您输入的数偏小！");
            } else if (numTest > num1) {
                System.out.println("您输入的数偏大！");

            } else {
                System.out.println("猜对了！");
                break;
            }
        }
    }
}
