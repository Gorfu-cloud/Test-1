package com.test.pojo;

import java.sql.Timestamp;
import java.util.Date;

/*
数据表创建：
CREATE TABLE test (
  pk_id int(11) NOT NULL AUTO_INCREMENT,
  userName varchar(255) DEFAULT NULL,
  gmt_create datetime,
  gmt_create timestamp,
  PRIMARY KEY (pk_id)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
 */

public class TestTbUserLoginLog {
    private int pk_id;

    private String userName;

    private Date gmt_create;

    private Timestamp gmt_modified;

    public TestTbUserLoginLog(String userName,Date gmt_create){
        this.userName = userName;
        this.gmt_create = gmt_create;
    }
    public TestTbUserLoginLog(){
    }

    public int getId() {
        return pk_id;
    }

    public void setId(int id) {
        this.pk_id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getgmt_create() {
        return gmt_create;
    }

    public void setgmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Timestamp getgmt_modified() {
        return gmt_modified;
    }

    public void setgmt_modified(Timestamp gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    @Override
    public String toString() {
        return "test [pk_id=" + pk_id + ", userName =" + userName + ", gmt_create=" + gmt_create +", gmt_modified=" + gmt_modified +"]";
    }
}
