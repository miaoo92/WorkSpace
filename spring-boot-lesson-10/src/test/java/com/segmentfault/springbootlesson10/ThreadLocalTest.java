package com.segmentfault.springbootlesson10;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/11/5
 */
public class ThreadLocalTest {

    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    static void print(String str){
        System.out.println(str+":"+ localVariable.get());
        localVariable.remove();
    }

    public static void main(String[] args) {

        Thread threadOne = new Thread(()->{
            localVariable.set("threadOne local Variable");
            print("threadOne");
            System.out.println("ThreadOne remove after :"+ localVariable.get());
        });

        Thread threadTwo = new Thread(()->{
            localVariable.set("threadTwo local Variable");
            print("threadTwo");
            System.out.println("ThreadTwo remove after :"+ localVariable.get());
        });

        threadOne.start();
        threadTwo.start();


    }
}
