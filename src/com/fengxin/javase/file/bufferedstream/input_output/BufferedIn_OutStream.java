package com.fengxin.javase.file.bufferedstream.input_output;


import java.io.*;

/**
 * @author FENGXIN
 * 字节流
 **/
public class BufferedIn_OutStream {
    public static void main (String[] args) {
        copyFile ();
    }
    public static void copyFile() {
        String srcFile = "E:\\inputSrc.txt";
        String destFile = "E:\\outputDest.txt";
        
        BufferedInputStream fis = null;
        BufferedOutputStream fos = null;
        // 创建缓冲区
        byte[] buffer = new byte[1024];
        // 创建输入输出流
        try {
            fis = new BufferedInputStream (new FileInputStream (srcFile));
            fos = new BufferedOutputStream (new FileOutputStream (destFile));
            int bytesRead;
            while ((bytesRead = fis.read (buffer)) != -1){
                fos.write (buffer, 0, bytesRead);
            }
            System.out.println ("文件复制成功！");
        } catch (IOException e) {
            throw new RuntimeException (e);
        } finally {
            try {
                if (fis != null) {
                    fis.close ();
                }
                if(fos != null){
                    fos.close ();
                }
            } catch (IOException e) {
                throw new RuntimeException (e);
            }
        }
    }
}
