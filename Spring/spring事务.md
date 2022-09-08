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
#### 创建一个aop类来控制事务
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
