package com.maple.se.net.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author maple
 * 接收端
 **/
public class Receive {
    public static void main (String[] args) throws IOException {
        // 创建一个UDP Socket，并指定端口号
        DatagramSocket socket = new DatagramSocket (9999);
        // 创建数据包,最大64K
        // 创建一个字节数组，用于接收数据
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket (data,data.length);
        // 等待接收数据，如果接收不到数据，会一直阻塞
        socket.receive (packet);
        // 打印接收到的数据
        System.out.println ("接收到数据：" + new String (data,0,packet.getLength ()));
        // 关闭Socket
        socket.close ();
    }
}
