package com.imooc.web.reactive.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/10/21
 */
@SpringBootApplication
@RestController
public class WebFluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebFluxApplication.class, args);
    }

    @GetMapping("/mvc")
    public String mvc(){
        println("MVC");
        return "MVC";
    }

    @GetMapping("/mono")
    public Mono<String> mono(){
        println("Mono");
        return Mono.just("Mono");
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
       /* return RouterFunctions.route(serverRequest -> {           //判定请求是否匹配
                    URI uri = serverRequest.uri();
                    return "/hello-world".equals(uri.getPath());
                },
                serverRequest -> ServerResponse.status(HttpStatus.OK)   //绑定实现
                        .body(Mono.just("Hello,World."),String.class)
        );*/
       return route(GET("/hello-world"),this::helloWorld);
    }

    public Mono<ServerResponse> helloWorld(ServerRequest serverRequest){
        println("Hello,World");
        return  ServerResponse.status(HttpStatus.OK)   //绑定实现
                .body(Mono.just("Hello,World."),String.class);
    }

    private static void  println(String message){
        System.out.println("["+Thread.currentThread().getName()+"] :"+ message);
    }

}
