package com.maple.javase.file.buffered_show;

/**
 * @author maple
 * 简单模拟处理类原理
 **/
public class Main {
    public static void main (String[] args) {
        StringReaderShow stringReaderShow = new StringReaderShow();
        FileReaderShow fileReaderShow = new FileReaderShow();
        BufferedReaderShow bufferedReaderShowForFile = new BufferedReaderShow(fileReaderShow);
        BufferedReaderShow bufferedReaderShowForString = new BufferedReaderShow(stringReaderShow);
        bufferedReaderShowForString.readString ();
        bufferedReaderShowForString.readStringPro (5);
        System.out.println ("-----------------------------------------");
        bufferedReaderShowForFile.readFile ();
        bufferedReaderShowForFile.readFilePro (5);
        
    }
}
