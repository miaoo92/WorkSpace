package com.segmentfault.chatroom.simple;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/11/2
 */
public class Server {

    private static int DEFAULT_PORT = 10101;

    private static ServerSocket serverSocket;

    public void start() {
        if (serverSocket != null){
            return;
        }
        try {
            serverSocket = new ServerSocket(DEFAULT_PORT);
            System.out.println("服务已启动，端口号:" + DEFAULT_PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                if ((line = bufferedReader.readLine()) == null) {
                    break;
                } else {
                    System.out.println("服务端收到信息：" + line);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (serverSocket!= null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("服务端已关闭");
                serverSocket = null;
            }
        }
    }

}
