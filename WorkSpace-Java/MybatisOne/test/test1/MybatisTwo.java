package test1;

import com.itcast.mybatis.mapper.UserMapper;
import com.itcast.mybatis.po.User;
import com.itcast.mybatis.po.UserCustom;
import com.itcast.mybatis.po.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/22.
 */
public class MybatisTwo {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindUserById() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象,Mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(7487);
        System.out.println(user);
    }

    @Test
    public void testFindUserByName() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findUserByName("E");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindUserByPara() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setEname("JO");
        userCustom.setJob("CLERK");
        List<Integer> list = new ArrayList<Integer>();
        list.add(7936);
        list.add(7937);
        userQueryVo.setEmpnos(list);
        userQueryVo.setUserCustom(userCustom);

        List<UserCustom> users = userMapper.findUserByPara(userQueryVo);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindUserCount() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setEname("JO");
        userCustom.setJob("CLERK");
        List<Integer> list = new ArrayList<Integer>();
        list.add(7936);
        list.add(7937);
        userQueryVo.setEmpnos(list);
        userQueryVo.setUserCustom(userCustom);
        int count = userMapper.findUserCount(userQueryVo);
        System.out.println(count);
    }


}
