package com.segmentfault.springbootlesson6.Controller;


import com.segmentfault.springbootlesson6.domain.User;
import com.segmentfault.springbootlesson6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

@RestController
public class JdbcController {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserService userService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/user/get")
    public Map<String , Object> getUser(@RequestParam(value = "id",defaultValue = "1")String id){
        Map<String , Object>  map = new HashMap<>();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT  * FROM user where id=?");
            statement.setString(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int _id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                map.put("id",_id);
                map.put("name",name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    @RequestMapping(value = "/user/add",method = RequestMethod.POST)
    public Map<String , Object> addUser(@RequestBody User user){
        Map<String , Object>  map = new HashMap<>();
        map.put("success", userService.saveUser(user));
        return map;
    }

    @RequestMapping("/jdbc/meta/transaction/support")
    public boolean supportedTransaction(){
        boolean support = false;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            support = databaseMetaData.supportsTransactions();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return support;
    }

    @RequestMapping("/users")
    public List<Map<String,Object>> getUsers(){
        return  jdbcTemplate.execute(new StatementCallback<List<Map<String,Object>>>() {
            @Override
            public List<Map<String, Object>> doInStatement(Statement statement) throws SQLException, DataAccessException {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
                ResultSetMetaData  resultSetMetaData = resultSet.getMetaData();
                int columnCount = resultSetMetaData.getColumnCount();
                List<String> columnNames = new ArrayList<>(columnCount);
                for (int i=1 ; i<=columnCount ; i++){
                    String columnName = resultSetMetaData.getColumnName(i);
                    columnNames.add(columnName);
                }
                List<Map<String, Object>> list = new LinkedList<>();
                while (resultSet.next()){
                    Map<String, Object>  map = new LinkedHashMap<>();
                    for (String column : columnNames){
                        Object columnValue = resultSet.getObject(column);
                        map.put(column,columnValue);
                    }
                    list.add(map);
                }

                return list;
            }
        });
    }


}
