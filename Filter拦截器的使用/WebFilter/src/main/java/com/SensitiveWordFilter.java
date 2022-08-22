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

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //使用代理设计对getparameter进行增强
        //实现步骤：
        //步骤一：获取要增强的对象
        //步骤二：获取实现的接口
        //步骤三：重写动态接口invoke方法以增强原方法
        //获取代理对象的三个参数分别为classloader，interface，handler
        System.out.println("拦截成功");
        HttpServletRequest hRequest = (HttpServletRequest) request;
        ClassLoader cl = this.getClass().getClassLoader();
        Class[] cls = hRequest.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //获取该方法的名称
                //判断该方法的名称
                /*    System.out.println("进入方法体内");*/
                String methodName = method.getName();
                if (methodName.equalsIgnoreCase("getParameter")) {
                    String value = (String) method.invoke(hRequest, args);
                    value = WordInUtils.replaceWord(value, WordInUtils.getList());
                    /*           System.out.println("开始替换");*/
                    return value;
                }

                return method.invoke(request, args);
            }

        };
        //获取代理对象
        HttpServletRequest hrequest_Proxy = (HttpServletRequest) Proxy.newProxyInstance(cl, cls, invocationHandler);

        chain.doFilter(hrequest_Proxy, response);
    }

    public void destroy() {
    }

}
