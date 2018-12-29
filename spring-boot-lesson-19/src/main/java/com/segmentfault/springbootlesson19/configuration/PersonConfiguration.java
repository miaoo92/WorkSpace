package com.segmentfault.springbootlesson19.configuration;

import com.segmentfault.springbootlesson19.domain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/11/23
 */
@Configuration
public class PersonConfiguration {


    @Bean("primaryPerson")
    @Primary
    public Person person(){
        Person person = new Person();
        person.setId(1L);
        person.setName("小马哥");
        person.setAge(32);
        return person;
    }
}
