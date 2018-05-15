package com.lhz.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Test2 {
    private final static int port = 8888;
    private ServerSocket serverSocket;
    private BufferedReader bufferedReader;
    private Socket socket = null;

    private InputStream inputStream;
    private InputStreamReader reader;

    private Server_Test2() throws Exception {
        serverSocket = new ServerSocket(port);
        System.out.println("服务器启动!");
    }

    private void service() {
        while (true) {

            try {
                socket = serverSocket.accept();
                System.out.println("New connection accepted " +
                        socket.getInetAddress() + ":" + socket.getPort());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void getClientMessage() {
        String s;
        try {
            inputStream = socket.getInputStream();
            reader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(reader);

            while (true) {
                s = bufferedReader.readLine();
                if (s != null) {
                    System.out.println("客户机： " + s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Server_Test2 server = new Server_Test2();
        Thread.sleep(60000 * 10);
        server.service();
    }
}