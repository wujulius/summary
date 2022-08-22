
# 使用步骤：

## 步骤一：添加Durid依赖

~~~~xml
       <!-- https://mvnrepository.com/artifact/com.alibaba/druid -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.2.11</version>
        </dependency>
~~~~

## 步骤二：使用Druid来定义一个JDBCutils方法

~~~~java
package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCutils {
     public  static Connection con ;
     public static DataSource dataSource;

   static  {

        //获取配置文件对象
        InputStream in =null;

        try {
            //将druid配置文件加载
            //获取配置文件的class字节流
            in = JDBCutils.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties properties = new Properties();
            properties.load(in);
            //调用Druid工厂模式创建连接池对象
           dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
//定义一个从连接池对象总获取连接的方法
    public static Connection getCon() {
        try {
            con = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    //定义一个关流的方法
    //将dao层使用到的对象关闭
    public static void closeStream(Connection con, Statement statement, ResultSet resultSet){
        try {
            if (resultSet !=null){
                resultSet.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (con!=null){
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
~~~~

## 步骤三：dao层调用getcon获取连接对象进行数据库操作

~~~~java
package com;

import util.JDBCutils;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet( urlPatterns = "/register",loadOnStartup = 1,name = "as",displayName = "s")
public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //获取连接池对象
        //创建预编译对象
        Connection con = JDBCutils.getCon();
        PreparedStatement statement = null;

        try {
            //定义sql语句
            String sql = "insert into user_table values(?,?,?,?) ";
            statement = con.prepareStatement(sql);
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            statement.setString(1, null);
            statement.setString(2, userName);
            statement.setString(3, password);
            statement.setString(4, email);
            int i;
            i = statement.executeUpdate();
            PrintWriter printWriter = response.getWriter();
            response.setContentType("text/html;CharacterEncoding =utf8");


            if (i == 1) {
                printWriter.print("<script>alert('注册成功')</script>");
            } else {
                printWriter.print("<script>alert('注册失败')</script>");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCutils.closeStream(con, statement, null);
        }
    }
}