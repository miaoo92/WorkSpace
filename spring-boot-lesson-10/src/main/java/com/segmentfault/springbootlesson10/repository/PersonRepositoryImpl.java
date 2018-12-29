package com.segmentfault.springbootlesson10.repository;

import com.segmentfault.springbootlesson10.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/10/31
 */
@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private final Map<String,Person> repository = new HashMap<>();


    @Override
    public Person findPerson(String id) {
        return repository.get(id);
    }

    @Override
    public boolean savePerson(Person person) {
        return repository.putIfAbsent(person.getId(),person) == null;
    }
}
