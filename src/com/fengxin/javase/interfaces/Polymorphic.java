package com.fengxin.javase.interfaces;

/**
 * @author FENGXIN
 **/
public class Polymorphic {

    public static void main(String[] args) {
        // 创建手机和相机对象
        // 接口类型的变量 computer 可以指向实现了接口的类的对象实例
        computer computer = new phone();
        computer.print();
        computer = new camera();
        computer.print();
        System.out.println ();
        // 接口类型的变量 object 可以指向实现了接口的类的对象实例
        
        // 多态数组
        computer[] computers = new computer[2];
        computers[0] = new phone();
        computers[1] = new camera();
        // 遍历数组
        for (com.fengxin.javase.interfaces.computer value : computers) {
            value.print ();
            // 如果是手机（向下转型），输出call内容
            if (value instanceof phone) {
                ((phone) value).call ();
                System.out.println ("-------------------------------");
            }
        }
        
        // 多态传递
        System.out.println ();
        object object = new phone();
        object.hi();
    }
}

//object
interface object {
    void hi();
}

//computer
interface computer extends object {

    void print();
}

//phone
class phone implements computer {
    // phone 类实现了 object 接口，并实现了接口中的方法
    @Override
    public void hi() {
        System.out.println("手机object");
    }
    // phone 类实现了 computer 接口，并实现了接口中的方法
    @Override
    public void print() {
        System.out.println("手机在运行...");

    }
    // phone 类还实现了额外的 call 方法
    public void call() {
        System.out.println("手机在打电话...");
    }
}

//camera

class camera implements computer {
    // camera 类实现了 object 接口，并实现了接口中的方法
    @Override
    public void hi() {
        System.out.println("相机object");
    }
    // camera 类实现了 computer 接口，并实现了接口中的方法
    @Override
    public void print() {
        System.out.println("相机在运行...");
    }
}