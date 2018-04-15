package com.demo.client;

public class Visibility extends Thread {

    private boolean stop;

    public void  run(){
        int i=0;
        System.out.println("开始执行循环");
        while (!isStop()){
            i++;
        }
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public static void main(String[] args) throws InterruptedException {
        Visibility demo = new Visibility();
        demo.start();
        Thread.sleep(1000);
        demo.setStop(true);
        Thread.sleep(1000);
        System.out.println();



    }
}
