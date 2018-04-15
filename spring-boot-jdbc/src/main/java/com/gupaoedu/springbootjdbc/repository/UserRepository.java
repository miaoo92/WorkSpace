package com.gupaoedu.springbootjdbc.repository;


import com.gupaoedu.springbootjdbc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * {@link User} 用户的仓库
 *
 */
@Repository
public class UserRepository {

    private final DataSource dataSource;

    /*
     *   此处与老师写法不同，不能在构造器的参数前面加Qualifier，否则会启动失败
     */
    @Qualifier("materDataSource")
    private final DataSource materDataSource;

    @Qualifier("slaveDataSource")
    private final DataSource slaveDataSource;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public UserRepository(DataSource dataSource, DataSource materDataSource, DataSource slaveDataSource) {
        this.dataSource = dataSource;
        this.materDataSource = materDataSource;
        this.slaveDataSource = slaveDataSource;
    }


    public boolean save(User user){
        System.out.printf("[Thread : %s ]save User : %s \n",Thread.currentThread().getName(),user);
        return true;
    }

    public Collection<User> findAll(){
        return Collections.emptyList();
    }

}
