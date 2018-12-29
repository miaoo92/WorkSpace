package com.segmentfault.springbootlesson18.configuration;

import com.segmentfault.springbootlesson18.domain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/12/8
 */
@Configuration
public class PersonConfiguration {

    @Bean
    @Profile("test")
    public Person zhangxueyou(){
        Person person = new Person();
        person.setName("张学友");
        return person;
    }

    @Bean
    @Profile("dev")
    public Person zhnaghan(){
        Person person = new Person();
        person.setName("张翰");
        return person;
    }

}
