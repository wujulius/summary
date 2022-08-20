# index.jsp

~~~~js

    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>$Title$</title>
    </head>
    <body>
    <form method="get" action="CommentServlet" >
        <%--<label></label><input></label>--%>
        <label><input name="comments" placeholder="请输入想要评论的内容"></label>
        <label><input type="submit"></label>
    </form>
    </body>
    </html>
~~~~

# servlet代码
~~~~java
    package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String comment = request.getParameter("comments");
            String username = request.getRemoteHost();
            //获取用户的ip地址
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
~~~~
# filter代码
~~~~java
    package com;

import Utils.WordInUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@WebFilter("/CommentServlet")
public class SensitiveWordFilter implements Filter {


    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
            //使用代理设计对getparameter进行增强
        //实现步骤：
        //步骤一：获取要增强的对象
        //步骤二：获取实现的接口
        //步骤三：重写动态接口invoke方法以增强原方法
        //获取代理对象的三个参数分别为classloader，interface，handler
        HttpServletRequest hRequest = (HttpServletRequest)request;
        ClassLoader cl = this.getClass().getClassLoader();
        Class[] cls = hRequest.getClass().getInterfaces();
        InvocationHandler invocationHandler =new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
               //获取该方法的名称
                //判断该方法的名称
                    String methodName =  method.getName();
                    if(methodName.equalsIgnoreCase("getParameter")){
                            String value = (String)method.invoke(hRequest,args);
                            value = WordInUtils.replaceWord(value,WordInUtils.getList());
                            return value;
                    }

                return method.invoke(request,args);
            }

        };
        //获取代理对象
        HttpServletRequest hrequest_Proxy = (HttpServletRequest) Proxy.newProxyInstance(cl,cls,invocationHandler);

        chain.doFilter(hrequest_Proxy, response);
    }
}
~~~~

# 工具类
~~~~java
package Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WordInUtils {
    //定义一个获取敏感词文档的工具类
    //将其读入list集合中
    //步骤：
    //步骤一：
    //创建一个list集合
    //创建一个字符流将获取的对象读入
    public static InputStream in = null;
    public static List<String> list = new ArrayList<>();
    public static List<String> getList(){
        in = WordInUtils.class.getClassLoader().getResourceAsStream("SensitiveWordFilter.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        //判断敏感词是否读完

        try {
           String word = br.readLine();
           list.add(word);
            while (word!=null){
                  word= br.readLine();
                if (word!=null&&word.length()>0){
                    list.add(word);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;

    }
    //书写敏感词替代方法
    public static String replaceWord(String value,List<String> list){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(value)){
                value = "******";
            }
        }
        return value;
    }
}
~~~~
    
