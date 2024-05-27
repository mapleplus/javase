package com.fengxin.javase.wrapper;

import java.util.Arrays;

/**
 * @author FENGXIN
 **/
public class System_Methods {
    public static void main (String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = new int[arr1.length];
        // 复制数组
        System.arraycopy(arr1, 0, arr2, 0, arr1.length);
        // 形参:
        // src the source array.
        // srcPos – starting position in the source array.
        // dest – the destination array.
        // destPos – starting position in the destination data.properties.
        // length – the number of array elements to be copied.
        // 输出复制后的数组
        System.out.println (Arrays.toString(arr2));
    }
}
