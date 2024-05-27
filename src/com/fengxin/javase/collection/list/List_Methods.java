package com.fengxin.javase.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FENGXIN
 **/
public class List_Methods {
    public static void main (String[] args) {
        List<Object> list1 = new ArrayList<> ();
        List<Object> list2 = new ArrayList<> ();
        // 添加元素
        for (int i = 0; i < 5; i++){
            list1.add ("元素" + i);
        }
        for (int i = 5; i < 10; i++){
            list2.add ("元素" + i);
        }
        System.out.println("添加元素后的列表list1：" + list1);
        System.out.println("添加元素后的列表list2：" + list2);
        //在指定位置插入元素
        list1.add(2, "元素6");
        System.out.println("在指定位置2插入元素后的列表：" + list1);
        //从指定位置开始将list2的元素添加到list1中
        list1.addAll (1, list2);
        System.out.println("将list2的元素添加到list1位置1中后的列表：" + list1);
        //获取指定位置的元素
        System.out.println ("list1集合中索引为2的元素：" + list1.get (2));
        //返回指定元素在集合中第一次出现的索引
        System.out.println ("元素6在list1集合中第一次出现的索引：" + list1.indexOf ("元素6"));
        //返回指定元素在集合中最后一次出现的索引
        System.out.println ("元素6在list1集合中最后一次出现的索引：" + list1.lastIndexOf ("元素6"));
        //删除指定位置的元素
        list1.remove (1);
        System.out.println("删除指定位置1元素后的列表：" + list1);
        //删除指定元素，并返回此元素
        list1.remove ("元素6");
        System.out.println("删除指定元素后的列表：" + list1);
        //设置指定位置的元素，相当于覆盖
        list1.set (2, "枫");
        System.out.println("设置指定位置2元素后的列表：" + list1);
    }
}
