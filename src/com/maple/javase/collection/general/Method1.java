package com.maple.javase.collection.general;

import java.util.*;

/**
 * @author maple
 **/
public class Method1 {
    public static void main (String[] args) {
        List<String> list = new ArrayList<> ();
        list.add ("apple");
        list.add ("pear");
        list.add ("banana");
        list.add ("orange");
        list.add ("fengxin");
        System.out.println ("原始顺序：" + list);
        //反转元素顺序
        Collections.reverse (list);
        System.out.println ("反转后的顺序：" + list);
        //随机打乱元素顺序
        Collections.shuffle (list);
        System.out.println ("打乱后的顺序：" + list);
        //对元素进行自然排序
        Collections.sort (list);
        System.out.println ("自然排序后的顺序：" + list);
        //对元素进行自定义排序
        Collections.sort (list , new Comparator<Object> () {
            @Override
            public int compare (Object o1, Object o2) {
                return ((String)o1).length () - ((String)o2).length ();
            }
        });
        System.out.println ("自定义排序后的顺序：" + list);
        //交换顺序
        Collections.swap (list,0,2);
        System.out.println ("交换后的顺序：" + list);
    }
}
