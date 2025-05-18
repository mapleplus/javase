package com.maple.javase.file.bufferedstream.reader_writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author FENGXIN
 **/
public class BufferedWriter01 {
    public static void main (String[] args) throws IOException {
        writeFile();
    }
    public static void writeFile() throws IOException {
        // 指定文件路径
        String filePath = "E:\\bufferedWriterTest.txt";
        // 创建BufferedWriter对象
        BufferedWriter bufferedWriter = new BufferedWriter (new FileWriter (filePath, true));
        bufferedWriter.write ("contentTest01");
        // 写入换行符
        bufferedWriter.newLine ();
        bufferedWriter.write ("contentTest02");
        bufferedWriter.newLine ();
        // 关闭外层流，内层流会自动关闭
        bufferedWriter.close ();
    }
}
