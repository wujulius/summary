# spring组成模块

![spring组成模块](img\spring组成模块.png)

## spring组成模块

    核心容器（SpringCore）
    核心容器提供Spring框架的基本功能。spring以bean的方式组织和管理Java应用的各个组件及其关系，spring使用BeanFactory来产生和管理Bean，是工厂模式的实现，BeanFactory使用控制反转（IoC）模式将应用的配置和依赖性规范与实际的应用程序代码分开
    
    应用上下文（Spring Context）
    Spring上下文（javaBean容器）是一个配置文件，向spring提供上下文信息，spring上下文包括企业服务、、、、
    Spring面向切面编程（Spring AOP）
    AOP（Aspect Oriented Programming）
    通过配置管理特性，SpringAOP模块直接将面向方法的编程功能集成在了Spring框架中，Spring管理的任何对象都支持AOP，SpringAOP模块基于Spring的应用程序中的对象提供了事务管理服务，通过使用SpringAOP，不用依赖EJB组件，就可以将声明性事务管理集成在应用程序中
    JDBC和DAO模块（Spring DAO）
    Dao（Data Access Object）
    JDBC、DAO的抽象层，提供了有意义的异常层次结构实现，可用该结构来管理异常处理，和不同数据库提供商抛出的错误信息，异常层次结构简化了错误处理，并且极大的降低了需要编写的代码数量，比如打开和关闭链接。
    对象实体映射（Spring ORM）
    ORM（Object Relational Mapping）
    Spring插入了若干个ORM框架，提供了ORM对象的关系工具，其中包括Hibernate，JDO和IBatisSQL Map等，所有这些都遵从Spring的通用事务和DAO异常层次结构
    Web模块（Spring Web）
    web上下文模块建立应用程序上下文模块之上，基于web的应用程序提供了上下文，所以spring框架支持与Struts集成，web模块还简化了处理多部分请求以及将请求参数绑定到域对象的工作
    MVC模块（SpringWebMVC）
    MVC（Model View Controller）
    MVC框架是一个全功能的构建Web应用程序的MVC实现，通过策略接口，MVC框架编程高度可配置的，MVC容纳了大量视图技术，其中包括JSP，POI等，模型由JavaBean来构成，存放于m当中，而视图是一个接口，负责实现模型，控制器表示逻辑代码，由c的事情。spring框架的功能可以用在任何J2EE服务器当中，大多数功能也适用于不受管理的环境，spring的核心要点就是支持不绑定到特定J2EE服务的可重用业务和数据的访问对象，毫无疑问这样的对象可以在不同的J2EE环境，独立应用程序和测试环境之间重用

## spring使用的设计模式

   工厂设计模式 : Spring使用工厂模式通过 BeanFactory、ApplicationContext 创建 bean 对象。
    代理设计模式 : Spring AOP 功能的实现。
    单例设计模式 : Spring 中的 Bean 默认都是单例的。
    模板方法模式 : Spring 中 jdbcTemplate、hibernateTemplate 等以 Template 结尾的对数据库操作的类，它们就使用到了模板模式。
    包装器设计模式 : 我们的项目需要连接多个数据库，而且不同的客户在每次访问中根据需要会去访问不同的数据库。这种模式让我们可以根据客户的需求能够动态切换不同的数据源。
    观察者模式: Spring 事件驱动模型就是观察者模式很经典的一个应用。
    适配器模式 :Spring AOP 的增强或通知(Advice)使用到了适配器模式、spring MVC 中也是用到了适配器模式适配Controller。
###  核心容器
   包括 Core、Beans、Context、EL模块。
    Core模块
    封装了框架依赖的最底层部 分，包括资源访问、类型转换及一些常用工具类。

    Beans模块
    提供了框架的基础部分，包括反 转控制和依赖注入。其中 BeanFactory是容器核心，本质是“工厂设计模式”的实现，而且无需

    编程实现“单例设计模式”，单例完全由容器控制，而且提倡面向接口编程，而非面向实现编程；

    所有应用程序对象及对象间关系由框架管理，从而真正把你从程序逻辑中把维护对象之间的依赖

    关系提取出来，所有这些依赖关系都由 BeanFactory来维护。

    Context模块：
    以 Core和 Beans为基 础，集成 Beans模块功能并添加资源绑定、数据验证、国际化、JavaEE支持、容器生命周期、事 件传播等；核心接口是 ApplicationContext。

    EL模块：
    提供强大的表达式语言支持，支持访问和修 改属性值，方法调用，支持访问及修改数组、容器和索引器，命名变量，支持算数和逻辑运算，

    支持从 Spring容器获取 Bean，它也支持列表投影、选择和一般的列表聚合等。
    AOP、Aspects模块
    AOP模块
    SpringAOP模块提供了符合 AOPAlliance规范的面向方面的编 程（aspect-orientedprogramming）实现，提供比如日志记录、权限控制、性能统计等通用功能和业

    务逻辑分离的技术，并且能动态的把这些功能添加到需要的代码中；这样各专其职，降低业务逻

    辑和通用功能的耦合。

    Aspects模块
    提供了对 AspectJ的集成，AspectJ提供了比 SpringASP更强

    大的功能。数据访问/集成模块：该模块包括了 JDBC、ORM、OXM、JMS和事务管理。事务模块：

    该模块用于 Spring管理事务，只要是 Spring管理对象都能得到 Spring管理事务的好处，无需在代

    码中进行事务控制了，而且支持编程和声明性的事务管理。

    JDBC模块
    提供了一个 JBDC的样例模板，使用这些模板能消除传统冗长的 JDBC编码还有

    必须的事务控制，而且能享受到 Spring管理事务的好处。ORM模块：提供与流行的“对象-关系”

    映射框架的无缝集成，包括 Hibernate、JPA、MyBatis等。而且可以使用 Spring事务管理，无需额

    外控制事务。

    OXM模块
    提供了一个对 Object/XML映射实现，将 java对象映射成 XML数据，或者将 XML

    数据映射成 java对象，Object/XML映射实现包括 JAXB、Castor、XMLBeans和 XStream。

    JMS模块
    用于 JMS(JavaMessagingService)，提供一套“消息生产者、消息消费者”模板用于 更加简单的使用 JMS，JMS用于用于在两个应用程序之间，或分布式系统中发送消息，进行异步

    通信。

    Web/Remoting模块
    Web/Remoting模块包含了 Web、Web-Servlet、Web-Struts、Web-Porlet模 块。

    Web模块
    提供了基础的 web功能。例如多文件上传、集成 IoC容器、远程过程访问（RMI、

    Hessian、Burlap）以及 WebService支持，并提供一个 RestTemplate类来提供方便的 Restfulservices

    访问。

    Web-Servlet模块
    提供了一个 SpringMVCWeb框架实现。SpringMVC框架提供了基于注解的

    请求资源注入、更简单的数据绑定、数据验证等及一套非常易用的 JSP标签，完全无缝与 Spring

    其他技术协作。

    Web-Struts模块
    提供了与 Struts无缝集成，Struts1.x和 Struts2.x都支持

    Test模块
    Spring支持 Junit和 TestNG测试框架，而且还额外提供了一些基于 Spring的测试功能，比如在测试 Web框架时，模拟 Http请求的功能。
# Spring 的四大模块及典型的设计模式

　　1、Spring IOC   工厂模式、单例模式、装饰器模式。

　　2、Spring AOP  代理模式、观察者模式

　　3、Spring MVC  委派模式、适配器模式

　　4、Spring JDBC 模板方法模式
# spring(context)容器对象
## 生命周期
    1. 初始化
    2. 启动
    3. 运行
    4. 关闭/销毁
##  生命周期存在于refresh方法中
    spring 启动其实就是调用 AbstractApplicationContext #refresh 完成 spring context 的初始化和启动过程。spring context 初始化从开始到最后结束以及启动，这整个过程都在 refresh 这个方法中。
    refresh 方法刚开始做的是一些 spring context 的准备工作，也就是 spring context 的初始化，比如：创建 BeanFactory、注册 BeanFactoryPostProcessor 等，只有等这些准备工作做好以后才去开始 spring context 的启动。
~~~~java
public void refresh() throws BeansException, IllegalStateException {
        synchronized(this.startupShutdownMonitor) {
            StartupStep contextRefresh = this.applicationStartup.start("spring.context.refresh");
            this.prepareRefresh();
            ConfigurableListableBeanFactory beanFactory = this.obtainFreshBeanFactory();
            this.prepareBeanFactory(beanFactory);

            try {
                this.postProcessBeanFactory(beanFactory);
                StartupStep beanPostProcess = this.applicationStartup.start("spring.context.beans.post-process");
                this.invokeBeanFactoryPostProcessors(beanFactory);
                this.registerBeanPostProcessors(beanFactory);
                beanPostProcess.end();
                this.initMessageSource();
                this.initApplicationEventMulticaster();
                this.onRefresh();
                this.registerListeners();
                this.finishBeanFactoryInitialization(beanFactory);
                this.finishRefresh();
            } catch (BeansException var10) {
                if (this.logger.isWarnEnabled()) {
                    this.logger.warn("Exception encountered during context initialization - cancelling refresh attempt: " + var10);
                }

                this.destroyBeans();
                this.cancelRefresh(var10);
                throw var10;
            } finally {
                this.resetCommonCaches();
                contextRefresh.end();
            }

        }
    }
protected void prepareRefresh() {
        this.startupDate = System.currentTimeMillis();
        this.closed.set(false);
        this.active.set(true);
        if (this.logger.isDebugEnabled()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Refreshing " + this);
            } else {
                this.logger.debug("Refreshing " + this.getDisplayName());
            }
        }

        this.initPropertySources();
        this.getEnvironment().validateRequiredProperties();
        if (this.earlyApplicationListeners == null) {
            this.earlyApplicationListeners = new LinkedHashSet(this.applicationListeners);
        } else {
            this.applicationListeners.clear();
            this.applicationListeners.addAll(this.earlyApplicationListeners);
        }

        this.earlyApplicationEvents = new LinkedHashSet();
    }
~~~~
## servletContext和applicationcontext
    主要用来处理servlet
    servletcontext容器是javax.servlet
    ServletContext同Web容器通信通过servlet容器；
    applicationcontext容器是spring容器的顶级父类
    applicationcontext 实现了lisablebeanfactory而其又实现了beanfactory

## 事件监听器
### 事件监听三要素
    事件源：事件对象的产生者，任何一个事件都有一个来源
    ApplicationEvent

    事件监听器：事件框架或组件收到一个事件后，需要通知所有相关的事件监听器来进行处理。这些监听器统一存储在事件监听器注册表中。
    ApplicationListener（编码式事件监听器）
    @EventListener（注解式事件监听器）

    发布事件：ApplicationContext（spring容器）
### 监听器的作用：
    在启动Web 容器时，自动装配Spring applicationContext.xml 的配置信息。
    监听器去获取Spring的配置文件，然后从中拿出我们需要的bean出来，比如做网站首页，假设商品的后台业务逻辑都做好了，我们需要创建一个监听器，在项目启动时将首页的数据查询出来放到application里，即在监听器里调用后台商品业务逻辑的方法，也就是说我们需要在监听器里获取Spring中配置的相应的bean。

    https://blog.csdn.net/cnctcom/article/details/53470987?ops_request_misc=&request_id=&biz_id=102&utm_term=spring%20%E7%9B%91%E5%90%AC%E5%99%A8%E7%9A%84%E4%BD%9C%E7%94%A8%E4%BD%BF%E7%94%A8%E6%9D%A5%E8%8E%B7%E5%8F%96bean%E5%AF%B9%E8%B1%A1&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduweb~default-0-53470987.142^v47^pc_rank_34_default_23,201^v3^control&spm=1018.2226.3001.4187

    contextloaderlistener监听器继承了contextloader实现了servletlistener
    public class ContextLoaderListener extends ContextLoader implements ServletContextListener {
## 创建bean对象的四种方式
    spring创建bean对象的四种方式：
        1.使用默认的构造函数创建bean对象（通过 BeanFactory 或 ApplicationContext 创建 bean 对象）
        2.通过静态工厂方法创建bean
        3.通过实例工厂方法创建bean
        4.实现FactoryBean接口

## aop会存在循环依赖问题
    解决方案：
        三层缓存机制
        循环依赖的概念：

        https://blog.csdn.net/dafeng_xiaobai/article/details/117303856?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522166341256816800192256788%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=166341256816800192256788&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v1~pc_rank_34-1-117303856-null-null.142^v47^pc_rank_34_default_23,201^v3^control&utm_term=aop%E5%BE%AA%E7%8E%AF%E4%BE%9D%E8%B5%96%E6%A6%82%E5%BF%B5&spm=1018.2226.3001.4187

    三级缓存：
        第一级缓存：（单例池）
        第二级缓存：（）
        第三级缓存：
            类的实例化是指创建一个类的实例(对象)的过程；
            类的初始化是指为类中各个类成员(被static修饰的成员变量)赋初始值的过程，是类生命周期中的一个阶段。
