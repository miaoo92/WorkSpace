package com.gupaoedu.vip.restonspringwebmvc.Controller;

import com.gupaoedu.vip.restonspringwebmvc.domain.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;


/**
 * {@link}{@link org.springframework.web.bind.annotation.RestController}
 */
@RestController
public class PersonRestController {

    @GetMapping("/person/{id}")
    public Person person(@PathVariable Long id , @RequestParam(required = false) String name){
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        return person;
    }

    @PostMapping(value = "/person/json/to/properties",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,  //消费Json格式
            produces = "application/properties+person")        //生产properties格式
    public Person personJsonToProperties(@RequestBody Person person){

        return person;
    }

    @PostMapping(value = "/person/properties/to/json",
            consumes = "application/properties+person",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Person personPropertiesToJson(@RequestBody Person person){

        return person;
    }

}
