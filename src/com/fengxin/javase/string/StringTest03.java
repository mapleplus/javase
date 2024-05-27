package com.fengxin.javase.string;

/**
 * @author FENGXIN
 *     public static Integer valueOf(int i) {
 *         if (i >= IntegerCache.low && i <= IntegerCache.high)
 *             return IntegerCache.cache[i + (-IntegerCache.low)];
 *         return new Integer(i);
 *     }
 **/
public class StringTest03 {
    public static void main (String[] args) {
        Integer i1 = new Integer(10);
        Integer i2 = new Integer(10);
        Integer i3 = 10;
        Integer i4 = 10;
        Integer i5 = -127;
        Integer i6 = -127;
        Integer i7 = 128;
        Integer i8 = 128;
        int i9 = 10;
        // false new关键字的两个对象地址不同，==比较的是地址
        System.out.println(i1 == i2);
        // true 自动装箱，编译器自动调用valueOf方法，缓存[-128,127]，范围内直接比较值，否则new对象为false
        System.out.println(i3 == i4);
        // true 自动装箱，编译器自动调用valueOf方法，缓存[-128,127],范围内直接比较值，否则new对象为false
        System.out.println(i5 == i6);
        // true 自动装箱，编译器自动调用valueOf方法，缓存[-128,127],范围内直接比较值，否则new对象为false
        System.out.println(i7 == i8);
        // true 自动拆箱，比较值(含基本类型的则自动拆箱比较值)
        System.out.println(i1 == i9);
    }
}
