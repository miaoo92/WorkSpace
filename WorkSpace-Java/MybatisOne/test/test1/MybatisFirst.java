package test1;

import com.itcast.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/1/5.
 */

public class MybatisFirst {

    //根据empno查询用户信息，得到一条记录的结果
    @Test
    public void findUserByIdTest() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        通过Sqlsession操作数据库
//        第一个参数：映射文件中statement的id，等于namespace+"."+statement的id
//        第二个参数：指定和映射文件中所匹配的parameterType类型的参数
//        sqlSession.selectOne()结果是与映射文件中所匹配的resultType类型的对象
//        selectOne表示查询出一条记录
        User user = sqlSession.selectOne("findUserById", 7499);

        System.out.println(user);
        //释放资源
        sqlSession.close();


     /*   Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory ssf = sfb.build(reader);

        SqlSession session = ssf.openSession();
        System.out.println(session);

        session.close();*/

    }

    @Test
    public void testInsert() throws IOException {
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory ssf = sfb.build(reader);
        SqlSession session = ssf.openSession();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        User user = new User();
//        user.setEmpno(7487);
        user.setEname("JOHNOS");
        user.setMgr(7566);
        user.setJob("CLERK");
        user.setDeptno(20);
        user.setSal(4000);
        user.setHiredate(new Date());
        //list中的user和映射文件中resultType所指定的类型一致
        session.insert("addUser", user);
        System.out.println(user.getEmpno());
        //提交事务
        session.commit();

        session.close();
    }

    @Test
    public void findUserByName() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> list = sqlSession.selectList("findUserByName", "E");
        for(User user:list){
            System.out.println(user);
        }
        sqlSession.close();

    }

    @Test
    public void testDelete() throws IOException {
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory ssf = sfb.build(reader);
        SqlSession session = ssf.openSession();

        session.delete("deleteUser", 7935);
        //提交事务
        session.commit();

        session.close();
    }

    @Test
    public void testUpdate() throws IOException {
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory ssf = sfb.build(reader);
        SqlSession session = ssf.openSession();

        User user = new User();
        user.setEmpno(7487);
        user.setEname("JOHN");
        user.setMgr(7566);
        user.setJob("mgr");
        user.setDeptno(30);
        user.setSal(8000);
        user.setHiredate(new Date());
        //list中的user和映射文件中resultType所指定的类型一致
        session.update("updateUser", user);
        //提交事务
        session.commit();

        session.close();
    }


}
