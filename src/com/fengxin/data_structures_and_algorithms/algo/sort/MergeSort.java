package com.fengxin.data_structures_and_algorithms.algo.sort;

/**
 * @author FENGXIN
 * @date 2024/6/24
 **/
public class MergeSort {
    public static void main (String[] args) {
        // 二分归并排序
        int[] arr = {2,4,1,0,3,5};
        mergeSort (arr,0, arr.length - 1);
        for (int i : arr) {
            System.out.print (i + " ");
        }
    }
    public static void mergeSort(int[] arr,int left,int right){
        // 当子数组长度为 1 时终止递归
        if(left >= right) {
            return;
        }
        // 递归到单个数组
        int mid = (left + right) / 2;
        mergeSort (arr,left,mid);
        mergeSort (arr,mid + 1,right);
        // 有序合并数组
        merge (arr,left,mid,right);
    }
    public static void merge(int[] arr,int left,int mid,int right){
        // 临时数组，存放合并的临时数据
        int[] temp = new int[right - left + 1];
        // 左数组left~mid 右数组mid+1~right
        int i = left,j = mid + 1,k = 0;
        while ( i <= mid && j <= right) {
            // 将数据有序合并到临时数组（升序）
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }
        // 合并完左数组或右数组后
        // or将左数组剩余的数据合并
        while ( i <= mid){
            temp[k++] = arr[i++];
        }
        // or将右数组剩余的数据合并
        while ( j <= right){
            temp[k++] = arr[j++];
        }
        // 将合并完的数据复制到arr对应区间
        for( k = 0; k < temp.length; k++){
            arr[left + k] = temp[k];
        }
    }
}
