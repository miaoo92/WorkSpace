package com.demo.service;

import com.demo.entity.student;

import java.util.List;

/**
 * Created by Administrator on 2016/3/19.
 */
public interface StudentInfoService {

    /**
     * 查找全部学生
     * @param class_id
     * @return
     */
    public List<student> findAllStudent();
}
