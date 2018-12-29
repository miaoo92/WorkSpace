package com.segmentfault.springbootlesson19.controller;

import com.segmentfault.springbootlesson19.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/11/29
 */
@RestController
public class PersonController {

    @Autowired
    private Person person;

    @GetMapping
    public Person person() {
        return person;
    }

    @GetMapping("/id/{id}")
    public Long getPerson(@RequestParam("id") Long id) {
        return id + 1L;
    }
}
