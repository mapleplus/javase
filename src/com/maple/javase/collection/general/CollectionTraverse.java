package com.maple.javase.collection.general;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author maple
 **/
public class CollectionTraverse {
    public static void main(String[] args) {
        Book book1 = new Book ("Java", 10.99);
        Book book2 = new Book ("C++", 15.99);
        Book book3 = new Book ("Python", 12.99);
        Collection<Book> collection = new ArrayList<> ();
        collection.add (book1);
        collection.add (book2);
        collection.add (book3);
        System.out.println (collection.size ());
        // 遍历集合
        // 方法1：使用iterator遍历
        System.out.println ("使用iterator遍历");
        //得到迭代器Iterator的对象
        Iterator iterator = collection.iterator ();
        while (iterator.hasNext ()) {
            Book book = (Book) iterator.next ();
            System.out.println (book.getName () + " " + book.getPrice ());
        }
        // 方法2：使用增强for循环遍历
        System.out.println ("使用增强for循环遍历:");
        for(Object obj:collection){
            // 注意：这里需要强制类型转换
            // 因为增强for循环遍历集合时，返回的是Object类型的对象
            // 需要使用Book类的方法
            // 需要]将其转换为Book类型
            Book book = (Book) obj;
            System.out.println (book.getName () + " " + book.getPrice ());
        }
    }
    static class Book{
        private String name;
        private double price;

        public Book (String name , double price) {
            this.name = name;
            this.price = price;
        }

        public String getName () {
            return name;
        }

        public void setName (String name) {
            this.name = name;
        }

        public double getPrice () {
            return price;
        }

        public void setPrice (double price) {
            this.price = price;
        }
    }
}
