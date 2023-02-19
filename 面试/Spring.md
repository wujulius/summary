# spring

## 

### Spring IOC 原理

    Spring 通过一个配置文件描述 Bean 及 Bean 之间的依赖关系，利用 Java 语言的反射功能实例化 Bean并建立 Bean 之间的依赖关系。还提供了 Bean 实例缓存、生命周期管理、 Bean 实例代理、事件发布、资源装载等高级服务。

### spring容器高层视图

    Spring实现原理

### IOC容器实现

    beanfactory 框架基础设施

    BeanFactory 是 Spring 框架的基础设施，面向 Spring 本身；ApplicationContext 面向使用 Spring 框架的开发者，几乎所有的应用场合我们都直接使用 ApplicationContext 而非底层的 BeanFactory。

### Spring Bean 作用域

    Spring 3 中为 Bean 定义了 5 中作用域，分别为 singleton（单例）、prototype（原型）、 request、session 和 global session
    1.singleton 单例模式（线程不安全）
    2.prototype 原型模式每次使用时创建
    3.request  一次request情求创建一次
    4.session 在一次 Http Session 中，容器会返回该 Bean 的同一实例。
    1.singleton：单例模式，Spring IoC 容器中只会存在一个共享的 Bean 实例，无论有多少个 Bean 引用它，始终指向同一对象。该模式在多线程下是不安全的。Singleton 作用域是 Spring 中的缺省作用域，也可以显示的将 Bean 定义为 singleton 模式

    2. prototype:原型模式，每次通过 Spring 容器获取 prototype 定义的 bean 时，容器都将创建一个新的 Bean 实例，每个 Bean 实例都有自己的属性和状态，而 singleton 全局只有一个对象。根据经验，对有状态的bean使用prototype作用域，而对无状态的bean使用singleton 作用域。

    3. request：在一次 Http 请求中，容器会返回该 Bean 的同一实例。而对不同的 Http 请求则会产生新的 Bean，而且该 bean 仅在当前 Http Request 内有效,当前 Http 请求结束，该 bean 实例也将会被销毁

    4. session：在一次 Http Session 中，容器会返回该 Bean 的同一实例。而对不同的 Session 请求则会创建新的实例，该 bean 实例仅在当前 Session 内有效。同 Http 请求相同，每一次 session 请求创建新的实例，而不同的实例之间不共享属性，且实例仅在自己的 session 请求内有效，请求结束，则实例将被销毁。

    5. global Session：在一个全局的 Http Session 中，容器会返回该 Bean 的同一个实例，仅在使用portlet context 时有效。

### Spring 依赖注入四种方式

    1.构造器注入

    2.setter方法注入
    3.静态工厂注入
        通过调用静态工厂的方法来获取自己需要的对象，为了让 spring 管理所有对象
    4.实例工厂
        实例工厂的意思是获取对象实例的方法不是静态的，所以你需要首先 new 工厂类，再调用普通的实例方法：

### 5 种不同方式的自动装配
    Spring 装配包括手动装配和自动装配，手动装配是有基于 xml 装配、构造方法、setter 方法等自动装配
    有五种自动装配的方式，可以用来指导 Spring 容器用自动装配方式来进行依赖注入。
    1. no：默认的方式是不进行自动装配，通过显式设置 ref 属性来进行装配。
    2. byName：通过参数名 自动装配，Spring容器在配置文件中发现bean的autowire 属性被设置成
    byname，之后容器试图匹配、装配和该 bean 的属性具有相同名字的 bean。
    3. byType：通过参数类型自动装配，Spring 容器在配置文件中发现 bean 的 autowire 属性被设置成
    byType，之后容器试图匹配、装配和该bean的属性具有相同类型的bean。如果有多个 bean 符合
    条件，则抛出错误。
    4. constructor：这个方式类似于 byType， 但是要提供给构造器参数，如果没有确定的带参数的构造
    器参数类型，将会抛出异常。
    5. autodetect：首先尝试使用constructor 来自动装配，如果无法工作，则使用byType方式。

### Spring AOP 原理

    优点：那些与业务无关，却为业务模块所共同调用的逻辑或责任封装起来，便于减少系统的重复代码，降低模块之间的耦合度，并有利于未来的可操作性和可维护性。

    AOP 把软件系统分为两个部分：核心关注点和横切关注点。业务处理的主要流程是核心关注点，与之关系不大的部分是横切关注点，AOP 的作用在于分离系统中的各种关注点，将核心关注点和横切关注点分离开来。

### AOP 主要应用场景有：

    1. Authentication 权限
    2. Caching 缓存
    3. Context passing 内容传递
    4. Error handling 错误处理
    5. Lazy loading 懒加载
    6. Debugging 调试
    7. logging, tracing, profiling and monitoring 记录跟踪 优化 校准
    8. Performance optimization 性能优化
    9. Persistence 持久化
    10. Resource pooling 资源池
    11. Synchronization 同步
    12. Transactions 事务

### AOP 核心概念

    1、切面（aspect）：类是对物体特征的抽象，切面就是对横切关注点的抽象
    2、横切关注点：对哪些方法进行拦截，拦截后怎么处理，这些关注点称之为横切关注点。
    3、连接点（joinpoint）：被拦截到的点，因为 Spring 只支持方法类型的连接点，所以在 Spring 中连
    接点指的就是被拦截到的方法，实际上连接点还可以是字段或者构造器。
    4、切入点（pointcut）：对连接点进行拦截的定义
    5、通知（advice）：所谓通知指的就是指拦截到连接点之后要执行的代码，通知分为前置、后置、异
    常、最终、环绕通知五类。
    6、目标对象：代理的目标对象
    7、织入（weave）：将切面应用到目标对象并导致代理对象创建的过程 
    8、引入（introduction）：在
    不修改代码的前提下，引入可以在运行期为类动态地添加一些方法或字段。
### 在目标对象的生命周期里有多少个点可以进行织入：

    编译期：切面在目标类编译时被织入。AspectJ的织入编译器是以这种方式织入切面的。
    类加载期：切面在目标类加载到JVM时被织入。需要特殊的类加载器，它可以在目标类被引入应用
    之前增强该目标类的字节码。AspectJ5的加载时织入就支持以这种方式织入切面。
    运行期：切面在应用运行的某个时刻被织入。一般情况下，在织入切面时，AOP 容器会为目标对象
    动态地创建一个代理对象。SpringAOP就是以这种方式织入切面。
### AOP两种代理方式

    Spring 提供了两种方式来生成代理对象: JDKProxy 和 Cglib，具体使用哪种方式生成由AopProxyFactory 根据 AdvisedSupport 对象的配置来决定。默认的策略是如果目标类是接口，则使用JDK 动态代理技术，否则使用 Cglib 来生成代理。

    CGLib 动态代理
    1. ：CGLib 全称为 Code Generation Library，是一个强大的高性能，高质量的代码生成类库，可以在运行期扩展 Java 类与实现 Java 接口，CGLib 封装了 asm，可以再运行期动态生成新的 class。和 JDK 动态代理相比较：JDK 创建代理有一个限制，就是只能为接口创建代理实例，而对于没有通过接口定义业务方法的类，则可以通过 CGLib 创建动态代理。

### 实现技术

    AOP（这里的AOP指的是面向切面编程思想，而不是Spring AOP）主要的的实现技术主要有 SpringAOP和AspectJ。

    1）AspectJ的底层技术。 AspectJ的底层技术是静态代理，即用一种AspectJ支持的特定语言编写切
    面，通过一个命令来 编译，生成一个新的代理类，该代理类增强了业务类，这是在编译时增强，相对于
    下面说的运行 时增强，编译时增强的性能更好。
    2）Spring AOP Spring AOP采用的是动态代理，在运行期间对业务方法进行增强，所以不会生成新
    类，对于 动态代理技术，Spring AOP提供了对JDK动态代理的支持以及CGLib的支持。 

### springmvc框架：

    Spring MVC 分离了控制器、模型对象、分派器以及处理程序对象的角色，这种分离让它们更容易进行定制。

### SpringMVC接口解释

    DispatcherServlet接口：
    Spring提供的前端控制器，所有的请求都有经过它来统一分发。在DispatcherServlet将请求分发
    给Spring Controller之前，需要借助于Spring提供的HandlerMapping定位到具体的Controller。
    HandlerMapping接口：
    能够完成客户请求到Controller映射。
    Controller接口：
    需要为并发用户处理上述请求，因此实现Controller接口时，必须保证线程安全并且可重用。
    Controller将处理用户请求，这和Struts Action扮演的角色是一致的。一旦Controller处理完用户
    请求，则返回ModelAndView对象给DispatcherServlet前端控制器，ModelAndView中包含了模
    型（Model）和视图（View）。
    从宏观角度考虑，DispatcherServlet是整个Web应用的控制器；从微观考虑，Controller是单个
    Http请求处理过程中的控制器，而ModelAndView是Http请求过程中返回的模型（Model）和视
    图（View）。
    ViewResolver接口：
    Spring提供的视图解析器（ViewResolver）在Web应用中查找View对象，从而将相应结果渲染给客户。

### SpringMVC运行原理

    1. 客户端请求提交到DispatcherServlet
    2. 由DispatcherServlet控制器查询一个或多个HandlerMapping，找到处理请求的Controller
    3. DispatcherServlet将请求提交到Controller
    4. Controller调用业务逻辑处理后，返回ModelAndView
    5. DispatcherServlet查询一个或多个ViewResoler视图解析器，找到ModelAndView指定的视
    图
    6. 视图负责将结果显示到客户端

### DispatcherServlet

    DispatcherServlet是整个Spring MVC的核心。它负责接收HTTP请求组织协调Spring MVC的各个组成部
    分。其主要工作有以下三项：
       1. 截获符合特定格式的URL请求。
       2. 初始化DispatcherServlet上下文对应的WebApplicationContext，并将其与业务层、持久化层的
       WebApplicationContext建立关联。
       1. 初始化Spring MVC的各个组成组件，并装配到DispatcherServlet中

### beanfactory和applicationcontext的区别

    1.BeanFactroy采用的是延迟加载形式来注入Bean的，即只有在使用到某个Bean时(调用getBean())，才对该Bean进行加载实例化

    ApplicationContext则相反，它是在容器启动时，一次性创建了所有的Bean

    BeanFacotry延迟加载,如果Bean的某一个属性没有注入，BeanFacotry加载后，直至第一次使用调用
    getBean方法才会抛出异常；而ApplicationContext则在初始化自身是检验，这样有利于检查所依赖属
    性是否注入；所以通常情况下我们选择使用 ApplicationContext。
    
    2.BeanFactory和ApplicationContext都支持BeanPostProcessor、BeanFactoryPostProcessor的使
    用，但两者之间的区别是：BeanFactory需要手动注册，而ApplicationContext则是自动注册。

    3.beanFactory主要是面对与 spring 框架的基础设施，面对 spring 自己。而 Applicationcontex 主要面
    对与 spring 使用的开发者。基本都会使用 Applicationcontex 并非 beanFactory 。

### beanfactory和application的区别

    作用：
    \1. BeanFactory负责读取bean配置文档，管理bean的加载，实例化，维护bean之间的依赖关系，负责
    bean的声明周期。
    \2. ApplicationContext除了提供上述BeanFactory所能提供的功能之外，还提供了更完整的框架功能：
    a. 国际化支持
    b. 资源访问：Resource rs = ctx. getResource(“classpath:config.properties”),
    “file:c:/config.properties”
    c. 事件传递：通过实现ApplicationContextAware接口
    \3. 常用的获取ApplicationContext
    FileSystemXmlApplicationContext：从文件系统或者url指定的xml配置文件创建，参数为配置文件名或文件名数组，有相对路径与绝对路径。


### 循环依赖可能出现的场景以及解决方法

    使用构造器方法可能会造成循环依赖
    <bean id="a" class="com.zfx.student.StudentA">
    <constructor-arg index="0" ref="b"></constructor-arg>
    </bean>

    解决方案：
    1.使用setter方法单例，默认方式来创建对象
        Spring是先将Bean对象实例化之后再设置对象属性的
    原理
        Spring先是用构造实例化Bean对象 ，此时Spring会将这个实例化结束的对
    象放到一个Map中，并且Spring提供了获取这个未设置属性的实例化对象引用的方法。 结合我们的实
    例来看，，当Spring实例化了StudentA、StudentB、StudentC后，紧接着会去设置对象的属性，此
    时StudentA依赖StudentB，就会去Map中取出存在里面的单例StudentB对象，以此类推，不会出来
    循环的问题喽、
        <bean id="a" class="com.zfx.student.StudentA" scope="singleton">
        <property name="studentB" ref="b"></property>
        </bean>
    2.使用setter方式，原型
       
        scope="prototype" 意思是 每次请求都会创建一个实例对象。两者的区别是：有状态的bean都使用
        Prototype作用域，无状态的一般都使用singleton单例作用域。
    原理：
        对于“prototype”作用域Bean，Spring容器无法完成依赖注入，因为“prototype”作用域的Bean，
        Spring容器不进行缓存，因此无法提前暴露一个创建中的Bean。

    <bean id="a" class="com.zfx.student.StudentA" scope="prototype">
    <property name="studentB" ref="b"></property>
    </bean>

### IOC容器初始化的基本步骤：

    1.初始化的入口在容器实现中的 refresh()调用来完成
    2. 对 bean 定义载入 IOC 容器使用的方法是 loadBeanDefinition,其中的大致过程如下：通过
    ResourceLoader 来完成资源文件位置的定位，DefaultResourceLoader 是默认的实现，同时上下文本
    身就给出了 ResourceLoader 的实现，可以从类路径，文件系统, URL 等方式来定为资源位置。如果是
    XmlBeanFactory作为 IOC 容器，那么需要为它指定 bean 定义的资源，也就是说 bean 定义文件时通过
    抽象成 Resource 来被 IOC 容器处理的，容器通过 BeanDefinitionReader来完成定义信息的解析和
    Bean 信息的注册,往往使用的是XmlBeanDefinitionReader 来解析 bean 的 xml 定义文件 - 实际的处理
    过程是委托给 BeanDefinitionParserDelegate 来完成的，从而得到 bean 的定义信息，这些信息在
    Spring 中使用 BeanDefinition 对象来表示 - 这个名字可以让我们想到
    loadBeanDefinition,RegisterBeanDefinition 这些相关的方法 - 他们都是为处理 BeanDefinitin 服务
    的， 容器解析得到 BeanDefinitionIoC 以后，需要把它在 IOC 容器中注册，这由 IOC 实现
    BeanDefinitionRegistry 接口来实现。注册过程就是在 IOC 容器内部维护的一个HashMap 来保存得到
    的 BeanDefinition 的过程。这个 HashMap 是 IoC 容器持有 bean 信息的场所，以后对 bean 的操作都
    是围绕这个HashMap 来实现的.
    3. 然后我们就可以通过 BeanFactory 和 ApplicationContext 来享受到 Spring IOC 的服务了,在使用 IOC
    容器的时候，我们注意到除了少量粘合代码，绝大多数以正确 IoC 风格编写的应用程序代码完全不用关
    心如何到达工厂，因为容器将把这些对象与容器管理的其他对象钩在一起。基本的策略是把工厂放到已
    知的地方，最好是放在对预期使用的上下文有意义的地方，以及代码将实际需要访问工厂的地方。
    Spring 本身提供了对声明式载入 web 应用程序用法的应用程序上下文,并将其存储在ServletContext 中
    的框架实现。

### beanfactory和factorybean

    BeanFactory 指的是 IOC 容器的编程抽象
    FactoryBean 只是一个可以在 IOC而容器中被管理的
    一个 bean,是对各种处理过程和资源使用的抽象,Factory bean 在需要时产生另一个对象，而不返回
    FactoryBean本身,我们可以把它看成是一个抽象工厂，对它的调用返回的是工厂生产的产品。

### IOC容器的依赖注入

    依赖注入发生的时间：

        1.当Spring IoC容器完成了Bean定义资源的定位、载入和解析注册以后，IoC容器中已经管理类Bean定义
        的相关数据，但是此时IoC容器还没有对所管理的Bean进行依赖注入，依赖注入在以下两种情况发生：
        (1).用户第一次通过getBean方法向IoC容索要Bean时，IoC容器触发依赖注入。
        (2).当用户在Bean定义资源中为元素配置了lazy-init属性，即让容器在解析注册Bean定义时进行预实例
        化，触发依赖注入。
        2.AbstractBeanFactory通过getBean向IoC容器获取被管理的Bean
        3.在Spring中，如果Bean定义的单态模式
        (Singleton)，则容器在创建之前先从缓存中查找，以确保整个容器中只存在一个实例对象。如果Bean定
        义的是原型模式(Prototype)，则容器每次都会创建一个新的实例对象。

### spring aop
    
    Spring 的 AOP 代理由 Spring 的 IoC 容器负责生成、管理，其依赖关系也由 IoC 容器负责管理。因此，
    AOP 代理可以直接使用容器中的其他 Bean 实例作为目标，这种关系可由 IoC 容器的依赖注入提供。

### Spring并发访问的线程安全性问题

    由于Spring MVC默认是Singleton的，所以会产生一个潜在的安全隐患。根本核心是instance变量保持状态的问题。这意味着每个request过来，系统都会用原有的instance去处理，这样导致了两个结果：
    一是我们不用每次创建Controller，
    二是减少了对象创建和垃圾收集的时间；
    由于只有一个Controller的instance，当多个线程同时调用它的时候，它里面的instance变量就不是线程
    安全的了，会发生窜数据的问题。

    有几种解决方法：
    1、在控制器中不使用实例变量
    2、将控制器的作用域从单例改为原型，即在spring配置文件Controller中声明 scope="prototype"，每
    次都创建新的controller
    3、在Controller中使用ThreadLocal变量

    第一种，需要开发人员拥有较高的编程水平与思想意识，在编码过程中力求避免
    出现这种BUG，而第二种则是容器自动的对每个请求产生一个实例，由JVM进行垃圾回收，因此做到了
    线程安全。
    使用第一种方式的好处是实例对象只有一个，所有的请求都调用该实例对象，速度和性能上要优于第二
    种，不好的地方，就是需要程序员自己去控制实例变量的状态保持问题。第二种由于每次请求都创建一
    个实例，所以会消耗较多的内存空间。

### spring用到的设计模式

    1.工厂模式，这个很明显，在各种BeanFactory以及ApplicationContext创建中都用到了；
    2.模版模式，这个也很明显，在各种BeanFactory以及ApplicationContext实现中也都用到了；
    3.代理模式，在Aop实现中用到了JDK的动态代理；
    4.单例模式，这个比如在创建bean的时候。
    5.Tomcat中有很多场景都使用到了外观模式，因为Tomcat中有很多不同的组件，每个组件需要相互通
    信，但又不能将自己内部数据过多地暴露给其他组件。用外观模式隔离数据是个很好的方法。
    6.策略模式在Java中的应用，这个太明显了，因为Comparator这个接口简直就是为策略模式而生的。
    Comparable和Comparator的区别一文中，详细讲了Comparator的使用。比方说Collections里面有一
    个sort方法，因为集合里面的元素有可能是复合对象，复合对象并不像基本数据类型，可以根据大小排
    序，复合对象怎么排序呢？基于这个问题考虑，Java要求如果定义的复合对象要有排序的功能，就自行
    实现Comparable接口或Comparator接口.
    7.原型模式：使用原型模式创建对象比直接new一个对象在性能上好得多，因为Object类的clone()方法
    是一个native方法，它直接操作内存中的二进制流，特别是复制大对象时，性能的差别非常明显。
    8.迭代器模式：Iterable接口和Iterator接口 这两个都是迭代相关的接口，可以这么认为，实现了
    Iterable接口，则表示某个对象是可被迭代的；Iterator接口相当于是一个迭代器，实现了Iterator接
    口，等于具体定义了这个可被迭代的对象时如何进行迭代的

### 事务管理

    原子性（Atomicity）：事务是一个原子操作，由一系列动作组成。事务的原子性确保动作要
    么全部完成，要么完全不起作用。
    一致性（Consistency）：一旦事务完成（不管成功还是失败），系统必须确保它所建模的业
    务处于一致的状态，而不会是部分完成部分失败。在现实中的数据不应该被破坏。
    隔离性（Isolation）：可能有许多事务会同时处理相同的数据，因此每个事务都应该与其他
    事务隔离开来，防止数据损坏。
    持久性（Durability）：一旦事务完成，无论发生什么系统错误，它的结果都不应该受到影
    响，这样就能从任何系统崩溃中恢复过来。通常情况下，事务的结果被写到持久化存储器
    中。

### 不可重复读与幻读的区别

    不可重复读的重点是修改:
    同样的条件, 你读取过的数据, 再次读取出来发现值不一样了

    幻读的重点在于新增或者删除：
    同样的条件, 第1次和第2次读出来的记录数不一样


### Spring MVC怎么样设定重定向和转发的？

    （1） 转发：在返回值前面加"forward:"，譬如"forward:user.do?name=method4"
    （2） 重定向：在返回值前面加"redirect:"，譬如"redirect:http://www.baidu.com"
### Spring MVC怎么和AJAX相互调用的？

    通过Jackson框架就可以把Java里面的对象直接转化成Js可以识别的Json对象。
    具体步骤如下 ：
    （1） 加入Jackson.jar
    （2） 在配置文件中配置json的映射
    （3） 在接受Ajax方法里面可以直接返回Object,List等,但方法前面要加上@ResponseBody注解。

### Spring MVC的异常处理？

    答：可以将异常抛给Spring框架，由Spring框架来处理；我们只需要配置简单的异常处理器，在异常处
    理器中添视图页面即可。
### 如果在拦截请求中，我想拦截get方式提交的方法,怎么配置

    答：可以在@RequestMapping注解里面加上 method=RequestMethod.GET。
### 怎样在方法里面得到Request,或者Session？

    答：直接在方法的形参中声明request,Spring MVC就自动把request对象传入。

### 如果想在拦截的方法里面得到从前台传入的参数,怎么得到？

    答：直接在形参里面声明这个参数就可以,但必须3名字和传过来的参数一样。
### 如果前台有很多个参数传入,并且这些参数都是一个对象的,那么怎么样快速得到这个对象？

    答：直接在方法中声明这个对象,Spring MVC就自动会把属性赋值到这个对象里面。

### Spring MVC中函数的返回值是什么？
    答：返回值可以有很多类型,有String, ModelAndView。ModelAndView类把视图和数据都合并的一起
    的，但一般用String比较好。
### Spring MVC用什么对象从后台向前台传递数据的？
    答：通过ModelMap对象,可以在这个对象里面调用put方法,把对象加到里面,前台就可以通过el表达式拿
    到。
### 怎么样把ModelMap里面的数据放入Session里面？
    答：可以在类上面加上@SessionAttributes注解,里面包含的字符串就是要放入session里面的key。


### 控制反转(IoC)有什么作用

    管理对象的创建和依赖关系的维护。对象的创建并不是一件简单的事，在对象关系比较复杂时，如
    果依赖关系需要程序猿来维护的话，那是相当头疼的
    解耦，由容器去维护具体的对象
    托管了类的产生过程，比如我们需要在类的产生过程中做一些处理，最直接的例子就是代理，如果
    有容器程序可以把这部分处理交给容器，应用程序则无需去关心类是如何完成代理的

### IOC的优点是什么？

    IOC 或 依赖注入把应用的代码量降到最低。
    它使应用容易测试，单元测试不再需要单例和JNDI查找机制。
    最小的代价和最小的侵入性使松散耦合得以实现。
    IOC容器支持加载服务时的饿汉式初始化和懒加载。

### Spring 的 IoC支持哪些功能

    Spring 的 IoC 设计支持以下功能：依赖注入依赖检查自动装配支持集合指定初始化方法和销毁方法
    支持回调某些方法（但是需要实现 Spring 接口，略有侵入）
    其中，最重要的就是依赖注入，从 XML 的配置上说，即 ref 标签。对应 Spring
    RuntimeBeanReference 对象。
    对于 IoC 来说，最重要的就是容器。容器管理着 Bean 的生命周期，控制着 Bean 的依赖注入。

### 哪些是重要的bean生命周期方法？ 你能重载它们吗？
    有两个重要的bean 生命周期方法，第一个是setup ， 它是在容器加载bean的
    时候被调用。第二个方法是 teardown 它是在容器卸载类的时候被调用。
    bean 标签有两个重要的属性（init-method和destroy-method）。用它们你可以自己定制初始化和注销
    方法。它们也有相应的注解（@PostConstruct和@PreDestroy）。
### 什么是Spring的内部bean？什么是Spring inner beans？
    在Spring框架中，当一个bean仅被用作另一个bean的属性时，它能被声明为一个内部bean。内部bean
    可以用setter注入“属性”和构造方法注入“构造参数”的方式来实现，内部bean通常是匿名的，它们的
    Scope一般是prototype。
### 在 Spring中如何注入一个java集合？
    Spring提供以下几种集合的配置元素：类型用于注入一列值，允许有相同的值。
    类型用于注入一组值，不允许有相同的值。
    类型用于注入一组键值对，键和值都只能为String类型。
### 什么是bean装配？
    装配，或bean 装配是指在Spring 容器中把bean组装到一起，前提是容器需要知道bean的依赖关系，如
    何通过依赖注入来把它们装配到一起。
### 什么是bean的自动装配？
    在Spring框架中，在配置文件中设定bean的依赖关系是一个很好的机制，
    Spring 容器能够自动装配相互合作的bean，这意味着容器不需要和配置，能通
    过Bean工厂自动处理bean之间的协作。这意味着 Spring可以通过向Bean
    Factory中注入的方式自动搞定bean之间的依赖关系。自动装配可以设置在每个bean上，也可以设定在
    特定的bean上。
### 解释不同方式的自动装配，spring 自动装配 bean 有哪些方式？
    在spring中，对象无需自己查找或创建与其关联的其他对象，由容器负责把需要相互协作的对象引用赋
    予各个对象，使用autowire来配置自动装载模式。
### 在Spring框架xml配置中共有5种自动装配：

    no：默认的方式是不进行自动装配的，通过手工设置ref属性来进行装配bean。
    byName：通过bean的名称进行自动装配，如果一个bean的 property 与另一bean 的name 相
    同，就进行自动装配。
    byType：通过参数的数据类型进行自动装配。
    constructor：利用构造函数进行装配，并且构造函数的参数通过 byType进行装配。
    autodetect：自动探测，如果有构造方法，通过 construct的方式自动装配，否则使用 byType的方
    式自动装配

### 使用@Autowired注解自动装配的过程是怎样的？

    使用@Autowired注解来自动装配指定的bean。在使用@Autowired注解之前需要在Spring配置文件进
    行配置，。
    在启动spring IoC时，容器自动装载了一个
    AutowiredAnnotationBeanPostProcessor后置处理器，当容器扫描到@Autowied、@Resource或
    @Inject时，就会在IoC容器自动查找需要的 bean，并装配给该对象的属性。在使用@Autowired时，首
    先在容器中查询对应类型的bean： 
    如果查询结果刚好为一个，就将该bean装配给@Autowired指定的数据；
    如果查询的结果不止一个，那么@Autowired会根据名称来查找；
    如果上述查找的结果为空，那么会抛出异常。解决方法时，使用required=false。

### 自动装配有哪些局限性？
    自动装配的局限性是：重写：你仍需用 和 配置来定义依赖，意味着总要重写自动装配。
    基本数据类型：你不能自动装配简单的属性，如基本数据类型，String字符串，和类。
    模糊特性：自动装配不如显式装配精确，如果有可能，建议使用显式装配。
### 你可以在Spring中注入一个null 和一个空字符串吗？
    可以

### @Component, @Controller, @Repository, @Service 有何区别？

    @Component：这将 java 类标记为 bean。它是任何 Spring 管理组件的通用构造型。spring 的组件扫描机制现在可以将其拾取并将其拉入应用程序环境中。
    @Controller：这将一个类标记为 Spring Web MVC 控制器。标有它的 Bean 会自动导入到 IoC 容器中。
    @Service：此注解是组件注解的特化。它不会对 @Component 注解提供任何其他行为。您可以在服务层类中使用 @Service 而不是 @Component，因为它以更好的方式指定了意图。
    @Repository：这个注解是具有类似用途和功能的 @Component 注解的特化。它为 DAO 提供了额外的好处。它将 DAO 导入 IoC 容器，并使未经检查的异常有资格转换为 Spring DataAccessException。

### @Required 注解有什么作用

    这个注解表明bean的属性必须在配置的时候设置，通过一个bean定义的显式的属性值或通过自动装
    配，若@Required注解的bean属性未被设置，容器将抛出

### @Autowired 注解有什么作用

    @Autowired默认是按照类型装配注入的，默认情况下它要求依赖对象必须存在（可以设置它required
    属性为false）。@Autowired 注解提供了更细粒度的控制，包括在何处以及如何完成自动装配。它的用
    法和@Required一样，修饰 setter方法、构造器、属性或者具有任意名称和/或多个参数的PN方法。

### @Autowired和@Resource之间的区别

    @Autowired可用于：构造函数、成员变量、Setter方法
    @Autowired和@Resource之间的区别
    @Autowired默认是按照类型装配注入的，默认情况下它要求依赖对象必须存在（可以设置它required
    属性为false）。
    @Resource默认是按照名称来装配注入的，只有当找不到与名称匹配的bean才会按照类型来装配注入。

### 说一下Spring的事务传播行为

    spring事务的传播行为说的是，当多个事务同时存在的时候，spring如何处理这些事务的行为。
    ① PROPAGATION_REQUIRED：如果当前没有事务，就创建一个新事务，如果当前存在事务，就加入该
    事务，该设置是最常用的设置。
    ② PROPAGATION_SUPPORTS：支持当前事务，如果当前存在事务，就加入该事务，如果当前不存在
    事务，就以非事务执行。
    ③ PROPAGATION_MANDATORY：支持当前事务，如果当前存在事务，就加入该事务，如果当前不存
    在事务，就抛出异常。
    ④ PROPAGATION_REQUIRES_NEW：创建新事务，无论当前存不存在事务，都创建新事务。
    ⑤ PROPAGATION_NOT_SUPPORTED：以非事务方式执行操作，如果当前存在事务，就把当前事务挂
    起。
    ⑥ PROPAGATION_NEVER：以非事务方式执行，如果当前存在事务，则抛出异常。
    ⑦ PROPAGATION_NESTED：如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则按
    REQUIRED属性执行。

### 说一下 spring 的事务隔离？

    spring 有五大隔离级别，默认值为 ISOLATION_DEFAULT（使用数据库的设置），其他四个隔离级别和数据库的隔离级别一致：
    1. ISOLATION_DEFAULT：用底层数据库的设置隔离级别，数据库设置的是什么我就用什么；
    2. ISOLATION_READ_UNCOMMITTED：未提交读，最低隔离级别、事务未提交前，就可被其他事务
    读取（会出现幻读、脏读、不可重复读）； 
    3. ISOLATION_READ_COMMITTED：提交读，一个事
    务提交后才能被其他事务读取到（会造成幻读、不可重复读），SQL server 的默认级别；
    4. ISOLATION_REPEATABLE_READ：可重复读，保证多次读取同一个数据时，其值都和事务开始时
    候的内容是一致，禁止读取到别的事务未提交的数据（会造成幻读），MySQL 的默认级别；
    5. ISOLATION_SERIALIZABLE：序列化，代价最高最可靠的隔离级别，该隔离级别能防止脏读、不可
    重复读、幻读。
    脏读 ：表示一个事务能够读取另一个事务中还未提交的数据。比如，某个事务尝试插入记录 A，此时该
    事务还未提交，然后另一个事务尝试读取到了记录 A。
    不可重复读 ：是指在一个事务内，多次读同一数据。
    幻读 ：指同一个事务内多次查询返回的结果集不一样。比如同一个事务 A 第一次查询时候有 n 条记录，
    但是第二次同等条件下查询却有 n+1 条记录，这就好像产生了幻觉。发生幻读的原因也是另外一个事务
    新增或者删除或者修改了第一个事务结果集里面的数据，同一个记录的数据内容被修改了，所有数据行
    的记录就变多或者变少了。

### Spring框架的事务管理有哪些优点？
    为不同的事务API 如 JTA，JDBC，Hibernate，JPA 和JDO，提供一个不变的编程模式。
    为编程式事务管理提供了一套简单的API而不是一些复杂的事务API 支持声明式事务管理。
    和Spring各种数据访问抽象层很好得集成。

### Spring面向切面编程(AOP)什么是AOP

    OOP(Object-Oriented Programming)面向对象编程，允许开发者定义纵向的关系，但并适用于定义横
    向的关系，导致了大量代码的重复，而不利于各个模块的重用。
    AOP(Aspect-Oriented Programming)，一般称为面向切面编程，作为面向对象的一种补充，用于将那
    些与业务无关，但却对多个对象产生影响的公共行为和逻辑，抽取并封装为一个可重用的模块，这个模
    块被命名为“切面”（Aspect），减少系统中的重复代码，降低了模块间的耦合度，同时提高了系统的可
    维护性。可用于权限认证、日志、事务处理等。

### Spring在运行时通知对象

    通过在代理类中包裹切面，Spring在运行期把切面织入到Spring管理的bean
    中。代理封装了目标类，并拦截被通知方法的调用，再把调用转发给真正的目标 bean。当代理拦截到方
    法调用时，在调用目标bean方法之前，会执行切面逻辑。
    直到应用需要被代理的bean时，Spring才创建代理对象。如果使用的是
    ApplicationContext的话，在ApplicationContext从BeanFactory中加载所有 bean的时候，Spring才会
    创建被代理的对象。因为Spring运行时才创建代理对象，所以我们不需要特殊的编译器来织入
    SpringAOP的切面。
    Spring只支持方法级别的连接点
    因为Spring基于动态代理，所以Spring只支持方法连接点。Spring缺少对字段可以利用Aspect来补充。

### 在Spring AOP 中，关注点和横切关注的区别是什么？在spring aop 中 concern 和 cross-cutting concern 的不同之处

    关注点（concern）是应用中一个模块的行为，一个关注点可能会被定义成一个我们想实现的一个功
    能。
    横切关注点（cross-cutting concern）是一个关注点，此关注点是整个应用都会使用的功能，并影响整
    个应用，比如日志，安全和数据传输，几乎应用的每个模块都需要的功能。因此这些都属于横切关注
    点。

### Spring通知有哪些类型？

    在AOP术语中，切面的工作被称为通知，实际上是程序执行时要通过
    SpringAOP框架触发的代码段。
    Spring切面可以应用5种类型的通知：
    1. 前置通知（Before）：在目标方法被调用之前调用通知功能；
    2. 后置通知（After）：在目标方法完成之后调用通知，此时不会关心方法的输出是什么；
    3. 返回通知（After-returning ）：在目标方法成功执行之后调用通知；
    4. 异常通知（After-throwing）：在目标方法抛出异常后调用通知；
    5. 环绕通知（Around）：通知包裹了被通知的方法，在被通知的方法调用之前和调用之后执行自定
    义的行为。
    同一个aspect，不同advice的执行顺序：
    ①没有异常情况下的执行顺序：
    around before advice（环绕前置通知） before advice target method 执行 around after advice（环绕后置通知） after advice
    afterReturning

    ②有异常情况下的执行顺序： around before advice（环绕前置通知） before advice target method 执行 around afteradvice（环绕后置通知） after advice afterThrowing:异常发生 java.lang.RuntimeException: 异常发生

### 什么是切面 Aspect？

    aspect 由 pointcount 和 advice 组成，切面是通知和切点的结合。 它既包含了横切逻辑的定义, 也包括
    了连接点的定义. Spring AOP 就是负责实施切面的框架, 它将切面所定义的横切逻辑编织到切面所指定的
    连接点中.
    AOP 的工作重心在于如何将增强编织目标对象的连接点上, 这里包含两个工作:
    如何通过 pointcut 和 advice 定位到特定的 joinpoint 上
    如何在 advice 中编写切面代码.
    可以简单地认为, 使用 @Aspect 注解的类就是切面.

### 什么是 SpringMvc？
    答：SpringMvc 是 spring 的一个模块，基于 MVC 的一个框架，无需中间整合层来整合。
    Spring MVC 的优点：答：
    1）它是基于组件技术的.全部的应用对象,无论控制器和视图,还是业务对象之类的都是 java 组件.并且和
    Spring 提供的其他基础结构紧密集成. 
    2）不依赖于 Servlet API(目标虽是如此,但是在实现的时候确实是依赖于 Servlet 的) 
    3）可以任意使用各种视图技术,而不仅仅局限于 JSP 
    4）支持各种请求资源的映射策略 
    5）它应是易于扩展的
### SpringMVC 工作原理？答：

    1）客户端发送请求到 DispatcherServlet
    2）DispatcherServlet 查询 handlerMapping 找到处理请求的 Controller 
    3）Controller 调用业务逻辑后，返回 ModelAndView
    4）DispatcherServlet 查询 ModelAndView，找到指定视图 
    5）视图将结果返回到客户端
### SpringMVC 流程？答：
    1） 用户发送请求至前端控制器 DispatcherServlet。 
    2） DispatcherServlet 收到请求调用 HandlerMapping 处理器映射器。
    3） 处理器映射器找到具体的处理器(可以根据 xml 配置、注解进行查找)，生成处理器对象及处理器拦
    截器(如果有则生成)一并返回给 DispatcherServlet。 
    4） DispatcherServlet 调用 HandlerAdapter 处理器适配器。
    5） HandlerAdapter 经过适配调用具体的处理器(Controller，也叫后端控制器)。 
    6） Controller 执行完成返回 ModelAndView。 
    7） HandlerAdapter 将 controller 执行结果 ModelAndView 返回给 DispatcherServlet。 
    8） DispatcherServlet 将 ModelAndView 传给 ViewReslover 视图解析器。 
    9） ViewReslover 解析后返回具体 View。 
    10）DispatcherServlet 根据 View 进行渲染视图（即将模型数据填充至视图中）。 
    11）DispatcherServlet 响应用户

## springboot

### 什么是 Spring Boot？
    Spring Boot 是 Spring 开源组织下的子项目，是 Spring 组件一站式解决方案，主要是简化了使用Spring 的难度，简省了繁重的配置，提供了各种启动器，开发者能快速上手。
### Spring Boot 有哪些优点？
    Spring Boot 主要有如下优点：
    1. 容易上手，提升开发效率
    2. 开箱即用，远离繁琐的配置。
    3. 提供了一系列大型项目通用的非业务性功能，例如：内嵌服务器、安全管理、运行数据监控、运行状况检查和外部化配置等。
    4. 没有代码生成，也不需要XML配置。
    5. 避免大量的 Maven 导入和各种版本冲突。
### Spring Boot 的核心注解是哪个？它主要由哪几个注解组成的？
    启动类上面的注解是@SpringBootApplication，它也是 Spring Boot 的核心注解，主要组合包含了以下
    3 个注解：
    @SpringBootConfiguration：组合了 @Configuration 注解，实现配置文件的功能。
    @EnableAutoConfiguration：打开自动配置的功能，也可以关闭某个自动配置的选项，如关闭数据源
    自动配置功能： @SpringBootApplication(exclude
    = { DataSourceAutoConfiguration.class })。
    @ComponentScan：Spring组件扫描。

### Spring Boot 自动配置原理是什么？
    注解 @EnableAutoConfiguration, @Configuration, @ConditionalOnClass 就是自动配置的核心，
    @EnableAutoConfiguration 给容器导入META-INF/spring.factories 里定义的自动配置类。
    筛选有效的自动配置类。
    每一个自动配置类结合对应的 xxxProperties.java 读取配置文件进行自动配置功能
### 你如何理解 Spring Boot 配置加载顺序？
    在 Spring Boot 里面，可以使用以下几种方式来加载配置。
    1） properties文件；
    2） YAML文件；
    3） 系统环境变量；

### 什么是 YAML？

    YAML 是一种人类可读的数据序列化语言。它通常用于配置文件。

### YAML 配置的优势在哪里 ?

    YAML 现在可以算是非常流行的一种配置文件格式了，无论是前端还是后端，都可以见到 YAML 配置。
    那么 YAML 配置和传统的 properties 配置相比到底有哪些优势呢？
    1. 配置有序，在一些特殊的场景下，配置有序很关键
    2. 支持数组，数组中的元素可以是基本数据类型也可以是对象
    3. 简洁
    相比 properties 配置文件，YAML 还有一个缺点，就是不支持 @PropertySource 注解导入自定义的
    YAML 配置。
### 比较一下 Spring Security 和 Shiro 各自的优缺点 

    Shiro 和 Spring
    Security 相比，主要有如下一些特点：
    1. Spring Security 是一个重量级的安全管理框架；Shiro 则是一个轻量级
    的安全管理框架
    2. Spring Security 概念复杂，配置繁琐；Shiro 概念简单、配置简单
    3. Spring Security 功能强大；Shiro 功能简单

### Spring Boot 中如何解决跨域问题 ?

    跨域可以在前端通过 JSONP 来解决，但是 JSONP 只可以发送 GET 请求，无法发送其他类型的请求，推荐在后端通过 （CORS，Cross-origin resource
    sharing） 来解决跨域问题。这种解决方案并非 Spring Boot 特有的，在传统的 SSM 框架中，就可以通
    过 CORS 来解决跨域问题，只不过之前我们是在 XML 文件中配置 CORS ，现在可以通过实现
    WebMvcConfigurer接口然后重写addCorsMappings方法解决跨域问题。

### 项目中前后端分离部署，所以需要解决跨域的问题。

    我们使用cookie存放用户登录的信息，在spring拦截器进行权限控制，当权限不符合时，直接返回给用
    户固定的json结果。
    当用户登录以后，正常使用；当用户退出登录状态时或者token过期时，由于拦截器和跨域的顺序有问
    题，出现了跨域的现象。
    我们知道一个http请求，先走filter，到达servlet后才进行拦截器的处理，如果我们把cors放在filter里，
    就可以优先于权限拦截器执行。

### 什么是 CSRF 攻击？

    CSRF 代表跨站请求伪造。这是一种攻击，迫使 终用户在当前通过身份验证的 Web 应用程序上执行不需
    要的操作。CSRF 攻击专门针对状态改变请求，而不是数据窃取，因为攻击者无法查看对伪造请求的响
    应。

### Spring Boot比Spring做了哪些改进？

    1）Spring Boot可以建立独立的Spring应用程序；
    2）内嵌了如Tomcat，Jetty和Undertow这样的容器，也就是说可以直接跑起来，用不着再做 部署工作
    了；
    3）无需再像Spring那样搞一堆繁琐的xml文件的配置；
    4）可以自动配置Spring。SpringBoot将原有的XML配置改为Java配置，将bean注入改为使 用注解注入
    的方式(@Autowire)，并将多个xml、properties配置浓缩在一个appliaction.yml 配置文件中。
    5）提供了一些现有的功能，如量度工具，表单数据验证以及一些外部配置这样的一些第三方功 能；
    6）整合常用依赖（开发库，例如spring-webmvc、jackson-json、validation-api和tomcat 等），提供
    的POM可以简化Maven的配置。当我们引入核心依赖时，SpringBoot会自引入其 他依赖。

### 如何使用 Spring Boot 实现异常处理？

    Spring 提供了一种使用 ControllerAdvice 处理异常的非常有用的方法。 我们通过实现一个
    ControlerAdvice 类，来处理控制器类抛出的所有异常。

### 什么是 WebSockets？
    WebSocket 是一种计算机通信协议，通过单个 TCP 连接提供全双工通信信道。
    WebSocket 是双向的 -使用 WebSocket 客户端或服务器可以发起消息发送。
    WebSocket 是全双工的 -客户端和服务器通信是相互独立的。
    单个 TCP 连接 -初始连接使用 HTTP，然后将此连接升级到基于套接字的连接。然后这个单一连接用于所
    有未来的通信
    Light -与 http 相比，WebSocket 消息数据交换要轻得多


### Spring Cloud熔断机制介绍；

    在Spring Cloud框架里，熔断机制通过Hystrix实现。Hystrix会监控微服务间调用的状况，当失 败的调
    用到一定阈值，缺省是5秒内20次调用失败，就会启动熔断机制。熔断机制的注解是
    @HystrixCommand，Hystrix会找有这个注解的方法，并将这类方法关联到和熔断器连在一起 的代理
    上。当前，@HystrixCommand仅当类的注解为@Service或@Component时才会发挥 作用。

### CAP原理

    指的是在一个分布式系统中， Consistency（一致性）、 Availability（可用性）、Partition tolerance（分区容错性），三者不可得兼。

    CAP原则是NOSQL数据库的基石。

    分布式系统的CAP理论：理论首先把分布式系统中的三个特性进行了如下归纳：
    一致性（C）：在分布式系统中的所有数据备份，在同一时刻是否同样的值。（等同于所有节点访
    问同一份最新的数据副本）
    可用性（A）：在集群中一部分节点故障后，集群整体是否还能响应客户端的读写请求。（对数据
    更新具备高可用性）
    分区容忍性（P）：以实际效果而言，分区相当于对通信的时限要求。系统如果不能在时限内达成
    数据一致性，就意味着发生了分区的情况，必须就当前操作在C和A之间做出选择。
