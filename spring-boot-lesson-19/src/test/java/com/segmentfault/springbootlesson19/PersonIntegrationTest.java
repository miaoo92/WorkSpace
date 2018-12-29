package com.segmentfault.springbootlesson19;

import com.segmentfault.springbootlesson19.configuration.PersonConfiguration;
import com.segmentfault.springbootlesson19.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/11/23
 */
@RunWith(SpringRunner.class)
@ContextHierarchy(
        @ContextConfiguration(
                classes = PersonConfiguration.class
        )
)
public class PersonIntegrationTest {

    @Autowired
    @Qualifier("primaryPerson")
    private Person person;

    @Test
    public void testPrimaryPerson(){
        assertEquals(Long.valueOf(1L),person.getId());
        assertEquals("小马哥",person.getName());
        assertEquals(Integer.valueOf(32),person.getAge());
    }
}
