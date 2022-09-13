# Spring事务
    事务：
        一组不可分割的单元，要么一会执行成功，要么一起执行失败，回滚事务
        一组单元：指的是多条更新sql语句
    Spring事务的特性：
        
    事务的特性：
    acid原子性，一致性，隔离性，持久性
        通过隔离级别来避免上述问题（脏读，不可重复读，虚读）
    读问题（脏读，不可重复读，虚读）
    写问题： 
## spring处理事务的三个对象
    platformtransactionmanager：平台事务管理对象
    transactiondefinition：事务定义对象 
        定义事务的隔离级别，事务传 播行为，是否超时，是否可读可写，是否超时
    transactionstatus ：事务状态对象 事务执行情况
## spring中事务控制的三个对象
    DataSourceTransactionManager：事务管理对象
    DefaultTransactionDefinition：事务定义对象
    TransactionStatus ：事务状态对象
    
### 使用方法：
~~~~java
   TransactionStatus status =null;
    DefaultTransactionDefinition definition = null;
    DataSourceTransactionManager transactionManager = null;
//使用proceedingpoint进行环绕通知
    public void MoneyAspectProxy(ProceedingJoinPoint point) {
        try {
            //获取事务管理对象
            transactionManager =
                    new DataSourceTransactionManager();
            //设置数据库连接池
            //使用set方法
            transactionManager.setDataSource(dataSource);
            //获取事务定义对象
            definition = new DefaultTransactionDefinition();
            //设置事务定义属性
            definition.setTimeout(-1);
            //获取事务状态对象
            status = transactionManager.getTransaction(definition);
            //获取参数进行管理
            Object[] args = point.getArgs();
            System.out.println(args[0]);
            //进行方法的调用
            point.proceed(args);
            //后置通知
            transactionManager.commit(status);
        } catch (Throwable e) {
            transactionManager.rollback(status);
            throw new RuntimeException(e);
        }


    }
~~~~

##  事务控制的几种方式：
### 基于aop的半注解事务控制
#### 步骤一：搭建转账环境
~~~~java
//创建dao层
package com.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
//搭建进行数据库修改的方法
@Mapper
public interface MoneyMapper {
    @Update("update test11 set money=money-#{money} where username=#{username}")
    int updateSubMoney(@Param("username") String username, @Param("money") Double money);
    @Update("update test11 set money=money+#{money} where username=#{username}")
    int updateAddMoney(@Param("username")String username,@Param("money")Double money);
}
~~~~
~~~~java
//创建业务层接口和业务层实现类
package com.service;
public interface MoneyService {
    //定义一个转账方法
    int updateMoney(String a,String b,Double money);
}
//创建业务层实现类
package com.service.Impl;

import com.dao.MoneyMapper;
import com.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoneyServiceImpl implements MoneyService {
    //获取dao层对象
    //进行注入
    @Autowired
    private MoneyMapper moneyMapper;
    @Override
    public int updateMoney(String a, String b, Double money) {
        System.out.println(money);
        int i = moneyMapper.updateAddMoney(a, money);
        moneyMapper.updateSubMoney(b,money);
        return  i;
    }
}
~~~~
#### 步骤二：创建一个aop类来控制事务
~~~~java
package com.proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

public class MoneyAspect {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    TransactionStatus status =null;
    DefaultTransactionDefinition definition = null;
    DataSourceTransactionManager transactionManager = null;
//使用proceedingpoint进行环绕通知
    public void MoneyAspectProxy(ProceedingJoinPoint point) {
        try {
            //获取事务管理对象
            transactionManager =
                    new DataSourceTransactionManager();
            //设置数据库连接池
            //使用set方法
            transactionManager.setDataSource(dataSource);
            //获取事务定义对象
            definition = new DefaultTransactionDefinition();
            //设置事务定义属性
            definition.setTimeout(-1);
            //获取事务状态对象
            status = transactionManager.getTransaction(definition);
            //获取参数进行管理
            Object[] args = point.getArgs();
            System.out.println(args[0]);
            //进行方法的调用
            point.proceed(args);
            //后置通知
            transactionManager.commit(status);
        } catch (Throwable e) {
            transactionManager.rollback(status);
            throw new RuntimeException(e);
        }
    }
}
~~~~
#### 步骤三：配置配置文件
~~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/aop https://www.springframework.org/schema/aop/spring-aop.xsd">
<!--配置扫描位置-->
    <context:component-scan base-package="com">
    <context:exclude-filter type="annotation" expression="org.apache.ibatis.annotations.Mapper"/>
</context:component-scan>
<!--   配置druid连接池-->
    <context:property-placeholder location="druid.properties"/>
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <!--    配置druid的属性-->
        <property name="driverClassName" value="${jdbc.driverClassName}"/>
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
    </bean>
<!--    配置sqlsession工厂类对象-->
    <bean id="sqlSessionFactoryBean " class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
    </bean>
<!--    配置mybatis扫描器对象-->
<bean id="mapperScannerConfigurer " class="org.mybatis.spring.mapper.MapperScannerConfigurer">
    <property name="basePackage" value="com/dao"/>
</bean>
<!--    配置aop-->
    <!--引入切面·类-->
    <bean id="aspect" class="com.proxy.MoneyAspect">
        <property name="dataSource" ref="dataSource"/>
    </bean>
  <aop:config>
      <!--配置切点-->
      <aop:pointcut id="pt" expression="execution( * com..*.update*())"/>
      <!--配置切面-->
      <aop:aspect id="as" ref="aspect">
          <!--配置通知类-->
          <aop:around method="MoneyAspectProxy" pointcut-ref="pt"/>
      </aop:aspect>
  </aop:config>

</beans>
~~~~

#### 步骤四：创建一个测试类
~~~~java
import com.service.Impl.MoneyServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:Spring_config.xml")
public class MoneyTest {
    @Autowired
    private MoneyServiceImpl moneyService;
@Test
    public  void test1(){
        moneyService.updateMoney("zs","ls",500.0);
    }
}

~~~~
### 基于aop的半注解声明式开发
#### 相较于前者而言：
    将切面类交给xml文件执行（不用再配置文件中配置切点和切面）
    （配置事务管理器）
    在对应的service层使用Transactional进行配置相关的属性
#### 配置xml文件
~~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop" xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/aop https://www.springframework.org/schema/aop/spring-aop.xsd http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd">
    <!--配置扫描位置-->
    <context:component-scan base-package="com">
        <context:exclude-filter type="annotation" expression="org.apache.ibatis.annotations.Mapper"/>
    </context:component-scan>
    <!--   配置druid连接池-->
    <context:property-placeholder location="druid.properties"/>
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <!--    配置druid的属性-->
        <property name="driverClassName" value="${jdbc.driverClassName}"/>
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
    </bean>
    <!--    配置sqlsession工厂类对象-->
    <bean id="sqlSessionFactoryBean " class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
    </bean>
    <!--    配置mybatis扫描器对象-->
    <bean id="mapperScannerConfigurer " class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com/dao"/>
    </bean>
    <!--配置事务管理器-->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"/>
    </bean>
    <!--开启事务注解驱动支持-->
    <tx:annotation-driven transaction-manager="transactionManager"/>
</beans>
~~~~
#### 对service层进行事务配置
~~~~java
package com.service.Impl;

import com.dao.MoneyMapper;
import com.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(
        //设置属性
        //设置隔离级别
        isolation = Isolation.DEFAULT,
        //设置传播属性
        propagation = Propagation.REQUIRED,
        //设置超时
        timeout = -1,
        //设置读取方式
        readOnly = false
)
@Service
public class MoneyServiceImpl1 implements MoneyService {
    //获取dao层对象
    //进行注入
    @Autowired
    private MoneyMapper moneyMapper;

    @Override
    public int updateMoney1(String a, String b, Double money) {
        System.out.println(money);
        int i = moneyMapper.updateAddMoney(a, money);
        moneyMapper.updateSubMoney(b,money);
        return  i;
    }
}
~~~~
#### 测试类：
~~~~java
import com.service.MoneyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:Spring_config1.xml")
public class MoneyTest1 {
    @Autowired
    private MoneyService moneyService;
    @Test
    public  void test1(){
        System.out.println(moneyService);
        moneyService.updateMoney1("zs","ls",500.0);
    }
}
~~~~
#### 注意：
    使用声明式事务，在调用service层方法时使用接口来进行调用
### 全注解开发
#### 创建相应的配置类
#### 创建连接池配置
~~~~java
package com.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
@PropertySource( "classpath:druid.properties")
@Component
public class DataSourceConfig {
    @Value("${jdbc.driverClassName}")
    private String driverName="${jdbc.driverClassName}";
    @Value("${jdbc.url}")
    private String url="${jdbc.url}";
    @Value("${jdbc.username}")
    private String username="${jdbc.username}";
    @Value("${jdbc.password}")
    private String password="${jdbc.password}";
    @Bean("datasource")
    public DataSource getDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        System.out.println(driverName);
        dataSource.setDriverClassName(driverName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

}

~~~~
#### 创建mybatis配置（创建相应的sqlsession工厂Bean对象以及mapper扫描器）
~~~~java
package com.utils;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@Import(DataSourceConfig.class)
public class MybatisConfig {
    //配置sqlsession工厂bean对象
    @Bean
    public SqlSessionFactoryBean getSqlSessionFactory(@Autowired DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        return sqlSessionFactory;
    }
    //配置mapper扫描器
@Bean
    public MapperScannerConfigurer getMapperScan(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.dao");
        return mapperScannerConfigurer;
    }
}

~~~~
#### 创建事务管理器配置
~~~~java
package com.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Import(DataSourceConfig.class)
public class TransactionConnfig {
    //配置事务管理器
    @Bean
    public DataSourceTransactionManager getManager(@Autowired DataSource dataSource){
        DataSourceTransactionManager manager = new DataSourceTransactionManager(dataSource);
        return manager;
    }
}

~~~~
#### 创建spring配置总类
~~~~java
package com.utils;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@ComponentScan( value = "com",excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,pattern = "com.dao") )
@Import({MybatisConfig.class, TransactionConnfig.class})
@Configuration
@EnableTransactionManagement
public class Spring_config {

}

~~~~
#### 测试
~~~~java
import com.service.MoneyService;
import com.utils.Spring_config;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Spring_config.class)
public class MoneyTest2 {
    @Autowired
    private MoneyService moneyService;
    @Test
    public  void test1(){

        System.out.println(moneyService);
        moneyService.updateMoney1("zs","ls",500.0);
    }
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
~~~~


### 总结：
    使用事务控制的几个步骤：
    spring配置：
        定义扫描的区域
    创建连接池对象
    创建sqlsession工厂bean对象
    创建mapper扫描器
    创建事务管理器对象（）

