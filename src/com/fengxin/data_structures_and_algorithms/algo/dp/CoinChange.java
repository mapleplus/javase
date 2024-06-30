package com.fengxin.data_structures_and_algorithms.algo.dp;

import java.util.Arrays;

/**
 * @author FENGXIN
 * @date 2024/6/25
 **/
public class CoinChange {
    public static void main (String[] args) {
        // 零钱兑换
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println (coinChange2 (coins , amount));
    }
    static int[] memo;
    public static int coinChange1(int[] coins,int amount){
        // 使用备忘录
        memo = new int[amount + 1];
        Arrays.fill (memo,-666);
        return dp (coins,amount);
    }
    public static int dp(int[] coins,int amount){
        if( amount == 0){
            return 0;
        }
        if ( amount < 0) {
            return -1;
        }
        // 去重
        if(memo[amount] != -666){
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题结果
            int sub = dp (coins,amount - coin);
            // 子问题无解则跳过
            if(sub == -1){
                continue;
            }
            // 在子问题中选择最优解，然后加一
            res = Math.min (res,sub + 1);
        }
        // 记录子问题的结果
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }
    public static int coinChange2(int[] coins,int amount){
        // 使用dp数组迭代
        int[] dp = new int[amount + 1];
        // 初始化为不可能金额
        Arrays.fill (dp,amount + 1);
        dp[0] = 0;
        int res = Integer.MAX_VALUE;
        // 外层循环求解所有金额的硬币数
        for (int i = 0 ; i < dp.length ; i++) {
            // 内层循环求解当前金额所需硬币数
            for (int coin : coins) {
                // 子问题无解就跳过 剪枝
                if(i - coin < 0){
                    continue;
                }
                
                dp[i] = Math.min (res, 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
