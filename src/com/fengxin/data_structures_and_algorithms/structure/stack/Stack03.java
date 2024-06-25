package com.fengxin.data_structures_and_algorithms.structure.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FENGXIN
 **/
public class Stack03 {
    public static void main (String[] args) {
        String s = "abbaca";
        System.out.println (removeDuplicates (s));
    }
    
    public static String removeDuplicates(String s) {
        if(s.length() == 1){
            return s;
        }
        Deque<Character> stack = new LinkedList<> ();
        for(int i = 0; i < s.length(); i++){
            if(stack.isEmpty ()){
                stack.addFirst (s.charAt (i));
            }else if(stack.getFirst () == s.charAt (i)){
                stack.removeFirst ();
            }else{
                stack.addFirst (s.charAt (i));
            }
        }
        String result = "";
        while (!stack.isEmpty ()){
            result = stack.pop () + result;
        }
        return result;
    }
}
