package com.segmentfault.chatroom.nio;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/11/7
 */
public class ClientMain {
    public static void main(String[] args) {
        new NioSocketClient().start();
    }
}
