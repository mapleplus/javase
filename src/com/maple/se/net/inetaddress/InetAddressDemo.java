package com.maple.se.net.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author maple
 **/
public class InetAddressDemo {
    public static void main (String[] args) throws UnknownHostException {
        // 获取本地主机的InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost ();
        System.out.println (localHost);
        
        // 根据主机名获取InetAddress对象
        InetAddress localHostByName = InetAddress.getByName ("FengXin");
        System.out.println (localHostByName);
        
        // 根据域名获取InetAddress对象
        InetAddress localHostByAddress = InetAddress.getByName ("www.google.com");
        System.out.println (localHostByAddress);
        
        // 获取IP地址(String表示)
        String ipAddress = localHostByAddress.getHostAddress ();
        System.out.println (ipAddress);
        
        // 获取主机名/域名(String表示)
        String hostName = localHostByAddress.getHostName ();
        System.out.println (hostName);
    }
}
