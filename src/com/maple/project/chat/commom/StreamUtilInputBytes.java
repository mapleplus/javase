package com.maple.project.chat.commom;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author FENGXIN
 **/
public class StreamUtilInputBytes {
    public static byte[] toByteArray (InputStream inputStream) throws IOException {
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
