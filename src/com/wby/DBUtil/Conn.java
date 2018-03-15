package com.wby.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by wby on 2018/3/15.
 */

/**
 * 获取数据库连接类
 */
public class Conn {

    /**
     * 获取连接
     * @return
     */
    public  Connection getCon(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost/user?useUnicode=true&characterEncoding=utf-8";
            String user="root";
            String password="root";
            Connection conn=DriverManager.getConnection(url, user, password);
            System.out.println(conn.getMetaData().getURL());
            return conn;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 释放连接
     * @param con
     * @throws Exception
     */
    public void closeCon(java.sql.Connection con) throws Exception {
        if(con != null) {
            con.close();
        }

    }
}
