package com.maple.se.collection.map;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author maple
 **/
public class MyTreeMap {
    public static void main (String[] args) {
        TreeMap<String,String> treeMap = new TreeMap<>(Comparator.comparing(o -> o));
        treeMap.put ("feng" , "xin");
        treeMap.put ("key" , "value");
        treeMap.put ("abc" , "my");
        System.out.println (treeMap);
    }
}
