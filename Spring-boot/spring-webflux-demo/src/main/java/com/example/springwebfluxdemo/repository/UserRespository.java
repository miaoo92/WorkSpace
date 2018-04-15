package com.example.springwebfluxdemo.repository;

import com.example.springwebfluxdemo.domain.User;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRespository {

    private Map<Long,User> repository = new ConcurrentHashMap<Long,User>();

    public boolean saveUser(User user){
        return repository.put(user.getId(),user)== null;
    }

    public Collection<User> findAll(){
        return repository.values();
    }

    public Flux<User> allUser(){
        return Flux.fromIterable(findAll());
    }

}
