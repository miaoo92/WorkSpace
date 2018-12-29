package com.segmentfault.springbootlesson18.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/12/7
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerSpringBootTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetPerson() throws Exception {
        mockMvc.perform(get("/person/get")
                .accept(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(status().isOk());
    }

}
