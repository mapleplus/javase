package com.fengxin.basic.collection.map;

import java.util.*;

/**
 * @author FENGXIN
 * @data 2024.5.6
 * 集合都有两种遍历方式 for each 和 iterator
 **/
@SuppressWarnings ("all")
public class Map04_Traverse {
    public static void main (String[] args) {
        Map map = new HashMap ();
        for (int i = 1 ; i < 6 ; i++) {
            map.put ("key" + i, "value" + i);
        }
        System.out.println ("--------------Traverse Map01--------------------");
    //     使用keySet遍历
    //     增强for循环
        Set keyset = map.keySet ();//取出的是key
        for(Object key : keyset){
            System.out.println ("key: " + key + " value: " + map.get (key));
        }
    //     iterator
        Iterator iterator1 = keyset.iterator ();//取出的是key
        while (iterator1.hasNext ()){
            Object key = iterator1.next ();//取出的是key
            System.out.println ("key: " + key + " value: " + map.get (key));
        }
        
        System.out.println ("--------------Traverse Map02--------------------");
    //     使用values遍历
        Collection values = map.values ();
    //     增强for循环
        for(Object value : values){
            System.out.println ("value: " + value);
        }
    //     iterator
        Iterator iterator2 = values.iterator ();
        while (iterator2.hasNext ()){
            Object value = iterator2.next ();
            System.out.println ("value: " + value);
        }
        
        System.out.println ("--------------Traverse Map03--------------------");
    //     使用entrySet遍历
        Set entryset = map.entrySet ();//取出的是entry
        System.out.println (entryset.getClass ());
        //     增强for循环
        for(Object o : entryset){
            Map.Entry entry = (Map.Entry) o;//取出的是Entry，但实际运行类型是Node
            System.out.println ("key: " + entry.getKey () + " value: " + entry.getValue () );
        }
    //     iterator
        Iterator iterator3 = entryset.iterator ();
        // System.out.println (iterator3.next ().getClass ());
        while (iterator3.hasNext ()){
            Map.Entry entry = (Map.Entry) iterator3.next ();
            System.out.println ("key: " + entry.getKey () + " value: " + entry.getValue () );
        }
    }
}
