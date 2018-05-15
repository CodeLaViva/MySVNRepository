package com.lhz.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Udp_Test extends Thread {
    String weather = "节目预告，今晚八点有大型舞会，欢迎收听！";
    int port = 8888;
    InetAddress inetAddress = null;
    MulticastSocket socket = null;

    Udp_Test(){
        try {
            inetAddress = InetAddress.getByName("224.255.10.0");
            socket = new MulticastSocket(port);
            socket.setTimeToLive(1);  //指定发送范围是本地网络
            socket.joinGroup(inetAddress);//加入广播组
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        while (true) {
            DatagramPacket packet = null;
            byte data[] = weather.getBytes();

            packet = new DatagramPacket(data, data.length, inetAddress, port);
            System.out.println(new String(data));

            try {
                socket.send(packet);
                sleep(3000);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Udp_Test test = new Udp_Test();
        test.start();
    }
}
