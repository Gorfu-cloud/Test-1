package com.test.pojo;
/*
数据表创建：
CREATE TABLE tb_admin_login_log (
  pk_id int(11) NOT NULL AUTO_INCREMENT,
  userName varchar(255) DEFAULT NULL,
  createTime datetime,
  updateTime timestamp,
  PRIMARY KEY (pk_id)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
 */

public class adminLoginLog {
    int id;
    String adminName;
    String createTime;
    String updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return adminName;
    }

    public void setUserName(String adminName) { this.adminName = adminName; }

    public String getCreateTime() {return createTime; }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "tb_admin_login_log [pk_id=" + id + ", adminName=" + adminName + ", createTime=" + createTime +", updateTiem=" + updateTime +"]";
    }
}
