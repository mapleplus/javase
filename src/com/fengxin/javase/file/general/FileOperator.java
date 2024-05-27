package com.fengxin.javase.file.general;

import java.io.File;

/**
 * @author FENGXIN
 **/
public class FileOperator {
    public static void main (String[] args) {
        fileOperator1 ();
        fileOperator2 ();
        fileOperator3 ();
    }
    //判断一个目录的文件是否存在，如果存在就删除
    public static void fileOperator1(){
        String filePath = "E:\\file1.txt";
        File file = new File (filePath);
        if(file.exists ()){
            if(file.delete ()){
                System.out.println ("文件删除成功");
            }else {
                System.out.println ("文件删除失败");
            }
        }else{
            System.out.println ("文件不存在");
        }
    }
    // 判断一个目录是否存在，如果不存在就创建
    public static void fileOperator2(){
        String filePath = "E:\\file1\\file2\\file3";
        File file = new File (filePath);
        if(!file.exists ()){
            if(file.mkdirs ()){
                System.out.println ("目录创建成功");
            }else{
                System.out.println ("创建失败");
            }
        }else{
            System.out.println ("目录已经存在");
        }
    }
    //判断一个目录是否存在，如果存在就删除
    public static void fileOperator3(){
        String filePath = "E:\\file1\\file2\\file3";
        File file = new File (filePath);
        if(file.exists ()){
            if(file.delete ()){
                System.out.println ("目录删除成功");
            }else{
                System.out.println ("目录不存在/删除失败");
            }
        }
    }
}
