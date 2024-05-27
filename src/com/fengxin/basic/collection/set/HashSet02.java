package com.fengxin.basic.collection.set;

import java.util.HashSet;

/**
 * @author FENGXIN
 * 用于HashSet的底层数据结构的源码学习
 **/
public class HashSet02 {
    public static void main (String[] args) {
        HashSet<String> hashSet = new HashSet<> ();
        hashSet.add ("feng");
        hashSet.add ("xin");
        hashSet.add ("feng");
    }
}
