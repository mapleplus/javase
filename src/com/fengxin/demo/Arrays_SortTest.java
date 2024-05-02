package com.fengxin.demo;

import java.util.Arrays;
import java.util.Comparator; /**
 * @author FENGXIN
 * @data 2024.5.2
 * 絮例：自定义Book类，属性name和price，有一个 Book[] books = 4本书对缘.
 * 使用前面学习过的传递 实现Comparator 接回匿名内部类，也称为定制排序。
 * 按照 (1)price 从大到小 (2)price 从小到大 (3)按照书名长度从大到小
 * Book[] books = new Book[4]; }
 * books[0] = new Book("红楼梦", 100);
 * books[1] = new Book("金瓶梅新", 90);
 * books[2] = new Book("青年文摘20年", 5);
 * books[3] = new Book("java从们到放弃 ", 300);
 **/
public class Arrays_SortTest {
    public static void main (String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅新", 90);
        books[2] = new Book("青年文摘20年", 5);
        books[3] = new Book("java从入门到起飞 ", 300);
        // 按照price 从大到小
        // Arrays.sort(books, new Comparator() {
        //     @Override
        //     public int compare(Object o1, Object o2){
        //         Book b1 = (Book) o1;
        //         Book b2 = (Book) o2;
        //         double sum = b1.getPrice() - b2.getPrice();
        //         if (sum > 0) {
        //             return -1;
        //         }else if (sum < 0) {
        //             return 1;
        //         }else {
        //             return 0;
        //         }
        //     }
        // });
        // System.out.println (Arrays.toString (books));
        // 按照price 从小到大
        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2){
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
                double sum = b2.getPrice() - b1.getPrice();
                if (sum > 0) {
                    return -1;
                }else if (sum < 0) {
                    return 1;
                }else {
                    return 0;
                }
            }
        });
        System.out.println (Arrays.toString (books));
    }
}
// 定义Book类
class Book{
    private String name;
    private double price;
    
    public Book () {
    }
    
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
    
    @Override
    public String toString () {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
