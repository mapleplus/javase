package com.fengxin.javase.collection.map;

import java.util.Hashtable;

/**
 * @author FENGXIN
 * Hashtable的方法
 **/
public class Map_Hashtable {
    public static void main (String[] args) {
        Hashtable<String,String> hashtable = new Hashtable<> ();
        hashtable.put ("key1", "value1");
        hashtable.put ("key2", "value2");
        hashtable.put ("key3", "value3");
        //K-V不能为null
        // hashtable.put (null, "value4");
        // hashtable.put ("key5", null);
        System.out.println (hashtable);
        System.out.println (hashtable.get ("key2"));
        hashtable.replace ("key2", "new value2");
        System.out.println (hashtable.get ("key2"));
        hashtable.remove ("key3");
        System.out.println (hashtable);
    }
}
