package com.fengxin.basic.wrapper;

import java.util.Arrays;

/**
 * @author FENGXIN
 **/
public class Arrays_Methods {
    public static void main (String[] args) {
        // 创建一个整数数组
        int[] intArray = {5, 2, 1, 4, 3};

        // 使用Arrays.toString方法打印数组内容
        System.out.println("intArray: " + Arrays.toString(intArray));

        // 使用Arrays.sort方法对数组进行排序
        Arrays.sort(intArray);
        System.out.println("Sorted intArray: " + Arrays.toString(intArray));

        // 使用Arrays.binarySearch方法对排序后的数据进行二分查找
        int searchKey1 = 3;
        int searchKey2 = 6;
        int searchKey3 = -6;
        int index1 = Arrays.binarySearch(intArray, searchKey1);
        int index2 = Arrays.binarySearch(intArray, searchKey2);
        int index3 = Arrays.binarySearch(intArray, searchKey3);
        // 打印查找结果
        System.out.println ("index = " + index1);
        //index2 = -(low + 1),low此时为5
        System.out.println ("index = " + index2);
        //index2 = -(low + 1),low此时为0
        System.out.println ("index = " + index3);
        
        // 使用Arrays.equals方法比较两个数组是否相等
        int[] intArray2 = {1, 2, 3, 4, 5};
        System.out.println("intArray equals intArray2: " + Arrays.equals(intArray, intArray2));
        
        // 使用Arrays.fill方法填充数组
        Arrays.fill (intArray, 0, 3, 10);
        System.out.println("intArray after fill: " + Arrays.toString(intArray));
        // 或者
        Arrays.fill (intArray, 10);
        System.out.println("intArray after fill: " + Arrays.toString(intArray));
    }
}
