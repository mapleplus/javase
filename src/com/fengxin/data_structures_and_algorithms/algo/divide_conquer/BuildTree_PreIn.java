package com.fengxin.data_structures_and_algorithms.algo.divide_conquer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FENGXIN
 * @date 2024/6/25
 **/
public class BuildTree_PreIn {
    static public class  TreeNode{
        int val;
      TreeNode left;
      TreeNode right;
      // TreeNode() {}
      TreeNode(int val) { this.val = val; }
    }
    static void preTraverse(TreeNode root){
        // 前序遍历树
        if (root == null) {
            System.out.print ("null ");
            return;
        }
        System.out.print (root.val + " ");
        preTraverse (root.left);
        preTraverse (root.right);
    }
    public static void main (String[] args) {
        int[] pre = {3 , 9 , 2 , 1 , 7};
        int[] in = {9 , 3 , 1 , 2 , 7};
        TreeNode root = buildTree (pre,in);
        preTraverse (root);
    }
    public static TreeNode buildTree(int[] pre,int[] in){
        // map存储中序数组
        Map<Integer,Integer> treeMap = new HashMap<> ();
        for (int i = 0 ; i < in.length ; i++) {
            treeMap.put (in[i] , i);
        }
        // 构造数
        return build (pre,treeMap,0,0,in.length - 1);
    }
    public static TreeNode build(int[] pre,Map<Integer,Integer> treeMap,int i,int l,int r){
        // i 前序根节点位置|m 中序根节点位置|l~r 树 左到右 范围
        if( l > r){
            return null;
        }
        // 中序根节点
        int m = treeMap.get(pre[i]);
        // 构建根节点
        TreeNode root = new TreeNode (pre[i]);
        // 构建左、右子树
        root.left = build (pre,treeMap,i + 1,l,m - 1);
        root.right = build (pre,treeMap,i + 1 + (m - l),m + 1,r);
        // 构造完成后返回根节点
        return  root;
    }
}
