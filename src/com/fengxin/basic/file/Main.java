package com.fengxin.basic.file;

import com.fengxin.basic.file.buffered_show.BufferedReader_Show;
import com.fengxin.basic.file.buffered_show.FileReader_Show;
import com.fengxin.basic.file.buffered_show.StringReader_Show;

/**
 * @author FENGXIN
 * @data 2024.5.13
 * 简单模拟处理类原理
 **/
public class Main {
    public static void main (String[] args) {
        StringReader_Show stringReaderShow = new StringReader_Show();
        FileReader_Show fileReaderShow = new FileReader_Show();
        BufferedReader_Show bufferedReaderShowForFile = new BufferedReader_Show(fileReaderShow);
        BufferedReader_Show bufferedReaderShowForString = new BufferedReader_Show(stringReaderShow);
        bufferedReaderShowForString.readString ();
        bufferedReaderShowForString.readStringPro (5);
        System.out.println ("-----------------------------------------");
        bufferedReaderShowForFile.readFile ();
        bufferedReaderShowForFile.readFilePro (5);
        
    }
}
