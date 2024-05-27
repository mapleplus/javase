package com.fengxin.basic.collection.map;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author FENGXIN
 **/
public class Map_TreeMap {
    public static void main (String[] args) {
        TreeMap<String,String> treeMap = new TreeMap<> (new Comparator () {
            @Override
            public int compare (Object o1 , Object o2) {
                // 按照字符串的字母顺序进行排序
                return ((String) o1).compareTo ((String) o2);
            }
        });
        treeMap.put ("feng" , "xin");
        treeMap.put ("key" , "value");
        treeMap.put ("abc" , "my");
        System.out.println (treeMap);
    }
}
