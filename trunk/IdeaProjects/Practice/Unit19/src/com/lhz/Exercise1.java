package com.lhz;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 实现获取本机的主机名、主机地址和本机地址
 * @author lhz
 * @version 1.0
 */

public class Exercise1 {

    public static void main(String[] args){
        InetAddress inetAddress;
        InetAddress inetAddress2;
        try {
            inetAddress = InetAddress.getLocalHost();
            inetAddress2 = InetAddress.getByName("10.181.105.81");
            String local_name = inetAddress.getHostName();
            String local_ip = inetAddress.getHostAddress();
            String local_name2 = inetAddress2.getHostName();
            String local_ip2 = inetAddress2.getHostAddress();
            System.out.println("本机名： " + local_name);
            System.out.println("本机IP： " + local_ip);
            System.out.println("本机名2： " + local_name2);
            System.out.println("本机IP2： " + local_ip2);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
