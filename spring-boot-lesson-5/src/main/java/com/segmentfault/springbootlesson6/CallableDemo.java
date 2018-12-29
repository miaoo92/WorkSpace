package com.segmentfault.springbootlesson6;

import java.util.concurrent.*;

public class CallableDemo implements Callable<String> {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CallableDemo demo = new CallableDemo();
        Future<String> future = executorService.submit(demo);
        System.out.println(future.get());  //阻塞
        executorService.shutdown();

    }
    @Override
    public String call() throws Exception {
        return "String";
    }
}
