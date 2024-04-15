package DEMO;
//随机排序数字
import java.util.Random;
import java.util.Scanner;

public class Random_Sort {
    public static void main(String[] args) {
        int[] arr = new int[5];
        int countNum1,countNum2;
        int temp;
        Scanner arrNum1 = new Scanner(System.in);
        Random arrNum2 = new Random();
//        输入数据
        for (int i = 0; i < arr.length; i++) {
            System.out.println("输入一个数字：");
            countNum1 = arrNum1.nextInt();
            arr[i] = countNum1;
        }
        System.out.println("排序前：");
        for (int j : arr) {
            System.out.print(j+" ");
        }
//        随机排序
        for (int i = 0; i < arr.length; i++) {
            countNum2 = arrNum2.nextInt(arr.length);
            temp = arr[countNum2];
            arr[countNum2] = arr[i];
            arr[i] = temp;
        }
//        打印结果
        System.out.println();
        System.out.println("随机排序后：");
        for (int j : arr) {
            System.out.print(j+" ");
        }
    }
}
