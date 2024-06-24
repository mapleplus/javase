package com.fengxin.data_structures_and_algorithms.sort;

/**
 * @author FENGXIN
 * @date 2024/6/24
 **/
public class BubbleSort {
    public static void main (String[] args) {
        int[] arr = {1,45,23,25,35,46};
        bubbleSort (arr);
        for (int i : arr) {
            System.out.print (i + " ");
        }
    }
    public static void bubbleSort(int[] arr){
        //冒泡排序
        boolean flag = false;
        for (int i = arr.length - 1 ; i > 0 ; i--) {
            for (int j = 0 ; j < i ; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                flag = true;
            }
            // 此轮“冒泡”未交换任何元素，直接跳出
            if (!flag ) {
                return;
            }
        }
    }
}
