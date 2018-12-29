package com.segmentfault.springbootlesson10.repository;

import com.segmentfault.springbootlesson10.entity.Person;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/10/31
 */
@NoRepositoryBean
public interface PersonRepository {

    @Cacheable(cacheNames = "persons")
    Person  findPerson(String id);

    boolean savePerson(Person person);

}
