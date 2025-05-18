package com.maple.javase.file.buffered_show;

/**
 * @author maple
 **/
public class FileReaderShow extends ReaderShow {
    // 继承自Reader_Show类，实现FileReader的read方法
    @Override
    public void readFile()  {
        System.out.println ("读取文件...");
    }
}
