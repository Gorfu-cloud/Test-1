package com.test.mapper;

import com.test.pojo.Page;
import com.test.pojo.userLoginLog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
//用户登录日志，数据库操作接口
public interface UserLoginLogMapper {
    @Insert(" insert into tb_user_login_log ( userName ) values (#{userName}) ")
    public int add(userLoginLog category);

    @Delete(" delete from tb_user_login_log where pk_id= #{id} ")
    public void delete(int id);

    @Select("select * from tb_user_login_log where pk_id= #{id} ")
    public userLoginLog get(int id);

    @Update("update tb_user_login_log set userName=#{userName} where pk_id=#{id} ")
    public int update(userLoginLog category);

    @Select("select * from tb_user_login_log limit #{start},#{size}")
    public List<userLoginLog> listPage(Page page);

    @Select(" select * from tb_user_login_log ")
    public List<userLoginLog> list();
}
