package com.maple.se.wrapper;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author maple
 * 使用冒泡排序实现定制排序
 **/
public class ArraysDefineSort {
    public static void main (String[] args) {
        int[] arr = {5, 2, 1, 4, 3};
        // 使用匿名内部类实现Comparator接口
        // 这里以升序为例，即小的数在前
        defineSort (arr , new Comparator () {
            // 重写compare方法，实现自定义排序规则
            @Override
            // 传入两个arr数组参数，返回一个整数，表示比较结果
            public int compare (Object o1 , Object o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                // 返回负数表示o1<o2，返回正数表示o1>o2，返回0表示o1 == o2
                return i1 - i2;
            }
        });
        System.out.println (Arrays.toString (arr));
    }
    public static void defineSort(int[] arr, Comparator c) {
        for (int i = 0 ; i < arr.length - 1 ; i++) {
            for (int j = 0 ; j < arr.length - 1 - i ; j++) {
                // 使用Comparator接口的compare方法进行比较
                // 如果返回正数，表示o1>o2,则交换两个数的位置,这里以升序为例，即小的数在前
                // 如果返回负数，表示o1<o2,则不交换位置
                // 如果返回0，表示o1 == o2,则不交换位置
                if (c.compare (arr[j] , arr[j + 1]) > 0) {
                    // 根据传入的匿名接口调用其重写的compare方法
                    // 根据compare返回的结果判断是否进行交换
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
