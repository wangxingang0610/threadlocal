package com.tl.demo3.account.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtils {
    // c3p0 数据库连接池对象属性
    private static final ComboPooledDataSource ds = new ComboPooledDataSource();
    // 获取连接
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    //释放资源
    public static void release(AutoCloseable... ios){
        for (AutoCloseable io : ios) {
            if(io != null){
                try {
                    io.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void commitAndClose(Connection conn) {
        try {
            if(conn != null){
                //提交事务
                conn.commit();
                //释放连接
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollbackAndClose(Connection conn) {
        try {
            if(conn != null){
                //回滚事务
                conn.rollback();
                //释放连接
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
