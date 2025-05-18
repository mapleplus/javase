package com.maple.se.collection.general;

import java.util.*;

/**
 * @author maple
 **/
public class Method2 {
    public static void main (String[] args) {
        List<String> list02 = new ArrayList<> ();
        list02.add ("tom");
        list02.add ("merry");
        list02.add ("jack");
        list02.add ("路易");
        list02.add ("john");
        System.out.println ("原始列表：" + list02);
        // max
        System.out.println ("lise02中自然排序的最大元素： " + Collections.max (list02));
        // 自定义max
        System.out.println ("list02中按照字符串长度排序的最大元素：" + Collections.max (list02 , new Comparator () {
            @Override
            public int compare (Object o1, Object o2) {
                return ((String)o1).length () - ((String)o2).length ();
            }
        }));
        // min
        System.out.println ("list02中自然排序的最小元素：" + Collections.min (list02));
        // 自定义min
        System.out.println ("list02中按照字符串长度排序的最小元素：" + Collections.min (list02 , new Comparator () {
            @Override
            public int compare (Object o1, Object o2) {
                return ((String)o1).length () - ((String)o2).length ();
            }
        }));
        // frequency
        list02.add ("john");
        System.out.println ("list02中john的个数：" + Collections.frequency (list02 , "john"));
        List<String> listCopy = new ArrayList<> ();
        // copy
        for (int i = 0 ; i < list02.size () ; i++) {
            listCopy.add ("");
        }
        Collections.copy (listCopy , list02);
        System.out.println ("list02：" + list02);
        System.out.println ("listCopy：" + listCopy);
        // replaceAll
        System.out.println ("将‘john’全部替换成‘汤姆’：" + Collections.replaceAll (list02 , "john" , "汤姆"));
        System.out.println ("list02：" + list02);
    }
}
