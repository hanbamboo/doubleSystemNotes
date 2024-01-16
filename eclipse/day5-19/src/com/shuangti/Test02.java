package com.shuangti;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test02 {
    public static void main(String[] args) throws SQLException {
        Connection connection = JdbcUtils.getCon();
        System.out.println(connection);
        PreparedStatement pps = connection.prepareStatement("INSERT INTO USERINFO (LNAME,SNAME,PWD)VALUES(?,?,?);");
        pps.setString(1,"e2424");
        pps.setString(2,"21241");
        pps.setString(3,"fs");
        long s = pps.executeUpdate();
        System.out.println(s);
    }
}
