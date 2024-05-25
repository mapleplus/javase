package com.fengxin.data_structures_and_algorithms.array_linked;

<<<<<<< HEAD
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
=======
/**]
 * @author FENGXIN
 * 数组的相关操作
 **/
public class Array {
    public static void main (String[] args) {
        int[] arr = new int [10];
//        数组赋值
        for(int i = 0;i < 9; i++)
        {
            arr[i] = i;
        }
        arrInsert (arr, 5, 10);
        arrTraverse (arr);
        arrInsert (arr, 5, 11);
        arrTraverse (arr);
        arrDelete (arr, 5);
        arrTraverse (arr);
    }
    public static boolean isEmpty(int[] arr) {
        return arr.length == 0;
    }
//    查找指定位置的数据
    public static int arrSearch(int[] arr, int target) {
//        判空
        if(!isEmpty(arr)){
        for (int i = 0 ; i < arr.length ; i++) {
            if (i == target) {
                return arr[target];
            }
        }
        return -1;
        }
        else{
            return -1;
        }
    }
//    数组扩容
    public static int[] arrExpansion(int[] arr, int newSize) {
        if(!isEmpty (arr)){
            int[] arrNew = new int[newSize];
            for (int i = 0 ; i < arr.length ; i++) {
>>>>>>> de0b9a14d87dd28837984e4f7362ddb53226226d
                arrNew[i] = arr[i];
            }
            return arrNew;
        }
<<<<<<< HEAD
        return null;
    }

    // 在指定位置插入数据
    public static boolean arrInsert(int[] arr, int index, int value) {
        if (!isEmpty(arr)) {
            // 先将index及之后的元素整体向后移动一位
            for (int i = arr.length - 1; i > index; i--) {
                arr[i] = arr[i - 1];
=======
        return null;}
//    在指定位置插入数据
    public static boolean arrInsert(int[] arr, int index, int value) {
        if(!isEmpty (arr)){
//            先将index及之后的元素整体向后移动一位
            for (int i = arr.length - 1; i > index ; i--) {
                arr[i] = arr[i-1];
>>>>>>> de0b9a14d87dd28837984e4f7362ddb53226226d
            }
            arr[index] = value;
            return true;
        }
        return false;
    }
<<<<<<< HEAD

    // 删除指定位置的数据
    public static boolean arrDelete(int[] arr, int index) {
        if (!isEmpty(arr)) {
            // 先将index之后的元素整体向前移动一位
            for (int i = index; i < arr.length - 1; i++) {
=======
//    删除指定位置的数据
    public static boolean arrDelete(int[] arr, int index) {
        if(!isEmpty (arr)){
//            先将index之后的元素整体向前移动一位
            for (int i = index ; i < arr.length - 1; i++) {
>>>>>>> de0b9a14d87dd28837984e4f7362ddb53226226d
                arr[i] = arr[i + 1];
            }
            return true;
        }
        return false;
    }
<<<<<<< HEAD

    // 查找指定数据的位置
    public static int arrFind(int[] arr, int value) {
        if (!isEmpty(arr)) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == value) {
=======
//    查找指定数据的位置
    public static int arrFind(int[] arr, int value) {
        if(!isEmpty (arr)){
            for (int i = 0 ; i < arr.length ; i++) {
                if(arr[i] == value) {
>>>>>>> de0b9a14d87dd28837984e4f7362ddb53226226d
                    return i;
                }
            }
        }
        return -1;
    }
<<<<<<< HEAD

    // 数组遍历
    public static void arrTraverse(int[] arr) {
        if (!isEmpty(arr)) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
=======
//    数组遍历
    public static void arrTraverse(int[] arr) {
        if(!isEmpty (arr)){
            for (int i = 0 ; i < arr.length ; i++) {
                System.out.print (arr[i]+ " ");
            }
            System.out.println ();
>>>>>>> de0b9a14d87dd28837984e4f7362ddb53226226d
        }
    }
}
