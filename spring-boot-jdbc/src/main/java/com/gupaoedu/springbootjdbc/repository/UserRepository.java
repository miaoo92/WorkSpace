package com.gupaoedu.springbootjdbc.repository;


import com.gupaoedu.springbootjdbc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
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

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public UserRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public boolean save(User user){
        System.out.println("save User :"+user);
        return true;
    }

    public Collection<User> findAll(){
        return Collections.emptyList();
    }

}
