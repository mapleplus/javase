package com.maple.algorithms.string;

/**
 * @author maple
 **/
public class Kmp {
    public static void main (String[] args) {
        String s1 = "mississippi";
        String s2 = "issip";
        System.out.println (strStr (s1 , s2));
    }
    public static int strStr(String haystack, String needle) {
        if(haystack.length () < needle.length ()){
            return -1;
        }
        // 接收前缀表
        int[] next = getNext (needle);
        // 比较
        // i遍历haystack j遍历needle
        int i = 0,j = 0;
        for(;i < haystack.length ();i++){
            // 处理不匹配
            // 这时目标字符串的不匹配的字符之前的子串一定是匹配的
            // 然后寻找最长相等前后缀 后缀等于主串的紧挨着不匹配字符之前的相等长度的子串
            // 因为前缀和后缀相等
            // 找到前缀，从前缀的下一个字符开始和当前主串的不匹配字符匹配
            // 省略了不必要且不可能的情况
            // 如果不相等，则继续回退寻找最长相等前后缀的前缀下一个字符
            // 一直找到相等的末尾为止或j到达第一个位置
            while (j > 0 && haystack.charAt (i) != needle.charAt (j)){
                j = next[j - 1];
            }
            if(haystack.charAt (i) == needle.charAt (j)){
                j++;
            }
            if(j == needle.length ()){
                return i - j + 1;
            }
        }
        return -1;
    }
    // 获取next数组（前缀表）
    public static int[] getNext(String s){
        int[] next = new int[s.length ()];
        next[0] = 0;
        // 前缀末尾 还等于当前长度字符串的最大相等前后缀长度
        int i = 0;
        // 后缀末尾
        int j = 1;
        // 让后缀往后遍历
        for (; j < s.length () ; j++) {
            // 处理前后缀不相等
            while(i > 0 && s.charAt (i) != s.charAt (j)){
                // 一直找到相等的末尾为止或i到达第一个位置
                // 不相等则i回退到新的待比较位置
                i = next[i - 1];
            }
            // 处理前后缀相等
            if(s.charAt (i) == s.charAt (j)){
                i++;
            }
            // 更新next
            next[j] = i;
        }
        return next;
    }
}
