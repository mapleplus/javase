package com.maple.algorithms.sort;

/**
 * @author FENGXIN
 * @date 2024/6/24
 **/
public class InsertSort {
    public static void main (String[] args) {
        int[] arr = {1,45,23,25,35,46};
        insertSort(arr);
        for (int i : arr) {
            System.out.print (i + " ");
        }
    }
    public static void insertSort(int[] arr){
        //在未排序区间选择一个基准元素，将该元素与其左侧已排序区间的元素逐一比较大小，并将该元素插入到正确的位置
        // 外循环，执行的次数
        for (int i = 1 ; i < arr.length ; i++) {
            // 在未排序数据中的基准元素（待插入正确位置）
            int base = arr[i];
            int j = i - 1;
            while ( j >= 0 && base < arr[j]) {
                // arr[j]往后移动一位，为待插入元素base腾位置
                arr[j + 1] = arr[j];
                j--;
            }
            // 插入元素
            arr[j + 1] = base;
        }
    }
}
