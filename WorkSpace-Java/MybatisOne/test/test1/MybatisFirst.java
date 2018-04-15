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

    //����empno��ѯ�û���Ϣ���õ�һ����¼�Ľ��
    @Test
    public void findUserByIdTest() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        ͨ��Sqlsession�������ݿ�
//        ��һ��������ӳ���ļ���statement��id������namespace+"."+statement��id
//        �ڶ���������ָ����ӳ���ļ�����ƥ���parameterType���͵Ĳ���
//        sqlSession.selectOne()�������ӳ���ļ�����ƥ���resultType���͵Ķ���
//        selectOne��ʾ��ѯ��һ����¼
        User user = sqlSession.selectOne("findUserById", 7499);

        System.out.println(user);
        //�ͷ���Դ
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
        //list�е�user��ӳ���ļ���resultType��ָ��������һ��
        session.insert("addUser", user);
        System.out.println(user.getEmpno());
        //�ύ����
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
        //�ύ����
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
        //list�е�user��ӳ���ļ���resultType��ָ��������һ��
        session.update("updateUser", user);
        //�ύ����
        session.commit();

        session.close();
    }


}
