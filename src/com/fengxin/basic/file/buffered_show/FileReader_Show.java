package com.fengxin.basic.file.buffered_show;

/**
 * @author FENGXIN
 * @data 2024.5.13
 **/
public class FileReader_Show extends Reader_Show{
    // 继承自Reader_Show类，实现FileReader的read方法
    @Override
    public void readFile()  {
        System.out.println ("读取文件...");
    }
}
