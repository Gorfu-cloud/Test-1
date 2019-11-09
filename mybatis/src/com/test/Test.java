package com.test;

import com.test.pojo.Page;
import com.test.pojo.TestTbUserLoginLog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Test {

    private SqlSessionFactory sessionFactory;
    @Before
    public void init(){
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void GetSession(){
        SqlSession session = sessionFactory.openSession();
        System.out.println(session);
    }
    public void insert (){
        //时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        SqlSession session = sessionFactory.openSession();
        TestTbUserLoginLog userLoginLog = null;
        try {
            userLoginLog = new TestTbUserLoginLog("666",sdf.parse("2019-11-1"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int result = session.insert("com.test.mapper.TestUserLoginLogMapper.insert",userLoginLog);
        System.out.println("操作成功，数据增加：" + result);
        System.out.println(userLoginLog.getId());
        session.commit();
        session.close();
    }

    public  void selectAll(){
        SqlSession session = sessionFactory.openSession();
        TestTbUserLoginLog userLoginLog = new TestTbUserLoginLog();
        List<TestTbUserLoginLog> books = session.selectList("com.test.mapper.TestUserLoginLogMapper.getAll");
        books.stream().forEach(System.out::println);
        session.close();
    }
    public TestTbUserLoginLog getOne(int id){
        SqlSession session = sessionFactory.openSession();
        TestTbUserLoginLog userLoginLog = new TestTbUserLoginLog();
        List<TestTbUserLoginLog> userLoginLogs = session.selectList("com.test.mapper.TestUserLoginLogMapper.getById",id);
        for (TestTbUserLoginLog t : userLoginLogs){
            userLoginLog = t;
        }
        session.close();
        return userLoginLog;
    }
    public void deleteOne(){
        SqlSession session = sessionFactory.openSession();
        session.delete("com.test.mapper.TestUserLoginLogMapper.deleteById",5);
        session.commit();//删除执行
        session.close();
    }

    public void getBookByPage(){
        SqlSession session = sessionFactory.openSession();
        Page page = new Page(1,2);
        List<TestTbUserLoginLog> books =
                session.selectList("com.test.mapper.TestUserLoginLogMapper.selectByPage",page);
        books.stream().forEach(System.out::println);
    }

    public void update(int id){
        SqlSession session = sessionFactory.openSession();
        TestTbUserLoginLog userLoginLog = getOne(id);
        System.out.println(userLoginLog.getUserName());
        userLoginLog.setUserName("haha");
        session = sessionFactory.openSession();
        session.update("com.test.mapper.TestUserLoginLogMapper.update",userLoginLog);
        session.commit();
        selectAll();
    }
    public static void main(String[] args) {
        Test test = new Test();
        test.init();
        test.update(2);
    }
}
