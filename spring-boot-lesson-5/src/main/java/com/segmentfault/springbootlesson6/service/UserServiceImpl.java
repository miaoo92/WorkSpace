package com.segmentfault.springbootlesson6.service;

import com.segmentfault.springbootlesson6.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service("userService")
@EnableTransactionManagement
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public boolean saveUser(User user) {
        Boolean date = jdbcTemplate.execute("INSERT INTO user(name) VALUE (?)", new PreparedStatementCallback<Boolean>() {

            @Override
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws DataAccessException {
                try {
                    preparedStatement.setString(1,user.getName());
                    return preparedStatement.executeUpdate() > 0 ;
                } catch (SQLException e) {

                    e.printStackTrace();
                }
                return null;
            }
        });

        return date;
    }
}
