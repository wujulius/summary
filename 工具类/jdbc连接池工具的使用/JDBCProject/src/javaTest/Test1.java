package javaTest;


import util.JDBCutils;
import util.JDBCutils2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test1 {
   private static Connection con = null;
   private static Statement statement = null;
   private static ResultSet resultSet = null;

    public static void main(String[] args) {


        con = JDBCutils2.getConnection();
        //定义sql语句
        String sql = "select * from dept";
        try {
            statement = con.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                if (resultSet!=null) {
                    int id = resultSet.getInt("id");
                    String dname = resultSet.getString("dname");
                    String loc = resultSet.getString("loc");
                    System.out.println("当前id为"+id+"当前部门为"+dname+"位于"+loc);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCutils2.setClose(resultSet,statement,con);
        }
    }
}
