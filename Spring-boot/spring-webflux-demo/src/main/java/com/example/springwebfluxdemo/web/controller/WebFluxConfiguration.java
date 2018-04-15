package com.example.springwebfluxdemo.web.controller;

import com.example.springwebfluxdemo.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

import java.util.Optional;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static reactor.core.publisher.Flux.just;

@Configuration
public class WebFluxConfiguration {

    //通过Spring Boot Actuator /beans 来查看“helloWorldRouterFunction”

    //这两种写法表示的意思相同
/*    @Bean
    public RouterFunction  helloWorldRouterFunction(){
        return route(GET("/webflux"),request->ok().body(Mono.just("Hello,World"),String.class));
    }*/

    @Bean
    public RouterFunction  helloWorldRouterFunction(){
        return route(GET("/webflux"),
            request->{
                Optional<String> message = request.queryParam("message");
                return ok().body(just(message.get()),String.class);
        });
    }


  /*  @Bean
    public RouterFunction userRouterFunction(){
        return  route(POST("/webflux/user"),
            request -> {
                //JSON格式表达User
                Mono<User> userMono = request.bodyToMono(User.class);
                //User Java toString()表达响应对象
                Mono<String> stringMono = userMono.map(user -> user.toString());
                return ok().body(stringMono,String.class);
            });
    }*/

    @Bean
    public RouterFunction userRouterFunction(){
        return  route(POST("/webflux/user"),
                request -> {
//                    Mono<User> userMono = request.bodyToMono(User.class);
//                    Mono<String> stringMono = userMono.map(user -> user.toString());
                    //小马哥金句：这是一种装逼写法
                    //并行处理
                    return ok().body(request.bodyToMono(User.class).map(User::toString),String.class);
                });
    }

//    @Bean
//    public RouterFunction  helloWorldRouterFunction(){
//        RequestPredicate requestPredicate = GET("/webflux");
//        HandlerFunction handlerFunction = new HandlerFunction() {
//            @Override
//            public Mono handle(ServerRequest serverRequest) {
//                return ok().body(Mono.just("Hello,World"),String.class);
//            }
//        };
//
//       return route(requestPredicate,handlerFunction);
//    }
}
