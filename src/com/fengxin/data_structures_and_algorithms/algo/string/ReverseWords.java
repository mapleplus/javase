package com.fengxin.data_structures_and_algorithms.algo.string;

/**
 * @author FENGXIN
 * 力扣151
 **/
public class ReverseWords {
    public static void main (String[] args) {
        String s = "a good   example";
        System.out.println (reverseWords (s));
    }
    public static String reverseWords(String s) {
        char[] ch = s.toCharArray();
        StringBuilder result = new StringBuilder();
        // 先过滤前导空格
        int i = 0;
        while(ch[i] == ' '){
            i++;
        }
        StringBuilder sb = new StringBuilder();
        //添加单词 反转单词
        boolean flag = false;
        while(i < s.length()){
            while(i < s.length() && ch[i] != ' '){
                sb.append(ch[i]);
                i++;
                flag = true;
            }
            if(flag) {
                sb.append (' ');
                flag = false;
            }
            i++;
        }
        String[] str = sb.toString().split (" ");
        for(int j = 0,k = str.length - 1; j < k; j++, k--){
            String temp = str[j];
            str[j] = str[k];
            str[k] = temp;
        }
        i = 0;
        while ( i < str.length){
            result.append (str[i]);
            if(i == str.length - 1){
                break;
            }
            result.append (" ");
            i++;
        }
        return result.toString();
    }
}
