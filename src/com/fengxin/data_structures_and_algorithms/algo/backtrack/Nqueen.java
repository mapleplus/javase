package com.fengxin.data_structures_and_algorithms.algo.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author FENGXIN
 * @date 2024/6/25
 **/
public class Nqueen {
    static List<List<String>> res = new ArrayList<> ();
    public static void main (String[] args) {
        // N皇后
        int n;
        Scanner scanner = new Scanner (System.in);
        n = scanner.nextInt ();
        solveNqueen (n);
        System.out.println (res);
    }
    public static void solveNqueen(int n){
        List<String> state = new ArrayList<> ();
        // 对棋盘初始化，Q表示皇后，“.”表示空
        for (int i = 0 ; i < n ; i++) {
            state.add (".".repeat (n));
        }
        // 放置皇后
        dfs (state,0);
    }
    public static void dfs(List<String> state,int row){
        // 结束条件 全部行处理完成后
        if (state.size () == row) {
            res.add (new ArrayList<> (state));
            return;
        }
        // 处理选择 每一行中的每一列都是选择
        for (int col = 0 ; col < state.get (row).length () ; col++) {
            // 判断是否符合添加皇后条件 剪枝
            if(!valid(state,row,col)){
                continue;
            }
            // 做选择
            StringBuilder strPre = new StringBuilder (state.get (row));
            strPre.setCharAt (col,'Q');
            state.set(row,strPre.toString ());
            // 继续递归处理
            dfs (state,row + 1);
            // 撤销选择
            StringBuilder strEnd = new StringBuilder (state.get (row));
            strEnd.setCharAt (col,'.');
            state.set (row,strEnd.toString ());
        }
    }
    public static boolean valid(List<String> state, int row, int col){
        int i,j;
        // 处理小于row的皇后冲突
        // 处理皇后直接冲突（列）
        for (i = 0 ; i < state.size () ; i++) {
            if (state.get (i).charAt (col) == 'Q') {
                return false;
            }
        }
        // 检查左上方是否有皇后冲突
        for(i = row - 1,j = col - 1;i >= 0 && j >= 0;i--,j--){
            if(state.get (i).charAt (j) == 'Q'){
                return false;
            }
        }
        // 检查右上方是否有皇后冲突
        for(i = row - 1,j = col + 1;i >= 0 && j < state.size ();i--,j++){
            if(state.get (i).charAt (j) == 'Q'){
                return false;
            }
        }
        return true;
    }
}
