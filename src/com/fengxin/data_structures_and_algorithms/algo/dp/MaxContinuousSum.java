package com.fengxin.data_structures_and_algorithms.algo.dp;

import java.util.Arrays;

/**
 * @author FENGXIN
 * @date 2024/6/26
 **/
public class MaxContinuousSum {
    public static void main (String[] args) {
        // 最大连续子序列和
        int[] nums = {-2,11,-4,13,-5,-2};
        System.out.println (maxSum (nums));
    }
    public static int maxSum(int[] nums){
        int[] dp = new int[nums.length];
        Arrays.fill (dp,0);
        for (int i = 1 ; i < nums.length; i++) {
            dp[i] = Math.max (dp[i],dp[i - 1] + nums[i]);
        }
        int res = 0;
        for (int i : dp) {
            res = Math.max (res,i);
            System.out.print (i + " ");
        }
        System.out.println ();
        return res;
    }
}
