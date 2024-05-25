package com.fengxin.data_structures_and_algorithms.array_linked;

/**
 * ]
 * 
 * @author FENGXIN
 *         数组的相关操作
 **/
public class Array {
    public static void main(String[] args) {
        int[] arr = new int[10];
        // 数组赋值
        for (int i = 0; i < 9; i++) {
            arr[i] = i;
        }
        arrInsert(arr, 5, 10);
        arrTraverse(arr);
        arrInsert(arr, 5, 11);
        arrTraverse(arr);
        arrDelete(arr, 5);
        arrTraverse(arr);
    }

    public static boolean isEmpty(int[] arr) {
        return arr.length == 0;
    }

    // 查找指定位置的数据
    public static int arrSearch(int[] arr, int target) {
        // 判空
        if (!isEmpty(arr)) {
            for (int i = 0; i < arr.length; i++) {
                if (i == target) {
                    return arr[target];
                }
            }
            return -1;
        } else {
            return -1;
        }
    }

    // 数组扩容
    public static int[] arrExpansion(int[] arr, int newSize) {
        if (!isEmpty(arr)) {
            int[] arrNew = new int[newSize];
            for (int i = 0; i < arr.length; i++) {
                arrNew[i] = arr[i];
            }
            return arrNew;
        }
        return null;
    }

    // 在指定位置插入数据
    public static boolean arrInsert(int[] arr, int index, int value) {
        if (!isEmpty(arr)) {
            // 先将index及之后的元素整体向后移动一位
            for (int i = arr.length - 1; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = value;
            return true;
        }
        return false;
    }

    // 删除指定位置的数据
    public static boolean arrDelete(int[] arr, int index) {
        if (!isEmpty(arr)) {
            // 先将index之后的元素整体向前移动一位
            for (int i = index; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            return true;
        }
        return false;
    }

    // 查找指定数据的位置
    public static int arrFind(int[] arr, int value) {
        if (!isEmpty(arr)) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == value) {
                    return i;
                }
            }
        }
        return -1;
    }

    // 数组遍历
    public static void arrTraverse(int[] arr) {
        if (!isEmpty(arr)) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
