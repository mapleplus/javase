package com.fengxin.data_structures_and_algorithms.string;

/**
 * @author FENGXIN
 * 力扣459
 **/
public class Repeat {
    public static void main (String[] args) {
        System.out.println (repeatedSubstringPattern ("abab"));
        System.out.println (repeatedSubstringPattern ("abcabcabcabc"));
        System.out.println (repeatedSubstringPattern ("abcabcabc"));
        System.out.println (repeatedSubstringPattern ("a"));
        System.out.println (repeatedSubstringPattern ("bb"));
    }
    public static boolean repeatedSubstringPattern(String s) {
        int[] next = getNext (s);
        // 获取重复子串的长度
        // 存在重复子串，则重复子串 == s的最长相等前后缀的不包含子串
        // 长度为s.length() - next[s.length() - 1]
        // next[s.length() - 1]为s的最长相等前后缀的长度
        // 重复子串不包含在相等前后缀里，故从 重复子串的下一个字符 开始和 重复子串的第一个字符
        // 开始有相等前后缀，从这里前后缀的长度依次递增
        int repeatLen = s.length () - next[s.length () - 1];
        return next[s.length () - 1] != 0 && s.length () % repeatLen == 0;
    }
    //next数组 没有相等前后缀则表示为0（即按照实际相等长度表示）
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
