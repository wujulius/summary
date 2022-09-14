## springMVC实现文件上传功能
    通过fileupload（apache提供的上传组件）实现
## 使用方法:
    导入依赖
    配置多媒体解析器
    书写表单测试类
        注意事项：
            提交数据为data
            提交方法为post
            input类型为文件
    书写controller
## 代码
步骤一：导入依赖
~~~~xml
    <dependency>
      <groupId>commons-fileupload</groupId>
      <artifactId>commons-fileupload</artifactId>
      <version>1.4</version>
    </dependency>
~~~~
步骤二：配置多媒体解析器
~~~~xml
    <!--配置多媒体解析器-->
    <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
        <!--解决中文乱码问题-->
        <property name="defaultEncoding" value="utf-8"/>
        <!--设置文件上传大小-->
        <property name="maxUploadSize" value="50000000000"/>
        <!--设置单个文件上传大小-->
        <property name="maxUploadSizePerFile" value="5000000000"/>
    </bean>
~~~~
步骤三：书写页面
~~~~java
<form action="/demo24" name="ds" method="post" enctype="multipart/form-data">
    <input type="file" name="multipartResolver">
    <input type="text" name="uid">
    <input type="submit">
</form>
~~~~
步骤四：书写controller
~~~~java
    @RequestMapping("/demo24")
    @ResponseBody
    public String test2(String uid, MultipartFile multipartResolver){
        /**/
        String originalFilename = multipartResolver.getOriginalFilename();
        String name = multipartResolver.getName();
        System.out.println(originalFilename+name+uid);
        return name;
    }
~~~~
## 总结：
    使用TransferTo进行文件的上传

## 自定义拦截器
### 拦截器执行流程
![执行流程](img/拦截器执行流程.png)
### 三个方法执行时机
    prehandle（在controller执行之前执行）
        boolean
        true ,表示还会执行下一个拦截器的prehandle
        flase，表示请求结束，后面的拦截器和controller都不会执行
    postHandle(在controller执行之后执行)
    afterCompletion（在controller执行之后和在未提交到视图解析器之前执行）
### 实现步骤
步骤一：自定义一个拦截器类，实现拦截器规范
步骤二:在mvc配置文件中对其进行配置
步骤三：定义一个controller测试类
### 代码
步骤一:
~~~~java
package com.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//自定义拦截器
public class TestInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String name = handler.getClass().getName();
        System.out.println(name);
        System.out.println("在controller方法前执行");
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("在controller方法后执行");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("在提交到spring中央控制器后，在提交到视图解析器之前执行");
    }
}

~~~~
步骤二：
~~~~xml
    <!--配置拦截器-->
    <mvc:interceptors>
        <mvc:interceptor>
            <!--配置拦截路径-->
            <mvc:mapping path="/test"/>
            <!--配置自定义拦截器bean对象-->
            <bean class="com.interceptor.TestInterceptor"/>
        </mvc:interceptor>
    </mvc:interceptors>
~~~~
步骤三:
~~~~java
package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestInterceptorWithController {
    @RequestMapping("/test")
    public void test1(){
        System.out.println("这是controller执行方法");
    }
}
~~~~
## 异常处理器：
### 异常处理器的种类
    简单异常处理器
    自定义异常处理器
    默认异常处理器
#### 简单异常处理器的使用
    步骤一：配置异常处理器
    步骤二：对自定义的异常处理器进行配置
    步骤三：创建异常测试类
    
##### 代码实现
步骤一：配置简单异常处理器
~~~~xml
    <!--配置异常处理器-->
    <bean id="exceptionResolver" class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
        <property name="defaultErrorView" value="error"/>
        <property name="exceptionMappings" >
            <map><!--map集合由多个entry组成-->
                <!--异常类型为key--><!--视图为value-->
                <entry key="java.lang.ArithmeticException" value="error2"/>
            </map>
        </property>
    </bean>
~~~~
步骤二：创建异常测试类
~~~~java
package com.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class TestControllerWithExceptionHandler {
    @RequestMapping("/demo2444")
    public void test1(){
        int i= 1/0;
        System.out.println("这是异常测试");
    }
}
~~~~    
#### 自定义异常处理器的使用
    步骤一：创建一个自定义异常处理器
    步骤二：创建一个异常测试类将异常抛出  
##### 代码实现：
 步骤一：创建一个自定义异常处理器
~~~~java
package com.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//自定义异常处理器
public class TestExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        String message = e.getMessage();
        /*MddelAndView默认使用request域对象*/
        ModelAndView modelAndView = new ModelAndView();
        /*将数据传到前台*/
        System.out.println(message);
        modelAndView.addObject("error",message);
       modelAndView.setViewName("error3");
        return modelAndView;
    }
}

~~~~
步骤二：配置自定义异常处理器
~~~~xml
 <bean id="exceptionHandler" class="com.exception.TestExceptionHandler"/>
~~~~
步骤三:创建一个异常类来测试
~~~~java
package com.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestControllerWithDefinationExceptionHandler {
    @RequestMapping("/demo266")
    public void test1(){
        try{
            int i= 1/0;
        }catch (Exception e){
            e.printStackTrace();
            throw  new ArithmeticException("分母不能为0");
            //java自带的异常不需要在方法上进行声明
        }finally {
            System.out.println("这是异常测试");
        }
    }
}

~~~~