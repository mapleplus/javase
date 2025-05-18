package com.maple.javase.file.bufferedstream.object_stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author FENGXIN
 * 序列化
 **/
public class ObjectOutputStream01 {
    public static void main (String[] args) throws IOException {
        // 创建一个序列化地址，文件后缀任意
        String filePath = "E:\\ObjectOut.dat";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream (new FileOutputStream (filePath));
        // 实现了Serializable接口的类
        // Integer, Boolean, Character, String, Cat
        objectOutputStream.writeInt (100);
        objectOutputStream.writeBoolean (true);
        objectOutputStream.writeChar ('A');
        objectOutputStream.writeUTF ("Hello");
        objectOutputStream.writeObject (new Cat("Tom", 3));
        // 关闭外层流
        objectOutputStream.close ();
        System.out.println ("序列化成功");
    }
}
