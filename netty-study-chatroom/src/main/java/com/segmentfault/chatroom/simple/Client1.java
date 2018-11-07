package com.segmentfault.chatroom.simple;

import java.io.*;
import java.net.Socket;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/11/2
 */
public class Client1 {
    private static int port = 10101;

    private static String ip = "127.0.0.1";

    public void send() {
        Socket socket = null;
        BufferedReader in = null;

        PrintWriter out = null;
        try {
            socket = new Socket(ip, port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            out.print("nihao");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
