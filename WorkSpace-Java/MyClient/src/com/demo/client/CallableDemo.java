package com.demo.client;

import java.util.concurrent.*;

public class CallableDemo implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("enter in");
        return "success";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        CallableDemo demo = new CallableDemo();
        Future future = service.submit(demo);


        System.out.println(future.get());
    }
}
