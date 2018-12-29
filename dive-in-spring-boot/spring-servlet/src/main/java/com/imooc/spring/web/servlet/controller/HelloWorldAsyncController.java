package com.imooc.spring.web.servlet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Hello World 异步
 *
 * @author miaoo
 * @since 2018/9/24
 */
@RestController
//@EnableScheduling
public class HelloWorldAsyncController {

    private final BlockingQueue<DeferredResult<String>> queue = new ArrayBlockingQueue<>(5);

    //超时随机数
    private final Random random = new Random();

//    @Scheduled(fixedRate = 5000)
    public void process() throws InterruptedException {
        DeferredResult<String> result = null;
        do {
            result = queue.take();
            long timeout = random.nextInt(100);
            //模拟程序执行时间
            Thread.sleep(timeout);
            result.setResult("Hello,World");
            println("执行计算结果，消耗" + timeout + "ms.");
        } while (result != null);
    }

    @GetMapping("/completable/hello-world")
    public CompletionStage<String> completionStagehelloWorld() {
        final long startTime = System.currentTimeMillis();
        println("Hello,World");
        return CompletableFuture.supplyAsync(()->{
            long costTime = System.currentTimeMillis() - startTime;
            println("执行计算结果，消耗" + costTime + "ms.");
            return "Hello,World";
        });

    }

    @GetMapping("/callable/hello-world")
    public Callable<String> callablehelloWorld() {
        final long startTime = System.currentTimeMillis();
        println("Hello,World");
        return ()->{
            long costTime = System.currentTimeMillis() - startTime;
            println("执行计算结果，消耗" + costTime + "ms.");
            return "Hello,World";
        };

    }


    @GetMapping("/hello-world")
    public DeferredResult<String> helloWorld() {
        DeferredResult<String> result = new DeferredResult<>(50L);
//        result.setResult("Hello,World");
        //入队操作
        queue.offer(result);
        println("Hello,World");
        result.onCompletion(() -> {
            println("执行结束");
        });

        result.onTimeout(() -> {
            println("执行超时");
        });

        return result;
    }

    private static void println(Object object) {
        String threadName = Thread.currentThread().getName();
        System.out.println("HelloWorldAsyncController[" + threadName + "]:" + object);
    }

}
