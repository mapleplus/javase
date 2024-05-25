package com.fengxin.data_structures_and_algorithms.queue;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FENGXIN
 **/
public class Queue02 {
    public static void main (String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        for (int re : res) {
            System.out.print (re + " ");
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Myqueue queue = new Myqueue();
        int j = 0;
        int[] res = new int[nums.length - k + 1];
        // 把前三个元素放入窗口
        for(int i = 0; i < k; i++){
            queue.add(nums[i]);
        }
        // 记录第一个最大值
        res[j++] = queue.getMax();
        // 移动窗口，剔除第一个元素，加入下一个元素到末尾
        for(int i = k; i < nums.length; i++){
            // 如果有nums的窗口第一个元素，则剔除（队列第一个元素现在是最大值了）
            queue.pop(nums[i - k]);
            // 添加下一个元素到末尾
            queue.add(nums[i]);
            // 记录最大值
            res[j++] = queue.getMax();
        }
        return res;
    }
}

// 定义队列
class Myqueue{
    Deque<Integer> queue = new LinkedList<> ();
    // 如果有nums的窗口第一个元素，则剔除（第一个元素现在是最大值了）
    public void pop(int val){
        if(!queue.isEmpty() && queue.getFirst() == val){
            queue.removeFirst();
        }
    }
    public void add(int val){
        // 为了使第一个队列元素为最大值，单调递减
        // 故如果待添加元素大于末尾元素，则剔除末尾元素，直到末尾元素大于待添加元素
        // 或者queue为空 再添加元素
        while(!queue.isEmpty() && queue.getLast() < val){
            queue.removeLast();
        }
        queue.addLast(val);
    }
    public int getMax(){
        return queue.getFirst();
    }
}