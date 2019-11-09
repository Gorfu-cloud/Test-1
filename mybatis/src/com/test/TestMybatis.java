package com.test;

import com.test.mapper.AdminLoginLogMapper;
import com.test.mapper.UserLoginLogMapper;
import com.test.pojo.Page;
import com.test.pojo.adminLoginLog;
import com.test.pojo.userLoginLog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        UserLoginLogMapper mapper = session.getMapper(UserLoginLogMapper.class);
//        AdminLoginLogMapper adminmapper = session.getMapper(AdminLoginLogMapper.class);
        /*对登录日志表的增删改查操作*/
          /*用户登录日志包操作*/
//        add(mapper);
//        delete(mapper);
//        get(mapper);
//        update(mapper);
//        listAll(mapper);
        listPage(mapper);

          /*管理员登录日志包操作*/
//        adminAdd(adminmapper);
//        delete(mapper);
//        get(mapper);
//        update(mapper);
//        adminlistPage(adminmapper);
//        adminListAll(adminmapper);

        session.commit();
        session.close();

    }
/*用户*/
    private static void update(UserLoginLogMapper mapper) {
        userLoginLog c= mapper.get(1);
        c.setUserName("修改了的用户登录日志");
        mapper.update(c);
        listAll(mapper);
    }

    private static void get(UserLoginLogMapper mapper) {
        userLoginLog c= mapper.get(1);
        System.out.println("用户名："+c.getUserName()+"  创建时间："+c.getCreateTime()+"  修改时间："+c.getUpdateTime());
    }

    private static void delete(UserLoginLogMapper mapper) {
        mapper.delete(2);
        listAll(mapper);
    }

    private static void add(UserLoginLogMapper mapper) {
        userLoginLog c = new userLoginLog();
        c.setUserName("新增用户的登录日志");
        mapper.add(c);
        listAll(mapper);
    }
    private static void listPage(UserLoginLogMapper mapper) {
        Page page = new Page(1,2);
        List<userLoginLog> cs = mapper.listPage(page);
        for (userLoginLog c : cs) {
            System.out.println("用户名：" + c.getUserName() + "  创建时间：" + c.getCreateTime() + "  修改时间：" + c.getUpdateTime());
        }
    }
    private static void listAll(UserLoginLogMapper mapper) {
        List<userLoginLog> cs = mapper.list();
        for (userLoginLog c : cs) {
            System.out.println("用户名：" + c.getUserName() + "  创建时间：" + c.getCreateTime() + "  修改时间：" + c.getUpdateTime());
        }
    }

    private static void adminUpdate(AdminLoginLogMapper mapper) {
        adminLoginLog c= mapper.get(1);
        c.setUserName("修改了的管理员登录日志");
        mapper.update(c);
        adminListAll(mapper);
    }

    private static void adminGet(AdminLoginLogMapper mapper) {
        adminLoginLog c= mapper.get(1);
        System.out.println("管理员："+c.getUserName()+"  创建时间："+c.getCreateTime()+"  修改时间："+c.getUpdateTime());
    }

    private static void adminDelete(AdminLoginLogMapper mapper) {
        mapper.delete(2);
        adminListAll(mapper);
    }

    private static void adminAdd(AdminLoginLogMapper mapper) {
        adminLoginLog c = new adminLoginLog();
        c.setUserName("新增管理员的登录日志");
        mapper.add(c);
        adminListAll(mapper);
    }
    private static void adminlistPage(AdminLoginLogMapper mapper) {
        Page page = new Page(1,2);
        List<adminLoginLog> cs = mapper.listPage(page);
        for (adminLoginLog c : cs) {
            System.out.println("用户名：" + c.getUserName() + "  创建时间：" + c.getCreateTime() + "  修改时间：" + c.getUpdateTime());
        }
    }
    private static void adminListAll(AdminLoginLogMapper mapper) {
        List<adminLoginLog> cs = mapper.list();
        for (adminLoginLog c : cs) {
            System.out.println("管理员："+c.getUserName()+"  创建时间："+c.getCreateTime()+"  修改时间："+c.getUpdateTime());
        }
    }
}