package com.maple.javase.file.buffered_show;

/**
 * @author maple
 **/
public class StringReaderShow extends ReaderShow {
    // 继承自Reader_Show类,实现readFile方法
    
    @Override
    public void readString() {
        System.out.println ("读取String...");
    }
}
