package com.fengxin.basic.collection.set;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author FENGXIN
 * @data 2024.5.7
 **/
@SuppressWarnings ("all")
public class TreeSet01 {
    public static void main (String[] args) {
        TreeSet treeSet = new TreeSet (new Comparator () {
            @Override
            public int compare (Object o1 , Object o2) {
                // 通过比较字符串大小决定排序
                // return ((String)o1).compareTo ((String)o2);
                
                // 通过比较字符串长度决定排序
                // return ((String) o1).length () - ((String) o2).length ();
                
                // 先比较长度，长度一样再比较大小
                if(((String) o1).length () - ((String) o2).length () == 0){
                    return ((String)o1).compareTo ((String)o2);
                }
                return ((String) o1).length () - ((String) o2).length ();
                
                //通过比较字符串中第一个字母决定排序
                // return ((String)o1).charAt (0) - ((String)o2).charAt (0);
            }
            
        });
        treeSet.add ("apple");
        treeSet.add ("banana");
        treeSet.add ("orange");//由于长度一样，所以不会被添加
        System.out.println (treeSet);
    }
}
