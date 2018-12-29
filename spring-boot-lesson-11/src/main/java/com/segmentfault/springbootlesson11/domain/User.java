package com.segmentfault.springbootlesson11.domain;

import java.io.Serializable;

/**
 * 用户信息的实体
 *
 * @author miaoo
 * @since 2018/11/9
 */
public class User implements Serializable {

    private Long id;

    private String name;

    private Integer age;

    private transient String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", description='" + description + '\'' +
                '}';
    }
}
