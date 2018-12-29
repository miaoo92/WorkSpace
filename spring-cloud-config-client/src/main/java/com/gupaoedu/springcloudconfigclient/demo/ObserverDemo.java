package com.gupaoedu.springcloudconfigclient.demo;

import java.util.*;

public class ObserverDemo {

    public static void main(String[] args) {

        myObserver observable = new myObserver();
        observable.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println("hello,world");
            }
        });
        observable.setChanged();
        //发布者通知，订阅者是被动感知（推的模式）
        observable.notifyObservers();

    }

    private static void echoIterable(){

        //迭代器模式，主动去请求数据
        List<Integer> vlues = Arrays.asList(1,2,3,4,5);
        Iterator<Integer> integerIterator = vlues.iterator();
        while(integerIterator.hasNext()){
            System.out.println(integerIterator.next());
        }

    }


    public static class myObserver extends Observable{

        public synchronized void setChanged() {
            super.setChanged();
        }
    }

}
