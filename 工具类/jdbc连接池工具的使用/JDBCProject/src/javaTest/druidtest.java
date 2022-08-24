package javaTest;

import com.alibaba.druid.pool.DruidDataSourceFactory;


import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class druidtest {
    public static void main(String[] args) throws IOException {
        Connection con = setDataBase();
    }
    public static Connection setDataBase() throws IOException {
        InputStream in = null;
        Connection con = null;
        try {

            in = druidtest.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties properties = new Properties();
            properties.load(in);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            con =dataSource.getConnection();
            System.out.println("连接成功");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("连接失败");
        } finally {
            in.close();
        }
return  con;
    }

}
