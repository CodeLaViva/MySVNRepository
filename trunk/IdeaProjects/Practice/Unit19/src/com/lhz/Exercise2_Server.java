package com.lhz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP连接的服务端
 */
public class Exercise2_Server {
    private BufferedReader bufferedReader;
    private PrintWriter pw;
    private ServerSocket ss;
    private Socket socket;

    private static final int port = 8001;

    //创建连接接口，等待客户端进行连接
    public void getServer() {
        try {
            ss = new ServerSocket(port);
            socket = ss.accept();

            System.out.println("New connection accepted " +
                    socket.getInetAddress() + ":" + socket.getPort());

            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream(), true);

            getClientMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取客户端传递的信息
    private void getClientMessage() {
        String s;
        try {
            while (true) {
                s = bufferedReader.readLine();
                if (s != null) {
                    System.out.println("客户机： " + s);
                    pw.println(s + "我是服务器!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Exercise2_Server test = new Exercise2_Server();
        test.getServer();
    }
}
