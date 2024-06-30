package com.fengxin.data_structures_and_algorithms.algo.dp;

/**
 * @author FENGXIN
 * @date 2024/6/26
 **/
public class MaxPublicSub {
    public static void main (String[] args) {
        // 最长公共子序列
        String s1 = "abcde";
        String s2 = "ace";
        System.out.println (dp (s1 , s2));
    }
    public static int dp(String s1,String s2){
        // dp定义为最大公共子序列长度
        int[][] dp = new int[s1.length () + 1][s2.length () + 1];
        for (int i = 1 ; i <= s1.length () ; i++) {
            for (int j = 1 ; j <= s2.length () ; j++) {
                char c1 = s1.charAt (i - 1),c2 = s2.charAt (j - 1);
                if(c1 == c2){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max (dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }
        for (int i = 0 ; i <= s1.length () ; i++) {
            for (int j = 0 ; j <= s2.length () ; j++) {
                System.out.print (dp[i][j] + " ");
            }
            System.out.println ();
        }
        return dp[s1.length ()][s2.length ()];
    }
    
}
