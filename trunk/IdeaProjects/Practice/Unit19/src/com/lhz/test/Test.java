package com.lhz.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Test {

    private BufferedReader reader;
    private ServerSocket server;
    private Socket socket;

    public static void main(String[] args) {
        InetAdderss_Test();
    }

    public void getServer() throws IOException {
        server = new ServerSocket(8888);
        System.out.println("服务器套接字已经创建成功");
        while (true) {
            System.out.println("等待客户机连接");
            socket = server.accept();//实例化socket对象
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            getClientMessage();
        }
    }

    private void getClientMessage() {
        while (true) {
            //获得客户端信息
            try {
                System.out.println("客户机： " + reader.readLine());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void Tcp_Test() {
        Test test = new Test();
        try {
            test.getServer();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void InetAdderss_Test() {

    }
}
