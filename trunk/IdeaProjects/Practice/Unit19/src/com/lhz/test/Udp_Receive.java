package com.lhz.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Udp_Receive implements Runnable {
    int port = 8888;
    private InetAddress group = null;
    private MulticastSocket socket = null;
    Thread thread;

    public Udp_Receive(){
        super();
        thread = new Thread(this);

        try {
            group = InetAddress.getByName("224.255.10.0");
            socket = new MulticastSocket(port);
            socket.joinGroup(group);
        } catch (IOException e) {
            e.printStackTrace();
        }

        thread.start();
    }


    @Override
    public void run() {
        while (true){
            byte data[] = new byte[1024];
            DatagramPacket packet = null;

            packet = new DatagramPacket(data, data.length, group, port);

            try {
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("message: " + message);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }



    public void action_thread(){
        if (!(thread.isAlive())){
            thread = new Thread(this);
        }
        thread.start();
    }

    public static void main(String[] args){
        Udp_Receive receive = new Udp_Receive();
        //receive.thread.start();
    }

}
