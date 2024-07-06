package com.fengxin.demo.java;

import java.util.ArrayList;

/**
 * @author FENGXIN
 */
public class ArrayList_Test01 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("黑马");
        list.add("枸杞子");
        list.add("Mysql");
        list.add("黑枸杞");
        list.add("JAVA");
        String st;
        System.out.println(list);
//        删除包含“枸杞”的数据----方式1
        /*for (int i = 0; i < list.size(); i++) {
            st = list.get(i);
            if (st.contains("枸杞")) {
                list.remove(st);
                //删除list后数据的位置往前移动，数据位置变1，i--保证删除成功
                i--;
            }
        }*/
//        删除包含“枸杞”的数据----方式2
//        倒序删除 list缩减的同时i也在缩减
        for (int i = list.size() - 1; i >= 0 ; i--) {
            st = list.get(i);
            if (st.contains("枸杞")) {
                list.remove(st);
            }
        }
        System.out.println(list);
    }
}
