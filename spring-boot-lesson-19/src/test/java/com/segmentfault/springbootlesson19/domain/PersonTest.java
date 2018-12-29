package com.segmentfault.springbootlesson19.domain;

import org.junit.Assert;
import org.junit.Test;

/**
 * {@link Person}
 *
 * @author miaoo
 * @since 2018/11/22
 */
public class PersonTest {

    @Test
    public void testPerson(){
        Person person = new Person();
        person.setAge(10);
        Assert.assertEquals(Integer.valueOf(10),person.getAge());
        Assert.assertNotNull(person);
    }
}
