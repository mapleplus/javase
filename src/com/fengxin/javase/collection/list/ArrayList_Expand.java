package com.fengxin.javase.collection.list;

import java.util.ArrayList;

/**
 * @author FENGXIN
 * 数组的扩容机制
 **/
public class ArrayList_Expand {
    public static void main (String[] args) {
        //无参构造方法创建ArrayList
        ArrayList<Integer> arrayList1 = new ArrayList<> ();
        for (int i = 0; i < 10; i++){
            arrayList1.add (i);
        }
        System.out.println ("arrayList1: " + arrayList1);
        
        //指定初始容量构造方法创建ArrayList
        ArrayList<Integer> arrayList2 = new ArrayList<> (8);
        for (int i = 0; i < 10; i++){
            arrayList2.add (i);
        }
        System.out.println ("arrayList2: " + arrayList2);
    }
}
