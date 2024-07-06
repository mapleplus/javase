package com.fengxin.data_structures_and_algorithms.algo.dp;

/**
 * @author FENGXIN
 * @date 2024/6/26
 **/
public class KnapsackDP {
    public static void main (String[] args) {
        // 0-1背包问题 动态规划解决
        int[] wgt = {1,2,3};
        int[] val = {5,11,15};
        int cap = 4;
        System.out.println (dp (wgt , val,cap));
    }
    public static int dp(int[] wgt,int[] val,int cap){
        int n = wgt.length;
        // dp定义为物品和背包容量 值为价值
        int[][] dp = new int[n + 1][cap + 1];
        
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= cap ; j++) {
                // 剪枝 物品重量超过背包容量
                if (wgt[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max (dp[i - 1][j] , dp[i - 1][j - wgt[i - 1]] + val[i - 1]);
                }
            }
        }
        // 打印dp
        for (int i = 0 ; i <= n ; i++) {
            for (int j = 0 ; j <= cap ; j++) {
                System.out.print (dp[i][j] + " ");
            }
            System.out.println ();
        }
        return dp[n][cap];
    }
}
