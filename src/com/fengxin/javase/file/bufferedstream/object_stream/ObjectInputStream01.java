package com.fengxin.javase.file.bufferedstream.object_stream;

import java.io.*;

/**
 * @author FENGXIN
 * 反序列化
 * 顺序要和序列化时一致
 * Cat类要放在公共包引用或者同包下，否则会报错
 **/
public class ObjectInputStream01 {
    public static void main (String[] args) throws IOException, ClassNotFoundException {
        String filePath = "E:\\ObjectOut.dat";
        ObjectInputStream objectInputStream = new ObjectInputStream (new FileInputStream (filePath));
        // 读取数据, 顺序要和序列化时一致
        System.out.println (objectInputStream.readInt ());
        System.out.println (objectInputStream.readBoolean ());
        System.out.println (objectInputStream.readChar ());
        System.out.println (objectInputStream.readUTF ());
        System.out.println (objectInputStream.readObject ());
        // 关闭外层流
        objectInputStream.close ();
        System.out.println ("反序列化成功！");
    }
}
