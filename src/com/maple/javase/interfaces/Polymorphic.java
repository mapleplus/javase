package com.maple.javase.interfaces;

/**
 * @author FENGXIN
 **/
public class Polymorphic {

    public static void main(String[] args) {
        // 创建手机和相机对象
        // 接口类型的变量 computer 可以指向实现了接口的类的对象实例
        computer computer = new Phone();
        computer.print();
        computer = new Camera();
        computer.print();
        System.out.println ();
        // 接口类型的变量 Base 可以指向实现了接口的类的对象实例
        
        // 多态数组
        computer[] computers = new computer[2];
        computers[0] = new Phone();
        computers[1] = new Camera();
        // 遍历数组
        for (computer value : computers) {
            value.print ();
            // 如果是手机（向下转型），输出call内容
            if (value instanceof Phone) {
                ((Phone) value).call ();
                System.out.println ("-------------------------------");
            }
        }
        
        // 多态传递
        System.out.println ();
        Base base = new Phone();
        base.hi();
    }

    interface Base {
        void hi();
    }

    interface computer extends Base {

        void print();
    }

    static class Phone implements computer {
        // Phone 类实现了 Base 接口，并实现了接口中的方法
        @Override
        public void hi() {
            System.out.println("手机object");
        }

        // Phone 类实现了 computer 接口，并实现了接口中的方法
        @Override
        public void print() {
            System.out.println("手机在运行...");

        }

        // Phone 类还实现了额外的 call 方法
        public void call() {
            System.out.println("手机在打电话...");
        }
    }

    static class Camera implements computer {
        // Camera 类实现了 Base 接口，并实现了接口中的方法
        @Override
        public void hi() {
            System.out.println("相机object");
        }
        // Camera 类实现了 computer 接口，并实现了接口中的方法
        @Override
        public void print() {
            System.out.println("相机在运行...");
        }
    }
}

