package com.imooc.diveinspringboot.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * Java8 lambda表达式实现累加
 *
 * @Author miaoo
 * @Date 2018/8/23
 */
@Profile("Java8")
@Service
public class Java8CalculateService implements CalculateService {
    @Override
    public Integer sum(Integer... values) {
        System.out.println("Java8 lambda表达式实现累加");
        Integer sum = Stream.of(values).reduce(0,Integer::sum);
        return sum;
    }
}
