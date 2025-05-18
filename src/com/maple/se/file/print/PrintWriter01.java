package com.maple.se.file.print;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author maple
 **/
public class PrintWriter01 {
    public static void main (String[] args) throws FileNotFoundException {
        //传入System.out， 默认输出到控制台
        PrintWriter out = new PrintWriter (System.out);
        out.println ("Hello World!");
        //传入文件路径， 输出到文件
        PrintWriter printWriter = new PrintWriter ("E:\\printWriterFile.txt");
        printWriter.println ("Hello World!");
        out.close ();
        printWriter.close ();
    }
}
