## spring配置文件相关标签：
    配置扫描区域
        <context:componentScan>
                排除使用exclude
    添加配置文件：
        <context:property-palceholder>
    配置bean对象：
        <bean>
    非声明式事务开发：
        <aop:config>
            配置切点
             <aop:pointcut>
            配置切面:
            <aop:aspect>
    声明式事务开发：
        开启事务支持:
            tx:annonation-driven
## 注解配置类：
### 常见注解：
        @Bean使用在方法上，用来产生一个bean对象的方法
    javaBean注解分类:
        注册Bean：
        使用Bean:@component@Servlet@Controller@Service@Configuration(一个第三方类)@Repository
    注解事务使用：定义一个事务管理类
        再需要事务管理的类的上面加上@Transactional
            
    
