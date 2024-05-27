package com.fengxin.basic.collection.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author FENGXIN
 **/
public class Map02 {
    public static void main (String[] args) {
        Map<String,String> map = new HashMap<> ();
        map.put ("key1", "value1");
        map.put ("key2", "value2");
        // 当调用HashMap的entrySet()方法时，它会返回一个Set集合，
        // 其中包含了HashMap中的所有键值对。
        // 这个Set集合的运行类是HashMap$EntrySet，它是HashMap的一个内部类，
        // 用于存储Map.Entry类型的元素
        //set的运行类是HashMap$EntrySet
         Set set = map.entrySet ();
        System.out.println (set.getClass ());
        // 遍历set时，每次迭代都会得到一个Map.Entry类型的对象，即HashMap$Node类型的对象
        for (Object o : set) {
            System.out.println (o.getClass ());
        }
        for (Object o : set) {
            //向下转型，因为Map.Entry接口提供getKey和getValue方法
            // o实际上是一个HashMap$Node类型的对象，而不是一个HashMap类型的对象
            // 而HashMap$Node类实现了这两个接口方法，HashMap没有实现接口方法
            // 所以我们可以将o转换为Map.Entry类型，然后调用getKey和getValue方法
            Map.Entry entry = (Map.Entry) o;
            System.out.println (entry.getKey () + " " + entry.getValue ());
        }
        
        // 获取键的集合
        Set set1 = map.keySet ();
        System.out.println (set1.getClass ());
        
        // 遍历键的集合
        for (Object o : set1) {
            System.out.println (o);
        }
        
        // 获取值的集合
        Collection values = map.values ();
        System.out.println (values.getClass ());
        
        // 遍历值的集合
        for (Object o : values) {
            System.out.println (o);
        }
    }
}
