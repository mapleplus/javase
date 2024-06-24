package com.fengxin.data_structures_and_algorithms.sort;

/**
 * @author FENGXIN
 * @date 2024/6/24
 **/
public class SelectSort {
    public static void main (String[] args) {
        int[] arr = {1,45,23,25,35,46};
        selectSort (arr);
        for (int i : arr) {
            System.out.print (i + " ");
        }
    }
    public static void selectSort(int[] arr){
        // 开启一个循环，每轮从未排序区间选择最小的元素，将其放到已排序区间的首位
        int i,j,k;
        // 外循环遍历未排序的数据
        for ( i = 0 ; i < arr.length ; i++) {
            k = i;
            // 寻找未排序元素的最小值
            for ( j = k + 1 ; j < arr.length ; j++) {
                if(arr[k] > arr[j]){
                    //记录未排序元素的最小值索引
                    k = j;
                }
            }
            // 将该最小元素与未排序区间的首个元素交换
            int temp = arr[k];
            arr[k] = arr[i];
            arr[i] = temp;
        }
    }
}
