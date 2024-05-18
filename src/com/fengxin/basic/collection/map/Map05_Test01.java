package com.fengxin.basic.collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
@SuppressWarnings({"all"})
/**
 * @author FENGXIN
 **/

public class Map05_Test01 {
    public static void main (String[] args) {
        Map map = new HashMap ();
        map.put (01,new Employee01 ("张三",10000,01));
        map.put (02,new Employee01 ("李四",20000,02));
        map.put (03,new Employee01 ("王五",30000,03));
    //     第一种遍历方式，通过keySet()方法遍历
        Set keyset = map.keySet ();
        for (Object o : keyset) {
            Employee01 em = (Employee01) (map.get (o));
            if (em.getSalary () >= 20000) {
                System.out.println (em);
            }
        }
    //      第二种遍历方式，通过entrySet()方法遍历
        Set entry = map.entrySet ();
        Iterator iterator = entry.iterator ();
        System.out.println ("entry运行类型："+ entry.getClass ());
        while (iterator.hasNext ()) {
            Map.Entry entry1 = (Map.Entry) iterator.next ();
            System.out.println ("entry1运行类型："+ entry1.getClass ());
            Employee01 em2 = (Employee01) entry1.getValue ();//getValue()返回Employee01对象
            System.out.println ("em2运行类型："+em2.getClass ());
            if (em2.getSalary () >= 20000) {
                System.out.println (entry1);
            }
        }
    }
}
@SuppressWarnings({"all"})
class Employee01{
    private String name;
    private double salary;
    private int id;
    
    public double getSalary () {
        return salary;
    }
    
    @Override
    public String toString () {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }
    
    public Employee01 (String name , double salary , int id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }
}