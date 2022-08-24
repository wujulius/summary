package util;

import java.sql.*;

public class JDBCutils {
          private static   Statement statement =null;
          private static    ResultSet resultSet = null;
          private  static String className;
          private  static String url;
          private  static String username;
          private  static String password;
    //静态代码块优先加载且只加载一次
          static {
                  className = "com.mysql.cj.jdbc.Driver";
                  url = "jdbc:mysql:///test2";
                  username = "root";
                  password = "aini6212838.";
          }

//对驱动器的加载以及数据库的连接方法进行封装
//定义一个获取连接对象的方法
   public static Connection getConnection(){
       Connection con = null;
       try {
           //获取mysql驱动器字节码文件
            Class.forName(className);
            //获取连接对象
            con = DriverManager.getConnection(url,username,password);
       } catch (Exception e) {
           e.printStackTrace();
       }
        return con;
   }
   //定义一个关流方法
    public  static void setClose(ResultSet resultSet, Statement statement, Connection con){
        try {
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(con != null){
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}