package com.wby.dao;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.wby.bean.User;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wby on 2018/3/15.
 */

/*
* 获取数据库用户表信息
* */
public class UserDao {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    public UserDao() {
        connection= (Connection) new com.wby.DBUtil.Conn().getCon();
    }

    /**
     * 验证用户合法性
     * @param user
     * @return
     */
    public boolean valiUser(User user) {
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement("select * from t_user where username=? and password=?");
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return true;
            } else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
}