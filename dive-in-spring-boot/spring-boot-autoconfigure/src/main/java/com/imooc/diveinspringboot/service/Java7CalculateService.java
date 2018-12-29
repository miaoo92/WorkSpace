package com.imooc.diveinspringboot.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Java7 for 循环实现累加
 *
 * @Author miaoo
 * @Date 2018/8/23
 */
@Profile("Java7")
@Service
public class Java7CalculateService implements CalculateService {
    @Override
    public Integer sum(Integer... values) {
        System.out.println("Java7 for 循环实现累加");
        Integer sum = 0;
        for (int i = 0 ; i<values.length; i++){
            sum += values[i];
        }
        return sum;
    }
}
