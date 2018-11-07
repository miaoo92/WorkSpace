package com.segmentfault.chatroom.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * TODO
 *
 * @author miaoo-10492
 * @since 2018/11/7
 */
public class NioSocketClient {

    public  void start(){
        try (SocketChannel socketChannel = SocketChannel.open()) {
            //连接服务端socket
            SocketAddress socketAddress = new InetSocketAddress("localhost", 12345);
            socketChannel.connect(socketAddress);
            int sendCount = 0;
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (sendCount < 10) {
                buffer.clear();
                //向服务端发送消息
                buffer.put(("current time : " + System.currentTimeMillis()).getBytes());
                //读取模式
                buffer.flip();
                socketChannel.write(buffer);
                buffer.clear();

                sendCount++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new NioSocketClient().start();
    }
}
