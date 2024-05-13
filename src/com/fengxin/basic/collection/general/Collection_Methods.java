package com.fengxin.basic.collection.general;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@SuppressWarnings ("all")
/**
 * @author FENGXIN
 * @data 2024.5.3
 **/
public class Collection_Methods {
    public static void main (String[] args) {
        Collection collection = new ArrayList ();
        
        // add(E e)
        collection.add (true);
        collection.add ("fengxin");
        collection.add (100);
        collection.add (new Integer (10));
        System.out.println ("collection.add(): " + collection);
        
        //remove(Object o)
        collection.remove (true);
        // collection.remove (1);//Collection删除不了指定下标的元素
        System.out.println ("collection.remove (true): " + collection);
        
        //判空
        System.out.println ("collection.isEmpty(): " + collection.isEmpty ());
        //返回元素个数
        System.out.println ("collection.size():" + collection.size ());
        //清空集合
        collection.clear ();
        System.out.println ("collection.clear(): " + collection);
        
        collection.add (true);
        collection.add ("fengxin");
        collection.add (100);
        collection.add (new Integer (10));
        //判断集合是否包含指定元素
        System.out.println ("collection.contains (true):" +collection.contains (true));
        List list = new ArrayList ();
        list.add (true);
        list.add ("fengxin");
        list.add (100);
        list.add (new Integer (10));
        // list.remove (0);//List可以删除指定下标的元素
        System.out.println ("list:" + list);
        
        //判断集合是否包含多个元素
        System.out.println ("collection.containsAll (list):" + collection.containsAll (list));
        
        //删除多个元素
        System.out.println (collection.removeAll (list));
        System.out.println ("collection.removeAll (list):" + collection);
    }
    
}
