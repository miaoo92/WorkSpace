package com.segmentfault.springbootlesson18.controller;

import com.segmentfault.springbootlesson18.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/12/7
 */
@RestController
public class PersonController implements EnvironmentAware{

    @Autowired
    @Qualifier("person")
    private Person person;

    @Value("${person.id}")
    private Long id;

    @Value("${person.name:小马哥}")
    private String name;

    private Integer age;

    @GetMapping("/person/get")
    public Person getPerson(){
        return person;
    }

    @GetMapping("/person/get/data")
    public Map<String , Object> getPerson1(){
        Map<String, Object> map = new HashMap<>();
        map.putIfAbsent("age",age);
        map.putIfAbsent("id",id);
        map.putIfAbsent("name",name);
        return map;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.age = environment.getProperty("person.age",Integer.class);
    }
}
