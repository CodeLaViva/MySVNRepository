package com.lhz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * TCP连接的客户端
 */
public class Exercise2_Client {
    private Socket socket;
    private BufferedReader bufferedReader;
    private PrintWriter pw;
    private static final int port = 8001;
    private static final String host = "127.0.0.1";

    //连接客户端
    private void connect() {
        try {
            socket = new Socket(host, port);
            pw = new PrintWriter(socket.getOutputStream(), true);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //向服务端发送信息
    private void print() {
        Scanner scanner = new Scanner(System.in);
        String str;

        pw.println("这是连接测试类的构造函数");
        do {
            getMessage();
            System.out.println("请输入信息： ");
            str = scanner.nextLine();
            pw.println(str);
        }
        while (!str.equals("done"));
    }

    //获取服务端返回的信息
    private void getMessage(){
        String s;
        try {
            s = bufferedReader.readLine();
            if (s != null) {
                System.out.println("服务器： " + s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Exercise2_Client connect = new Exercise2_Client();
        connect.connect();
    }
}
