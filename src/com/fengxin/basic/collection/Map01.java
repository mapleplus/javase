package com.fengxin.basic.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FENGXIN
 * @data 2024.5.6
 **/
public class Map01 {
    public static void main (String[] args) {
        Map map = new HashMap ();
        // key一对一value,Map中key不允许重复，原因和HashSet一样，如果相同则会覆盖原数据
        map.put("key1", "value1");
        map.put("key1", "value2");//value2覆盖value1
        // value一对多key,Map中的value可以重复
        map.put("key2", "value2");
        map.put("key3", "value2");
        // 常用String类作为Map中的key，当然也可以为其他任意类型
        map.put(new CAT_(), new DOG ());
        System.out.println (map);
    }
}
class CAT_{}
class DOG{}