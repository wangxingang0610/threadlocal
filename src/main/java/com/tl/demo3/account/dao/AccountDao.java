package com.tl.demo3.account.dao;

import com.tl.demo3.account.utils.JdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDao {

    public void out(String outUser, int money) throws SQLException {
        String sql = "update account set money = money - ? where name = ?";
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,money);
        pstm.setString(2,outUser);
        pstm.executeUpdate();

        JdbcUtils.release(pstm,conn);
    }

    public void in(String inUser, int money) throws SQLException {
        String sql = "update account set money = money + ? where name = ?";
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,money);
        pstm.setString(2,inUser);
        pstm.executeUpdate();

        JdbcUtils.release(pstm,conn);
    }
}
