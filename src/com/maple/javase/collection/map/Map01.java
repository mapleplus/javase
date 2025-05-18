package com.maple.javase.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FENGXIN
 **/
public class Map01 {
    public static void main (String[] args) {
        Map<Object,Object> map = new HashMap<> ();
        // key一对一value,Map中key不允许重复，原因和HashSet一样，如果相同则会覆盖原数据
        map.put("key1", "value1");
        //value2覆盖value1
        map.put("key1", "value2");
        // value一对多key,Map中的value可以重复
        map.put("key2", "value2");
        map.put("key3", "value2");
        // 常用String类作为Map中的key，当然也可以为其他任意类型
        map.put(new Cat(), new Dog());
        System.out.println (map);
    }
    static class Cat {}
    static class Dog {}
}
