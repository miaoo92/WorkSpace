package com.gupaoedu.springbootjdbc.webflux;


import com.gupaoedu.springbootjdbc.domain.User;
import com.gupaoedu.springbootjdbc.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class UserHandler {

    private final UserRepository userRepository;

    public UserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<ServerResponse>  save(ServerRequest serverRequest){
        //在Spring Web MVC 中使用的是@RequestBody
        //在Spring WebFlux中使用的是serverRequest
        //Mono<User> 类似于Optional<User>
        Mono<User> userMono = serverRequest.bodyToMono(User.class);
        //map相当于转化工作
        Mono<Boolean> booleanMono = userMono.map(userRepository::save);
        return ServerResponse.ok().body(booleanMono,Boolean.class);
    }


}
