package com.fengxin.basic.file.buffered_show;

/**
 * @author FENGXIN
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
