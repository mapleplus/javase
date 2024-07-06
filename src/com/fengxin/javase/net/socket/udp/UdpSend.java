package com.fengxin.javase.net.socket.udp;

import java.io.IOException;
import java.net.*;

/**
 * @author FENGXIN
 * 发送端
 **/
public class UdpSend {
    public static void main (String[] args) throws IOException {
        // 创建UDP Socket
        DatagramSocket socket = new DatagramSocket (8888);
        // 创建数据包，用于发送数据，最大64K
        // 创建byte[]数组，用于存储要发送的数据
        byte[] data;
        data = "Hello, World!".getBytes ();
        // 设置目标IP地址和端口号
        DatagramPacket packet = new DatagramPacket (data,data.length,InetAddress.getByName ("127.0.0.1"),9999);
        // 发送数据
        socket.send (packet);
        // 关闭Socket
        socket.close ();
    }
}
