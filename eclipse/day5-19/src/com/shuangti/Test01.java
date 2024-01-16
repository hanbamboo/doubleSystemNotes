package com.shuangti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
1.实现jdbc张三取钱1000块
2.张三给李四转1000块
 */
public class Test01 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pps = null;
        /*
        装载驱动
        获得连接
        处理sql
        执行sql
        释放资源
         */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/data_01?characterEncoding=utf-8", "root", "123456");
//            设置取消自动提交，前提是数据库支持事务
//            mysql数据库的Engine设置为innodb才支持事务
            conn.setAutoCommit(false);
            pps = conn.prepareStatement("update account set money=money-1000 where `name` = '张三'");
            pps.executeUpdate();
//            System.out.println(2 / 0);
            pps = conn.prepareStatement("update account set money=money+1000 where `name` = '李四'");
            pps.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

    }
}
