package com.maple.algorithms.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maple
 **/
public class Permute {
    static List<List<Integer>> res = new ArrayList<> ();
    public static void main (String[] args) {
        // 全排列
        int[] nums = {1, 2, 3};
        List<Integer> state = new ArrayList<> ();
        boolean[] selected = new boolean[nums.length];
        for (int i = 0 ; i < nums.length ; i++) {
            selected[i] = false;
        }
        permute(nums,state,selected);
        System.out.println (res);
    }
    public static void permute(int[] num,List<Integer> state,boolean[] selected){
        // 结束条件 排列完全
        if(state.size () == num.length){
            res.add (new ArrayList<> (state));
            return;
        }
        // 排列
        for (int i = 0; i < num.length;i++) {
            if(selected[i]){
                continue;
            }
            // 做选择，添加排列组合
            state.add (num[i]);
            selected[i] = true;
            // 遍历搜索
            permute (num,state,selected);
            // 撤销选择
            state.remove (state.size() - 1);
            selected[i] = false;
        }
    }
}
