package com.demo.client;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo {

    AtomicInteger i = new AtomicInteger(0);
//    volatile  int i;

    public void add(){
        i.addAndGet(1);
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo demo = new ThreadDemo();
        CountDownLatch latch = new CountDownLatch(1000);
        for (int i=0; i<1000;i++){
            new Thread(()->{
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                demo.add();
                latch.countDown();
            }).start();
        }
        latch.await();
        System.out.println(demo.i);

    }
}
