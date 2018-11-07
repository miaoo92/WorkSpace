package com.segmentfault.chatroom.simple;

import java.io.IOException;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/11/2
 */
public class Test {

    public static void main(String[] args) throws IOException, InterruptedException {
        try{
            new Thread(()->{
                Server server = new Server();
                server.start();
            }).start();
        }catch (Exception e){
            e.printStackTrace();
        }

        Thread.sleep(50);
        try{
            new Thread(()->{
                Client1 client = new Client1();
                client.send();
            }).start();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
