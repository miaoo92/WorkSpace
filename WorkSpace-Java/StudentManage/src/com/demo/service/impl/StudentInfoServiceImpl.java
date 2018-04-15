package com.demo.service.impl;

import com.demo.entity.student;
import com.demo.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2016/3/19.
 */
@Component
public class StudentInfoServiceImpl implements StudentInfoService{

    @Autowired
    public JdbcTemplate jdbcTemplate;
    @Override
    public List<student> findAllStudent() {
        String sql = "select * from data.student";
        List<student> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(student.class));
        return list;
    }
}
