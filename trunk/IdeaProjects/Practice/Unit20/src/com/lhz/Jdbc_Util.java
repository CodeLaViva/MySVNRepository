package com.lhz;

import java.sql.*;

/**
 * jdbc连接 postgreSQL数据库的工具类， 实现对数据库的连接和基本操作
 */
class Jdbc_Util {

    //数据库的基础参数设置
    private static final String user = "postgres";
    private static final String pass = "123";
    private static final String url =
            "jdbc:postgresql://127.0.0.1:5432/my_postgre";

    private static Connection connect() {
        Connection conn = null;
        try {
            //连接数据库 通过反射的方式
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, pass);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //数据库的查询操作
    static void query(String department){
        Connection conn= connect();
        String sql="select * from tb_emp where department = '" + department+ "'";
        Statement stmt=null;
        ResultSet rs=null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.print("姓名： " + rs.getString(1));

                System.out.print("\t性别： " + rs.getString(2));

                System.out.println("\t部门： " + rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //数据库的插入操作
    static boolean insert(){
        Connection conn= connect();
        String sql="insert into tb_stu values(?, ?, ?)";
        PreparedStatement stmt=null;
        boolean flag = false;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "李某");
            stmt.setString(2, "女");
            stmt.setDate(3, Date.valueOf("1999-10-20"));
            flag = stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
