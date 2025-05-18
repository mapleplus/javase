package com.maple.algorithms.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FENGXIN
 * @date 2024/6/25
 **/
public class SumPart {
    static List<List<Integer>> res = new ArrayList<> ();
    public static void main (String[] args) {
        // 和的所有不重复组合
        int[] nums = {3,4,5};
        int target = 9;
        sumPart(nums,target);
        System.out.println (res);
    }
    public static void sumPart(int[] nums,int target){
        // 使用start保证结果集不重复
        int start = 0;
        List<Integer> state = new ArrayList<> ();
        dfs(state,start,target,nums);
    }
    public static void dfs(List<Integer> state,int start,int target,int[] nums){
        // 结束条件
        if(target == 0){
           res.add (new ArrayList<> (state));
           return;
        }
        // 回溯
        for (int i = start ; i < nums.length ; i++) {
            // 剪枝
            if(target - nums[i] < 0){
                break;
            }
            // 做选择
            state.add (nums[i]);
            // 遍历 更新target start
            dfs (state,i,target - nums[i],nums);
            // 撤销选择
            state.remove (state.size () - 1);
        }
    }
}
