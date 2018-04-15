package com.gupaoedu.springbootjdbc.config;


import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


/**
 * 多数据源配置
 */
@Configuration
public class DataSourceConfiguration {

    @Bean
    @Primary
    public DataSource masterDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        DataSource dataSource = dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/test")
                .username("root")
                .password("root").build();
        return dataSource;

    }

    @Bean
    public DataSource slaveDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        DataSource dataSource = dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/test2")
                .username("root")
                .password("root").build();
        return dataSource;
    }



}
