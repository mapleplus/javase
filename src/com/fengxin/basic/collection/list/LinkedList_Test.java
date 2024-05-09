package com.fengxin.basic.collection.list;

import java.util.LinkedList;

/**
 * @author FENGXIN
 * @data 2024.5.4
 **/
public class LinkedList_Test {
    public static void main (String[] args) {
        LinkedList list = new LinkedList();
        list.add ("apple");
        list.add ("banana");
        list.add (2);
        
        System.out.println (list);
        list.remove ();
        list.remove ("banana");
        
        System.out.println (list);
    }
    
}
