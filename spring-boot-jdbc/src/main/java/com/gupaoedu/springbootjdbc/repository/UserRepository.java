package com.gupaoedu.springbootjdbc.repository;


import com.gupaoedu.springbootjdbc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    private final JdbcTemplate jdbcTemplate;

    private final PlatformTransactionManager platformTransactionManager;

    @Autowired
    public UserRepository(DataSource dataSource, DataSource masterDataSource,
                          DataSource slaveDataSource,
                          JdbcTemplate jdbcTemplate,
                          PlatformTransactionManager platformTransactionManager) {
        this.dataSource = dataSource;
        this.materDataSource = masterDataSource;
        this.slaveDataSource = slaveDataSource;
        this.jdbcTemplate = jdbcTemplate;
        this.platformTransactionManager = platformTransactionManager;
    }

    @Transactional
    public boolean transactionSave(User user){
        Boolean success = false;
        success = jdbcTemplate.execute("INSERT INTO  user(name) VALUE (?)", new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setString(1,user.getName());
                return preparedStatement.executeUpdate() > 0;
            }
        });

        return success;
    }


    public boolean save(User user){
        Boolean success = false;

        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(defaultTransactionDefinition);
        success = jdbcTemplate.execute("INSERT INTO  user(name) VALUE (?)", new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setString(1,user.getName());
                return preparedStatement.executeUpdate() > 0;
            }
        });
        platformTransactionManager.commit(transactionStatus);
        return success;
    }


    public boolean jdbcSave(User user) throws SQLException {
        System.out.printf("[Thread : %s ]save User : %s \n",Thread.currentThread().getName(),user);
        boolean success = false;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.setSavepoint("T1");   //安全点的方式来控制事务
            connection.setAutoCommit(false);        //关闭自动提交的方式来控制事务
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO  user(name) VALUE (?)");
            preparedStatement.setString(1,user.getName());
            success = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }finally {
            if(connection != null){
                try {
                    connection.commit();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return success;
    }

    public Collection<User> findAll(){
        return Collections.emptyList();
    }

}
