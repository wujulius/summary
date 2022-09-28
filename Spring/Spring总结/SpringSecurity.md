# SpringSecurity

## SpringSecurity概述

    Spring Security是spring采用AOP思想，基于servlet过滤器实现的安全框架。
    它提供了完善的认证机制和方法级的授权功能。是一款非常优秀的权限管理框架。

## SpringSecurity使用步骤

### 步骤一：实现登陆认证

### 创建一个service接口实现UserDetailsService

    目的：将服务器登陆表单提交的数据封装到userDetails中

    UserDetails中的七个参数（用户名，密码，账户状态，凭据是否过期，账户是否过期，账户是否锁定，以及账户具备的角色）

    userdetails的封装通过重写UserDetailsService方法来实现：
    通过传入username，调用相应的mapper层的数据库查询方法，将数据封装到自定义的domain中，
    
    同时通过调用相应的方法将查询出来的角色数据存放到授权list中
    （在配置文件拦截路径放行时判别（或者controller使用@secured（“角色名”）来实现权限控制））

## 代码实现：

### 步骤一：pom文件中导入对应的springsecurity依赖

~~~~xml
    <dependency>
      <groupId>org.springframework.security</groupId>
      <artifactId>spring-security-web</artifactId>
      <version>${spring.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework.security</groupId>
      <artifactId>spring-security-config</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <dependency>
      <groupId>org.springframework.security</groupId>
      <artifactId>spring-security-taglibs</artifactId>
      <version>${spring.version}</version>
    </dependency>
~~~~

### 步骤二：创建UserService实现UserDetailsService

~~~~java

public interface UserService extends UserDetailsService {
}

~~~~

#### 重写相应的方法，并将查询出来的数据封装到userDetails中

~~~~java
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.domain.User userInfo = null;
        try {
            userInfo = userMapper.findByUsername(username);
            System.out.println(userInfo);

        } catch (Exception e) {
           return null;
        }
        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getState().intValue() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));
        System.out.println(user);
        return user;
    }
}
~~~~

### 步骤三：设置相应的配置文件进行拦截，实现登陆认证，密码加密，以及访问授权功能

#### 在Web.xml文件中设置springsecurity过滤器以及扫描相应的配置文件

~~~~xml

  <!-- 然后接着是SpringSecurity必须的filter 优先配置，让SpringSecurity先加载，防止SpringSecurity拦截失效-->
  <filter>
    <filter-name>springSecurityFilterChain</filter-name>
    <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
  </filter>
  <filter-mapping>
    <filter-name>springSecurityFilterChain</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath*:application.xml,classpath:spring-security.xml</param-value>
  </context-param>

~~~~

#### 配置SpringSecurity.xml文件

~~~~xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:security="http://www.springframework.org/schema/security"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/security
    http://www.springframework.org/schema/security/spring-security.xsd">

    <security:global-method-security pre-post-annotations="enabled" jsr250-annotations="enabled" secured-annotations="enabled"></security:global-method-security>
    <!-- 配置不拦截的资源 -->
    <security:http pattern="/login.jsp" security="none"/>
    <security:http pattern="/register.jsp" security="none"/>
    <security:http pattern="/user/register.do" security="none"/>
    <security:http pattern="/failer.jsp" security="none"/>
    <security:http pattern="/css/**" security="none"/>
    <security:http pattern="/img/**" security="none"/>
    <security:http pattern="/plugins/**" security="none"/>
    <!--
    	配置具体的规则
    	auto-config="true"	不用自己编写登录的页面，框架提供默认登录页面
    	use-expressions="false"	是否使用SPEL表达式（没学习过）
    -->
    <security:http auto-config="true" use-expressions="true">
        <!-- 配置具体的拦截的规则 pattern="请求路径的规则" access="访问系统的人，必须有ROLE_USER的角色" -->
        <!--数据库有相应的用户名和密码可以进入，没有相应的角色无法进行模块的使用-->
        <security:intercept-url pattern="/**"   access= "hasAnyRole('ROLE_站长')"/>

        <!-- 定义跳转的具体的页面 -->
        <security:form-login
                login-page="/login.jsp"
                login-processing-url="/login.do"
                default-target-url="/index.jsp"
                authentication-failure-url="/failer.jsp"
                authentication-success-forward-url="/pages/main.jsp"
        />
        <security:logout
                logout-url="/logout.do"
                logout-success-url="/login.jsp"
                invalidate-session="true"/>
        <!-- 关闭跨域请求 -->
        <security:csrf disabled="true"/>
        <!-- 退出 -->
        <security:logout invalidate-session="true" logout-url="/logout.do" logout-success-url="/login.jsp"/>
    </security:http>
    <!-- 切换成数据库中的用户名和密码 -->
    <security:authentication-manager>
        <security:authentication-provider user-service-ref="userService">
            <!-- 配置加密的方式-->
            <security:password-encoder ref="encoder"/>
        </security:authentication-provider>
    </security:authentication-manager>
    <!-- 配置加密类 -->
    <bean id="encoder" class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder"/>
</beans>

~~~~
