过滤器的创建方式：
    步骤一：创建敏感词库
    步骤二：创建工具类：wordutils
    步骤三：创建过滤器


    写过滤器必须初始化
    
模块：
    管理员模块
    学生模块
    教师模块
    课程模块
    院系模块
    技术选型：
    前端技术：
        jsp
    后端技术：
        持久层框架：spring-jdbc+封装数据技术：beanutils
    数据库：
        mysql

    简化javabean书写技术-lombok
        
        介绍：
        简化标准javabean技术的书写，简化setter/geter，constructor，tostring，hashcode
        使用：
        安装lombok插件：idea高版本自动集成了
                低版本：在plugins里面下载

        步骤二：
            需要在pom.xml引入依赖

        步骤三：
            可以javabean里面使用lombok注解

        @Data 自动加无参构造，getter方法
        @AllArgsConstructor
        @NoArgsConstructor
        @requiredArgsConstructor 配合@nonnull使用

        Spring-jdbc持久层框架，放在dap层：database acess object
        利用javabean和关系数据库形成映射，完成bean数据

        Spring-jdbc(核心对象默认从数据库连接池获取连接对象)使用：
        步骤一：在pom.xml文件中添加依赖
        步骤二：
        使用Spring-jdbc核心api对数据库进行更新和查询操作，核心api内部：对原始jdbc进行封装
        创建核心对象：
        jdbctmplate jt = new jdbctemplate（jdbcutils。getdatasource）
        执行更新操作
        jt.update(sql,参数)
        执行查询
        查询所有：
        LIst<T> list = jt.query(sql,结果处理器，参数)
        查询一个javabean
         T t = jt.queryforobject(sql,结果处理器，参数)
        查询一列数据
            list<列的类型> list = queryforlist（）
        查询聚合函数
        Number number = queryforObject（）

        BeanUtils工具类：
        将前台页面提交数据封装到javabean中也可以将表中数据封装到javabean中
        封装工具类：
        提供一个map：封装页面数据或表单数据
        map的key：和javabean的属性名称相同
            map的value 用户输入的数据
        提供一个javabean类
        javabean的属性名称和map的key一定要一致类型要匹配

        benautils的使用:
        步骤一：
        在pom文件中引入依赖
        步骤二：
        获取页面提交的表单数据封装到map中，将map中数据封装到bean中
        map map = request.getParamtermap（）
        javabean javabean = new javabean;
        beanutils.populate(javabean,map);

        date转换
        将页面提交的日期数据转成date类型
        DateCoverter dc = new student（）；
        dc.setPattern("日期格式")
        CoverUtils.register(dc,Date.class);


        只要页面提交的数据都是string
        beanutils封装数据：会自动将string类型转为number


        教务管理系统开发的完整记录：
        搭建开发环境
        步骤一：
            创建maven的web项目
            
        步骤二：
            引入依赖
            指定编译的整体环境
        步骤三：
            根据javaee三层架构分层开发：
            划分包结构：
            web（交互）：servlet，filter等controller模式对应技术
            service：存放业务类
            dao：存放持久层（Spring-jdbc）
            utils：存放工具类
            entity（pojo，domain）：存放javabean类
            面向接口开发：
            接口最大优点：
            解耦合（类之间的关系，或者父与子之间的关系），
            易于扩展
            adminService as = new adminservice（）；直接耦合，后期开发要避免
            adminservice as2 = new adminservicerimpl()父与子耦合也要避免
            解决耦合：使用bean容器（工厂模式+配置文件）解决
        步骤四：
        导入页面原型（前端提供）
            将页面放在webapp下面
    登陆页面
    执行查询操作
    程序流程：
    主页面点击登陆，登陆页面，输入账号信息，web层adminlogin servo

    管理员模块的注册功能：
        执行流程：
            在主页面点击注册，跳转到register注册页面
            注册成功：跳转登陆页面
            注册失败：返回失败信

    退出功能：
    思路：销毁session或者移除session中登陆的用户信息
    原因：一次会话始终对应一个session。如果session中有用户名，表示用户一直在线

    程序入口：
    主页面点击退出， web层销毁session
    invalidate销毁方法

    学生管理模块
    查询所有学生功能
    left点击查询所有学生----》web层：查询所有学生，存到request域对象，转发到listcustomer jstl遍历list显示
    service 查询所有学生的方法
    dao层
        查询所有学生的方法
    添加
    修改
        步骤一：根据学生的id将其查出显示
        步骤二：修改页面里面修改学生信息
    删除
    学生分页

    程序的入口：
    主页面包含left.jsp页面；
        请求路径
        web层：
        配置两级目录便于后期控制
        一般保存在request
        利用转发
        在服务器内跳转不用加项目名称
        创建查询所

    模糊百度分页
    当前页面数currentpage
    每页显示的固定条数pagesize
    每页显示的固定条数的具体数据
    参与的分页总页面totalpage= （totalcount%pagesize ==0：totalcount/pagesize+1 ）
    参与分页的总记录条数totalcount比如表中
    百度的分页效果：每页显示十个页面数
    第一个页面数firstP
    最后一个页面数endP
    规律当前页面数-5
        最后页码加4
    具体分为两种情况：
        具体分为：
        情况一：总的页面数小于=10
        first = 1；
        end怕= totalpage；
        情况二：大于10
        头溢出
        currentpage-5<10
        first = 1
        endp =10；
        尾溢出：
        currentpage+4>=totalpage
        endp = totalpage
        firstp = totalpage-9;
        上一页：
        prep =当前页面-1（不为第一页）
        下一页：
        nextp

        封装javabean

        容器：
        用来保存对象，特别web项目，可以在服务器启动时扫描javabean创建bean对象添加到容器中
        作用：提高程序的性能，避免后期频繁的创建对象

        由于后期从容器中取出bean对象数据所以是map结构
        线程安全的map：concurrentmap
    
    使用工厂模式：
    java的23种设计模式
    工厂模式+配置文件方式：创建bean对象存到容器中
    工厂模式+注解方式：创建bean对象存到容器中

    工厂模式：
        创建bean对象（构建模式）
    工厂模式的写法很多
        简单工厂：
        serviceSon
            耦合关系转到工厂中
            一般用的不多

        复杂工厂：
           serviceSon=
           使用工厂模式+配置文件创建bean对象

           map的key：类名的首字母小写，类的类型（class）
           map的value：类的实例化对象


           作用一：
           一定程度解耦合
           作用二：
           面向接口开发：可以通过接口实现程序的扩展
           开发中遵循ocp原则。对程序源码系应该开发，对程序的扩展开发
           
           xml、yml和properities

           





