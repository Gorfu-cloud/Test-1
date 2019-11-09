package com.test.mapper;

import com.test.pojo.Page;
import com.test.pojo.adminLoginLog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
//用户登录日志，数据库操作接口
public interface AdminLoginLogMapper {
    @Insert(" insert into tb_admin_login_log ( adminName ) values (#{adminName}) ")
    public int add(adminLoginLog category);

    @Delete(" delete from tb_admin_login_log where pk_id= #{id} ")
    public void delete(int id);

    @Select("select * from tb_admin_login_log where pk_id= #{id} ")
    public adminLoginLog get(int id);

    @Update("update tb_admin_login_log set adminName=#{adminName} where pk_id=#{id} ")
    public int update(adminLoginLog category);

    @Select("select * from tb_admin_login_log limit #{start},#{size}")
    public List<adminLoginLog> listPage(Page page);

    @Select(" select * from tb_admin_login_log ")
    public List<adminLoginLog> list();
}
