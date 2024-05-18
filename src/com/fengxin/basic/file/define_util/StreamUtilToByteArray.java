package com.fengxin.basic.file.define_util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author FENGXIN
 * 本工具类用于将输入流转换为字节数组
 * 将输入流转换为字节数组
 **/
public class StreamUtilToByteArray {
    public static byte[] toByteArray (InputStream inputStream) throws  IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream ();
        byte[] buffer = new byte[4096];
        int length;
        while ((length = inputStream.read (buffer)) != -1) {
            outputStream.write (buffer , 0 , length);
        }
        outputStream.close ();
        return outputStream.toByteArray ();
    }
}
