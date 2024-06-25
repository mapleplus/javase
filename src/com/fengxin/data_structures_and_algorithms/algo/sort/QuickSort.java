package com.fengxin.data_structures_and_algorithms.algo.sort;

/**
 * @author FENGXIN
 * @date 2024/6/24
 **/
public class QuickSort {
    public static void main (String[] args) {
        int[] arr = {2,4,1,0,3,5};
        quickSort (arr,0, arr.length - 1);
        for (int i : arr) {
            System.out.print (i + " ");
        }
    }
    
    /**
     * 分割数组，设置基准，左边比基准小，右边比基准大
     */
    public static void swap(int[] arr,int left,int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    public static int midNumber(int[] arr,int left,int mid,int right ){
        int l = arr[left],m = arr[mid],r = arr[right];
        // m 在 l 和 r 之间
        if( l <= m && m <= r || r <= m && m <= l) {
            return (left + right) / 2;
        }
        // l 在 m 和 r 之间
        if ( m <= l && l <= r || r <= l && l <= m) {
            return left;
        }
        return right;
    }
    public static int part(int[] arr,int left,int right){
        // 寻找左端，中端，右端的中间数
        // 设置基准数arr[left],将基准数交换到最左端开始分割数组
        int base = midNumber (arr,left,(left + right) / 2,right);
        swap (arr,left,base);
        int i = left,j = right;
        while ( i < j ) {
            // 从右向左寻找第一个小于基准的数
            while (i < j && arr[j] >= arr[left]) {
                j--;
            }
            // 从左向右寻找第一个大于基准的数
            while (i < j && arr[i] <= arr[left]) {
                i++;
            }
            // 交换两个数
            swap (arr,i,j);
        }
        // 将基准插入到两个数组的交界
        swap (arr,i,base);
        return i;
    }
    /**
     * 使用快速排序对数组排序（递归）
     * 快速排序的核心操作是“哨兵划分”，
     * 其目标是：选择数组中的某个元素作为“基准数”
     * 将所有小于基准数的元素移到其左侧，而大于基准数的元素移到其右侧
     */
    public static void quickSort(int[] arr,int left,int right){
        if(left >= right){
            return;
        }
        // 设置哨兵
        int position = part (arr,left,right);
        // 递归左子数组、右子数组 直到只有一个字数组则排序完成
        quickSort (arr , left , position - 1);
        quickSort (arr , position + 1 , right);
    }
}