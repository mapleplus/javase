package com.fengxin.javase.file.general;

import java.io.File;
import java.io.IOException;

/**
 * @author FENGXIN
 **/

public class CreateFile {
    public static void main (String[] args) {
        test1 ();
        test2 ();
        test3 ();
    }
    //第一种创建方式
    // new File(String pathName)：根据路径创建File对象
    public static void test1(){
        String fileName = "E:\\file1.txt";
        File fileTest = new File(fileName);
        judge (fileTest);
    }
    //第二种创建方式
    // new File(File parent,String child)：根据父目录文件 + 子路径创建
    public static void test2() {
        File file = new File ("E:\\");
        String fileString = "file2.txt";
        File fileTest = new File(file, fileString);
        judge (fileTest);
    }
    //第三种创建方式
    // new File(String parent,String child)：根据父目录 + 子目录创建
    public static void test3() {
        String file1 = "E:\\";
        String file2 = "file3.txt";
        File fileTest = new File (file1, file2);
        judge (fileTest);
    }
    public static void judge(File fileTest){
        try {
            boolean judge = fileTest.createNewFile ();
            if (judge) {
                System.out.println ("文件创建成功");
            }
            else {
                System.out.println ("文件已存在");
            }
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
    }
}
    

