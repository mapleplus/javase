package com.fengxin.data_structures_and_algorithms;



/**
 * @author FENGXIN
 **/

public class Solution {
    public static void main (String[] args) {
        String s1 = "abacababacab";
        System.out.println (repeatedSubstringPattern (s1));
    }
    public static boolean repeatedSubstringPattern(String s) {
        int[] next = getNext (s);
        int repeatLen = s.length () - next[s.length () - 1];
        return next[s.length () - 1] != 0 && s.length () % repeatLen == 0;
    }
    //next数组
    public static int[] getNext(String s){
        int[] next = new int[s.length ()];
        next[0] = 0;
        // 前缀末尾
        int i = 0;
        // 后缀末尾
        int j = 1;
        // 遍历后缀
        for(; j < s.length (); j++){
            while(i > 0 && s.charAt (i) != s.charAt (j)){
                i = next[i - 1];
            }
            if(s.charAt (i) == s.charAt (j)){
                i++;
            }
            next[j] = i;
        }
        return next;
    }
}



