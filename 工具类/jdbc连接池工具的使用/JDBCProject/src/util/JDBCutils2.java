package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCutils2 {

        private static String  className = null;
        private static String  url = null;
        private  static String  username = null;
        private static String  password = null;

    static {
        /*Connection con = null;*/
        InputStream in = null;
        try {
            //获取配置文件对象的字节流
            //第一种方式：
            in = new FileInputStream("src/connect.properties");
            //第二种方式
            //in = JDBCutils2.class.getClassLoader().getResourceAsStream("connect.properties");
            //创建配置文件对象
            Properties properties = new Properties();
            //将配置文件进行加载
            properties.load(in);
            //获取配置文件对象的值：
            className = properties.getProperty("jdbc.className");
             url = properties.getProperty("jdbc.url");
             username = properties.getProperty("jdbc.username");
             password = properties.getProperty("jdbc.password");

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
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