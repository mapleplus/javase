package com.fengxin.data_structures_and_algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * @author FENGXIN
 **/

public class Solution {
    public static void main (String[] args) {
        int n = 11;
        System.out.println (findNthNumber (n));
    }
    public static boolean findNthNumber(int n) {
        // 需要判断该次计算的结果是否在之前出现过（哈希表实现）
        Set<Integer> set = new HashSet<> ();
        while(true){
            //n在之前没有出现过
            while(n != 1 && !set.contains(n)){
                set.add(n);
                int num;
                int cal = 0;
                while(n != 0){
                    num = n % 10;
                    cal += num * num;
                    n /= 10;
                }
                n = cal;
                if (cal == 1) {
                    break;
                }
            }
            return n == 1;
        }
    }
    
}



