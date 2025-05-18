package com.maple.javase.file.print;

import java.io.IOException;
import java.io.PrintStream;

/**
 * @author maple
 **/
public class PrintStream01 {
    public static void main (String[] args) throws IOException {
        //赋值System.out，默认输出流，打印到控制台
        PrintStream out = System.out;
        out.println ("Hello, World!01");
        //底层调用write()
        /*
            @Override
            public void write(byte[] buf) throws IOException {
                this.write(buf, 0, buf.length);
            }
         */
        out.write ("Hello, World!02".getBytes());
        //重定向输出流，打印到文件
        PrintStream printStream = new PrintStream ("E:\\printStreamFile.txt");
        System.setOut (printStream);
        // 以下内容将输出到文件
        System.out.println ("Hello, World!03");
        out.close();
        printStream.close();
    }
}
