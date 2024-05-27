package com.fengxin.data_structures_and_algorithms.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FENGXIN
 **/
public class Stack02 {
    public static void main (String[] args) {
        String s = "()";
        System.out.println (test1 (s));
    }
    public static boolean test1 (String s){
         // 奇数一定不匹配
        if(s.length() % 2 != 0){
            return false;
        }
        Deque<Character> stack = new LinkedList<> ();
        char ch;
        for(int i = 0; i < s.length(); i++){
            ch = s.charAt (i);
            // 左括号入栈
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }else{
                if(stack.isEmpty ()){
                    return false;
                }
            else if(ch == ')'){
                if(stack.peekFirst () == '('){
                    stack.pop();
                }else{
                    return false;
                }
            }else if(ch == ']'){
                if(stack.peekFirst () == '['){
                    stack.pop();
                }else{
                    return false;
                }
            }else if(ch == '}'){
                if(stack.peekFirst () == '{'){
                    stack.pop();
                }else{
                    return false;
                }
            }
            }
        }
        return stack.isEmpty ();
    }
}
