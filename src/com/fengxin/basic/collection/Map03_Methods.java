package com.fengxin.basic.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author FENGXIN
 * @data 2024.5.6
 **/
public class Map03_Methods {
    public static void main (String[] args) {
        Map map = new HashMap ();
        map.put ("key1", "value1");
        map.put ("key2", "value2");
        map.put ("key3", "value3");
        
        // 获取Map中的所有键
        System.out.println ("所有键: " + map.keySet ());
        
        // 获取Map中的所有值
        System.out.println ("所有值: " + map.values ());
        
        // 获取指定键的值
        System.out.println ("键key2对应的值: " + map.get ("key2"));
        
        // 检查Map是否包含指定键
        System.out.println ("Map是否包含键key2: " + map.containsKey ("key2"));
        
        // 检查Map是否包含指定值
        System.out.println ("Map是否包含值value2: " + map.containsValue ("value2"));
        
        // 获取Map的大小
        System.out.println ("Map的大小: " + map.size ());
        
        // 检查Map是否为空
        System.out.println ("Map是否为空: " + map.isEmpty ());
        
        // 删除指定键的映射
        map.remove ("key2");
        
        // 遍历Map中的键值对
        Set set = map.entrySet ();
        for (Object o : set) {
            Map.Entry entry = (Map.Entry) o;
            System.out.println (o);
        }
        
        // 清空Map
        map.clear ();
        
        // 检查Map是否为空
        System.out.println ("Map是否为空: " + map.isEmpty ());
        
    }
}
