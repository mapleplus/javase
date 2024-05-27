package com.fengxin.basic.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author FENGXIN
 * Set接口的常用方法
 **/
public class Set_Methods {
    public static void main (String[] args) {
        Set<String> set = new HashSet<> ();
        // 添加元素
        set.add ("元素1");
        set.add ("元素2");
        set.add ("元素2");
        set.add ("元素3");
        set.add (null);
        Iterator iterator = set.iterator ();
        // 通过迭代器
        while(iterator.hasNext ()){
            System.out.println (iterator.next ());
        }
        System.out.println ();
        //  通过增强for
        for (Object obj : set){
            System.out.println (obj);
        }
    }
}
