package com.segmentfault.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/11/12
 */
public class Person {

    @NotNull
    private String name;

    @Min(value = 0)
    @Max(value = 200 , message = "{person.age.max.message}")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
