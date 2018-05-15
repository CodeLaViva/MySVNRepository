package com.lhz.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client_Test2 {
    private Socket socket;
    private final static String host = "127.0.0.1";
    private final static int port = 8888;
    private PrintWriter pw;

    private void connect() {
        String str;
        try {
            socket = new Socket(host, port);
            pw = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);
            do {
                str = scanner.nextLine();
                System.out.println("str: " + str);
                pw.println(str);
            }
            while (!str.equals("done"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        Client_Test2 client = new Client_Test2();
        client.connect();
    }
}
