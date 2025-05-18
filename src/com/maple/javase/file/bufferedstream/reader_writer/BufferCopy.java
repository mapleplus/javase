package com.maple.javase.file.bufferedstream.reader_writer;

import java.io.*;

/**
 * @author FENGXIN
 **/
public class BufferCopy {
    public static void main (String[] args) {
        copyFile ();
    }
    public static void copyFile() {
        // 指定源文件和目标文件
        String sourceFile = "E:\\sourceFile.txt";
        String targetFile = "E:\\targetFile.txt";
        // 创建输入和输出流
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader (sourceFile));
            bufferedWriter = new BufferedWriter(new FileWriter (targetFile));
            // 读取源文件内容并写入目标文件
            // 逐行读取
            String line;
            while ((line = bufferedReader.readLine ()) != null){
                bufferedWriter.write (line);
                // 逐行读取，逐行写入，需要手动添加换行符
                bufferedWriter.newLine ();
            }
            System.out.println ("文件复制成功！");
        } catch (IOException e) {
            throw new RuntimeException (e);
        } finally {
            // 关闭外层流，内层流会自动关闭
            try {
                if(bufferedReader != null){
                    bufferedReader.close ();
                }
                if(bufferedWriter != null){
                    bufferedWriter.close ();
                }
            } catch (IOException e) {
                throw new RuntimeException (e);
            }
        }
    }
}
