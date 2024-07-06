package com.fengxin.data_structures_and_algorithms.algo.divide_conquer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FENGXIN
 * @date 2024/6/25
 **/
public class Hanota {
    public static void main (String[] args) {
        List<Integer> src = new ArrayList<> ();
        List<Integer> buffer = new ArrayList<> ();
        List<Integer> target = new ArrayList<> ();
        // 小盘子在上
        for (int i = 3 ; i > 0 ; i--) {
            src.add (i);
        }
        solveHanota (src.size (),src,buffer,target);
    }
    public static void solveHanota(int num,List<Integer> src,List<Integer> buffer,List<Integer> target){
        // 如果只有一个盘子，直接移动到目标柱
        if (num == 1){
            move (src,target);
            return;
        }
        // 将 src 顶部 i-1 个圆盘借助 tar 移到 buf
        solveHanota (num - 1,src,target,buffer);
        // 将 src 剩余一个圆盘移到 tar
        move (src,target);
        // 将 buf 顶部 i-1 个圆盘借助 src 移到 tar
        solveHanota (num - 1,buffer,src,target);
    }
    public static void move(List<Integer> src,List<Integer> target){
        System.out.println ("move " + src.getLast () + " from " + src + " to " + target);
        Integer buf = src.removeLast ();
        target.addLast (buf);
    }
}
