## Spring概述
    1.Spring用在业务层，
        Spring框架是一站式全栈（full-Stack）开发框架，
    2.为什么是全栈式开发框架：
        以spring为基础，研发了很多，dataJPA，security，mvc，jdbc
    3.Spring企业级开发：
        发展过程：
            一站式轻量级开发框架
            查阅时以index文件开始    
        IOC和AOP
            IOC（控制反转）：指的是bean对象的创建权交给spring容器管理
                前面写的刷题系统：直接创建对象会造成类之间的耦合，严重后果：不便于二次开发，不用手动创建bean对象，使用spring容器创建和管理bean对象
            优点：最大程度上减少了类与类之间的耦合关系，便于后期项目的二次迭代开发，interverse
            DI：（依赖注入）在一个bean对象中注入另一个bean对象，指的是从spring容器中取出一个bean对象注入另一个bean对象       
            DI是对IOC的简单诠释

            AOP：面向切面编程：可以对项目进行业务逻辑的处理，底层本质依赖动态代理，对接口中的方法进行增强，进行事务管理以及日志管理，
    4.Spring的使用方法：
        第一步：在controller中使用业务层对象：
            通过spring容器来管理和存储bean对象，
        第二步：通过容器中取出这个bean对象，注入controller中，
            （基于注解和配置文件进行注入）
    5.框架的优点：
        spring框架的优势：方便解耦和开发：

        aop编程支持（spring框架进行业务增强，具体体现：事务管理：日志管理等）    通过代理来实现日志的记录
        声明式事务的支持（底层基于aop实现）
        方便程序测试:(基于spring框架来整合junit对spring搭建的项目进行快速的单元测试)
        spring能够完美整合第三方的框架
        比如：单独使用mybatis时需要手动获取mapper对象，而使用spring框架
## ioc入门：
    1.ioc：不是一种技术，是一种设计思想，目的是用来设计出更加松耦合的程序
    2.入门开发：
            步骤一：在pom.xml配置spring容器依赖，名称为springcontext
                （统一spring框架的版本，避免同一个项目中，使用spring的全家通版本号不同，发生版本冲突）
                导入springbean依赖（${spirng.context，sspel表达式类似于el表达式}）
                添加指定maven项目的jdk编译版本
                通过bean标签进行来配置实现类
                id唯一的命名建议类名的首字母小写，后面正常书写，小驼峰命名规则
                class配置包名.类名来实现全路径
                
            步骤二：创建spring核心配置文件把bean对象配置到核心配置文件上
                配置文件：文档声明
                直接用idea创建xml文件
                通过约束文件能够写哪些标签


            步骤三：通过spring容器加载配置文件
                calsspathxmlapplicationcontext（“spring——core.xml”）
                加载配置文件的同时，容器会读取配置文件，初始化bean对象，存到容器中
                根据id名称获取bean对象
                只需要改变配置文件来实现
            步骤四：从容器中获取bean对象

    3.配置文件beans的根标签
    bean标签为子标签：常见属性：id，class，scope，init—method，destroy—method，antuwrite，factory-method
    import子标签：
        重写抽象方法： 
    容器的体系结构：
        初始化bean对象：
            普通java项目
            web项目在项目启动时自动加载

        方式一：使用(名称)id属性值来获取
        方式二：使用类（bean的字节码文件获取）来获取

        模拟spring（IOC源码）创建bean对象

        基于工厂模式加配置文件方式来实现bean对象的存储和管理
        步骤一:创建一个配置文件配置bean
        步骤二：加载配置文件，读取配置文件
                pom中导入依赖dom4j
                核心api解析配置文件
·               获取配置文件的字节输入流
                创建加载器对象，加载配置文件
                获取xml配置文件的所有bean对象的标签对象
                list<element > selectnodes
                遍历bean标签对象
            源码思路:
                通过有参构造赋值
                定义一个容器<object,object>
                 创建加载器对象，加载配置文件
                获取xml配置文件的所有bean对象的标签对象
                list<element > selectnodes
                遍历bean标签对象(里面使用反射来创建一个bean对象)
                根据名称将bean对象存入到容器中
                根据类型将bean对象存入到容器中
                
                提供一个方法通过名称来获取bean对象
                提供一个方法通过类型来获取bean对象
        业务层：面向接口编程
            Spring webflux 开始在公司应用 spring mvc
            远程调用：remoting
    Spring ioc：本质：
        工厂模式+注解或配置文件的方式来实现bean对象的初始化，存放到容器中，目的是用来设计出更加松耦合的程序                                          
        通过名称来进行存bean对象
        通过类型来进行存bean对象 
        autowire根据类型进行
        顶层接口beanfactory
        根据字节码对象来获取
        根据名称来获取
        map集合（容器）
        存的时候使用类型和名称取的时候使用类型和名称来获取
        @before 在测试之前执行，实现创建一个对象
        在接下来的测试方法中使用（无需再次创建）
        Spring在什么时机，创建bean对象存到容器中
        手动加载配置文件时，已经初始化bean对象，存放到容器中
    getbeandefinitionname 获取map容器中所有bean的名称
        泛型不需要强转，object需要强转
        Spring容器默认单例模式
        修改：prototype（多例模式）
        细节：默认使用无参数的构造方法初始化bean对象的，。存放到容器中
        若没有初始化对象会出现实例化bean对象失败异常
    初始化bean对象常见的异常：
        如果bean类中没有提供无参构造方法，提示不能实例化异常
        容器中存放bean对象，根据类型存储bean对象，如果配置文件或注解出现了相同类型nouniquebeandefinitionexception
        通过名称获取容器中的bean对象，名称写错
        no  bean named available  
           
        bean标签常见属性：
            id:定义bean唯一标识，bean的唯一名称
            向容器中存储bean对象时，把id属性值作为key，就是bean的名称
            class：定义bean的全类路径
            作用：根据class属性获取bean类路径用反射创建bean对象
            作用二:将bean对象存到容器中，会把class字节码对象作为key存放到容器中
            scope：指定bean实例化的方法和存储域对象的位置
                如果没有给其赋值，那么默认单例对象（利用单列模式）
            lazy—init 默认值
                默然值是singeton在项目加载时，初始化bean对象，存到容器中，对应lazyinit=false
                prototype不会初始化bean对象，bean对象的创建时机，在调用getbean 对应lazyinit=true
                bean对象的生命周期：
            
                    对象创建：
                    当使用对象时，创建新的对象
                    对象运行，只要在使用期间，就会一直存活
                    对象销毁：对象长时间不用，会java的垃圾回收器回收
                生命周期属性：
                    init-method：
                    初始化方法执行一次，
                    无参数构造方法先于初始化方法执行
                    destroy-method：（最后执行）
                    执行销毁方法演示bean对象的生命周期
                    单例创建时机：在类加载时创建，在创建容器时创建
                配置多例的容器销毁，获取多个
                测试多例，获取一个bean对象，执行一次初始化方法
                多例对象没有存储到容器中，
                销毁方法不执行
            在获取bean对象时，执行一次初始化方法
            多例执行多次初始化方法
            单例bean容器销毁，bean对象也销毁
            多例的bean若容器被销毁，bean对象不一定销毁，当多例对象不在被使用时，可以进行销毁
            注入属性：
            DI操作：在一个bean对象中注入另一个bean对象，在一个bean对象中调用另一个对象的方法
            autowire：bytype ：指的是在一个bean对象里面注入bean对象时，指的按照类型注入（根据类型从容器中取出bean）
            byname  指的按照名称注入（根据类名称注入）
            一般情况下不配置autowire属性，默认根据名称注入，若前者没有生效，根据类型注入
            

            注入service：
                property标签： name =javabean的属性
                ref引用bean标签的属性值 
            autowire ：
            在一个类中给成员变量赋值，
            有参数的构造方法
            set方法
        实例化属性：(了解)
        创建bean对象的属性
            方式一:
             构造方法实例化bean经常使用
            方式二:
                工厂静态方法实例化，对应的属性factory-method= 静态方法名称，很少使用
                
            方式三：factory-bean = 工厂bean类
                factory-method = 普通方法名称，很少使用

            存在的问题，之前的开发中是直接的耦合关系，现在耦合关系转移到工厂里面，所以这种写法用的少

## SpringDI：(依赖注入)

    dependency injection 是spring 框架核心ioc的具体实现
    通过是spring 容器存储和管理bean
    通过容器取出bean对象注入到另一个bean对象
    同时还可注入一个普通的字段
    注入哪些类型：type ：java；
    类属性String 类型，
    注入 基本类型，集合类型，数组类型
    用的比较多通常注入type类型
    
    注入基本类型和字符串类型:
    实现步骤：
        步骤一：
            定义一个bean，在bean里面，定义基本类型和String类型
            在配置文件中配置bean类型在
        步骤二：在配置文件中，property标签中配置bean对象的属性名称（name）并对其（value）进行赋值，
        在之前的javabean对象中要提供setget方法
        
    注入type属性：
    实际开发中用的比较多的属性，

        步骤一：
        定义一个beanbean中引入要调用的bean对象
            在web层定义一个类里面定义一个方法
            执行业务层的查询方法：
            引入userservic
        定义一个测试方法：findlist（）
            userservice.findall（）
            配置文件中
        步骤二：通过property标签进行赋值
            配置userservice
            配置usercontroller 注入userservice
            通过set方法来注入
            property name  =userservice 
            ref ：引入bean标签（bean标签的id属性值）
            根据ref属性值从容器中获取对象（调用set方法来给usercontroller里面的userservice赋值）:
        通过set方法进行注入小结：
            步骤一:在定义的bean类里面定义一个属性给属性提供set方法
            步骤二：配置文件
                在bean标签属性中进行配置
                name ref，引用另一个bean对象的id值 vlaue 为简单类型直接赋值
                
        通过构造方法来进行注入
        使用constructor-arg标签进行注入 
        定义类:通过构造方法进行赋值，显式提供无参构造方法

            通过有参数的构造方法
           直接赋值:constructor-arg name ="" vlaue =""
           注入type 

           
    属性名称：引入另一个id的属性值
    有参数的构造方法注入
    需求：注入druid连接池
        德鲁伊连接池：
            引入德鲁伊连接池
        步骤一：导入相关驱动
        步骤二：在核心配置文件之中定义连接池
        步骤三：定义usermapper类
        步骤四：配置di进行注入
        bean    
        通过set方法，进行druid的配置
        通过property标签进行四个参数的赋值
        maxwait value      
        将druid的创建权交给Spring