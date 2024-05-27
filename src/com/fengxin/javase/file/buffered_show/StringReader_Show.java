package com.fengxin.javase.file.buffered_show;

/**
 * @author FENGXIN
 **/
public class StringReader_Show extends Reader_Show{
    // 继承自Reader_Show类,实现readFile方法
    
    @Override
    public void readString() {
        System.out.println ("读取String...");
    }
}
