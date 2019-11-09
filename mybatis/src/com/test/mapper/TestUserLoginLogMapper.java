package com.test.mapper;

import com.test.pojo.Page;
import com.test.pojo.TestTbUserLoginLog;

import java.util.List;

public interface TestUserLoginLogMapper {

     void insert (TestTbUserLoginLog userLoginLog);
     //全部查询
     List<TestTbUserLoginLog> getAll ();
     //单个查询
     TestTbUserLoginLog getById (int id);
     //通过id删除
     void deleteById (int id);
     // 通过id修改
     void update (TestTbUserLoginLog userLoginLog);
     //分页
     List<TestTbUserLoginLog> selectByPage (Page page);
}
