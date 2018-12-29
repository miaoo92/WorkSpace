package com.segmentfault.springbootlesson19.controller;

import com.segmentfault.springbootlesson19.configuration.PersonConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/11/29
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
@Import(PersonConfiguration.class)
public class PersonControllerSpringBootTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPerson() throws Exception {
        mockMvc.perform(get("")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

    public void testGetPerson() throws Exception {
        mockMvc.perform(get("/id/{id}")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
