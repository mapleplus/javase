package com.maple.algorithms.dp;

import java.util.Arrays;

/**
 * @author FENGXIN
 * @date 2024/6/26
 **/
public class MaxIncreaseSub {
    public static void main (String[] args) {
        // 最长递增子序列
        int[] nums = {1,4,3,4,2,3};
        System.out.println (dp (nums));
    }
    public static int dp(int[] nums){
        // dp数组定义为截止当前元素的最长递增序列大小
        int[] dp = new int[nums.length];
        // 每个元素递增序列大小至少为1
        Arrays.fill (dp,1);
        // 截止当前i位置的元素
        for (int i = 0 ; i < nums.length ; i++) {
            // 找出比当前元素小的数据，得出当前元素为尾的最大递增序列
            for (int j = 0 ; j < i ; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max (dp[i],dp[j] + 1);
                }
            }
        }
        // 遍历出最大结果
        int res = 1;
        for (int i : dp) {
            res = Math.max (res,i);
            System.out.print (i + " ");
        }
        System.out.println ();
        return res;
    }
}
