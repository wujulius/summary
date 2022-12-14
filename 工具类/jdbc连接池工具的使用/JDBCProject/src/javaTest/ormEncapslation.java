package javaTest;

import util.JDBCutils2;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ormEncapslation {
    //使用jdbc持久层框架
    //案例一：
    //查询uid=1的数据信息，封装到user对象中
    //步骤一：
    //创建一个一个user类
    //步骤二：
    //执行查询，遍历结果集，取出每个表的字段
    //步骤三：
    //定义资源对象：
    //查询表中所有数据封装到list<user>
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet =null;
        List<User> users = new ArrayList<>();
        try {
            con = JDBCutils2.getConnection();
            String sql = "select * from dept ";
            //statement = con.createStatement();
           statement = con.prepareStatement(sql);
            //statement.setString(1,"10");
            resultSet = statement.executeQuery();

            int row = resultSet.getRow();
            while(resultSet.next()){
                User user  = new User();
                if(resultSet!=null){
                    int id = resultSet.getInt("id");
                    String dname = resultSet.getString("dname");
                    String loc = resultSet.getString("loc");
                    user.setId(id);
                    user.setDname(dname);
                    user.setLoc(loc);
                    users.add(user);
                }

            }
            for (int i = 0; i < users.size(); i++) {
                System.out.println("用户"+users.get(i));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCutils2.setClose(resultSet,statement,con);
        }
    }



}
//实现步骤：
    //步骤一：
    //获取元数据
    //步骤二：
    //获取内省数据
    //步骤三：
    //使用反射对元数据和内省数据进行一一匹配

class User{
    private int id= 0;
    private  String dname = null;
    private  String loc = null;
    public User(){

    }

    public User(int id, String dname, String loc) {
        this.id = id;
        this.dname = dname;
        this.loc = loc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}
