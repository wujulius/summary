## 使用aop记录日志

    实现步骤：
        1.创建一个切面类，在其上添加@aspect和@component注解，
            接下来定义切点方法在其上添加@pointcut（）注解，在其中配置要拦截的路径
            execution（里面的参数与方法声明格式相一致，先是访问修饰符（用空格代替）接下来是返回值
            接下来是类的全路径

            书写增强方法：在其上可以添加@around@after@before@afterruning@afterthrowing
            增强方法中的参数可以为：（proceedingjointpoint）（joinpoint）
                joinpoint是proceedingjoinpoint的父类

        在其中进行日志记录：
            使用requestcontexthoder来进行request对象的获取（获取当前线程的request对象）
            使用request来获取session（session作用范围，一次浏览器启动，即存在）
            使用System.currentmils（）来获取当前时间（返回值为一个long类型的）
            使用Date date = new date（将生成的long类型数据放入其中进行转换）
            使用request的相应方法来获取访问ip地址以及访问方法路径
            使用session对象来获取当前session对象里面的值

        2.在配置文件对aop标签进行声明<aop:aspectj-autoproxy>配置aop代理
            以及在配置文件中开启包扫描

## 使用拦截器实现登陆校验功能

    首先在相应的controller中登陆方法中设置session对象，登陆在controller中进行校验
    拦截器拦截除登陆方法外的所有路径，在拦截器中判断session对象储存的用户名和密码是否正确，

    自定拦截器需要实现：handlerinterceptor

    在springmvc配置文件中添加自定义拦截器
        <mvc:interceptors>
            <mvc:interceptor>
                <bean class=“相应的拦截器类”>

    登陆方法：
        使用session.setAttribute（相应的bean对象），在其中设置全局域对象，用于拦截器校验
        调用service层的方法进行校验

## 定义日期转换器

    首先实现converter<被转换的数据类型，需要的数据类型>
      返回值为需要的数据类型  
        定义类型转换器
            simpleformat sf = new simpleformat（“”）其中为相应的日期格式，日期格式要和页面显示的效果相一致。
    
    在springmvc配置文件中配置日期转换器

    配置转换器的实现步骤：
      使用bean标签引入  先将格式化转换工厂bean对象引入（class） 定义id为 自定义类转化器的名字
        定义属性<property>在其中定义<set> set标签中引入相应的自定义类型转换器 

      在注解驱动中开启相应的转换器：<mvc:annonation-driven conversion-service：自定义转换器的id>

## 


    熟练使用spring，springboot，springmvc主流开发框架
    熟悉spring，springboot的设计原理
    

    熟悉MySQL，熟悉常用的sql语法及原理，具备数据库设计能力，掌握常用的调优方法
    
    有微服务的开发经验，对分布式、缓存、消息、搜索等机制有一定的了解

    精通java编程语言，熟练使用linux/unix操作系统，

    熟练使用数据库及中间件

    熟悉MySQL、redis、kafka、mongodb等常见存储的使用

    熟练使用 git 管理项目，有良好的代码习惯
    熟练使用idea开发工具，以及maven

    熟悉java基础技术体系，基础扎实，熟练掌握常用java技术框架