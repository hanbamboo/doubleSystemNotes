package com.shuangti;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.*;

/*
 * JDBC工具类
 * */
public class DruidUtils {
    //	public static final String url = "";
    //静态代码块,类加载的时候只执行一次，以后再也不执行了
    static DruidDataSource druidDataSource = null;
    static {
        druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://139.224.48.87:3306/mg?characterEncoding=utf-8&useSSL=false");
        druidDataSource.setUsername("mg");
        druidDataSource.setPassword("Qhx010394Mg");
        druidDataSource.setMaxActive(20);
    }

    /*
     * 获得连接
     * */
    public static Connection getCon() {
        Connection con = null;
        try {
            con = druidDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    /*
     * 释放资源
     * ResultSet
     * Statement或PrepareStatement
     * Connection
     * 释放资源有顺序 ResultSet->Statment或PrepareStatement->Connection
     * */
    public static void close(Connection con,
                             Statement stat, PreparedStatement pre, ResultSet ret) {
        if (ret != null) {
            try {
                ret.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (pre != null) {
            try {
                pre.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
