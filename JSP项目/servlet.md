# servlet上下文对象：
    servletcontext对象：
        servletcontext对象作用范围：整个web项目
        共享：存储和删除数据操作
            相关方法：
            存储数据的方法：setAttribute（key，value）
            取出数据：getAttribute（key）
            移出数据：removeAttribute（key）

             获取项目资源路径：
            getrealPath（）获取资源文件的绝对路径
            getresourceasStream（）：获取资源文件的字节输入流

                 默认位置：maven项目（webapp根目录）
                普通项目（web根目录）
## 响应对象
### 响应头方法：（用的多）
 
#### 设置重定向： 由浏览器跳转
        方式一：
        setheader（String name，String value）
            响应头指的是name，name名字是固定的，
            name对应的value也是约定俗称的
        方式二：
        setheader（“refresh”，“6；url=”+“/index.html”）
            String  url = “”；写绝对路径
                跳转的资源在本项目可以省略域名和httpi协议
            头的名称：refresh（刷新）头的值：int second；url = 新的url地址
            作用:经过几秒跳转到新的url地址
            头的名称location头的值，新的url地址
        状态码：
            response.setstatus();
            response.setheader();
            作用：通过302状态码告诉浏览器重新跳转新的url地址

       
        content—type
        设置编码格式
        content-dispositionattachment；filename（=文件名称）
        设置浏览器下载的东西
### 响应行方法：（用途不大，服务器会自动设置）
        
        setstatus（int sc）设置状态码
        setstatus（int sc，String description）设置状态码和描述
#### 重定向的作用:
        重定向的特点：
        浏览器实现资源跳转（资源路径一定是绝对路径）
        浏览器的地址发生改变
        发送两次请求
            response.sendredirect(“http//localhost：8080/index.html”);
        浏览器行为本站不须写协议外部资源必须写协议
### 响应体的方法

#### 响应体的相关流（）
##### 字符输出流：printwriter

        reponse.setcharcaterencoding（”utf-8“）
        response.setheader()
        和上面两句效果一致
        response.setconenttype(text/html charset=utf-8)
        printwriter writer = response.getwriter();
        
##### 字节输出流：servletoutputstream
       
        servletoutputstream outputstream = response.getresourceasStreamstream();        
        获取与浏览器绑定的字节输出流：
        outputstream outputstream = response.getoutputstream();
        outputstream.write("sss".getbytes());
        outputstream.write("abc中文".getbytes("utf
        -8'))
        设置服务器端的编码格式
        设置浏览器编码格式：（通过响应头）
        response。setheader（”content-type“，”text/html;charset=utf-8“）;
        outputstream.writer(.getbytes("utf
        -8')
##### 总结 
        响应对象获取输出流：
            结论：字节输出流或字符输出流都是与浏览器绑定
            其实输出流默认和浏览器绑定
            获取与盘文件绑定的字节输入流
            inputstream in =new fileinputstream（路径）
### 转发
        请求转发：
    指的是服务器端，通过服务器实现站内资源的跳转
    特点：
        服务器内部行为
        只能实现站内资源跳转
        浏览器的地址没有发生变化
        浏览器发送一次请求
    requestdiapatcher  d = request。getrequestdispatcher（）；转发器
    dispatcher。forward（request，response）；
    beanutils封装框架
    form表单提交数据封装到后台javabean对象
    封装原则：
    form表单name属性值 和 javabean属性名称映射
    提交所有数据为string
    beanutils在封装时，默认会将string类型转为数字类型
    其他类型不会自动转换
    string类型字符串无法直接转换为date类型，需要定义类型转化器
### javaBean对象
### 中文乱码问题






    响应对象：
        servlet
        # 响应对象：
    1.servletContext
        案例：
        统计视频网站某个电影播放次数
        分析：
        存储电影播放次数
        用户点击了该对象，对播放次数加一
        所用用户都可以使用的对象（全局对象）
        用户来第一次来--》全局对象---》独行月球
        b用户第二次来---》全局对象-----》取出次数加一
    servletcontext是一个全局对象整个web项目只有一个这样的对象，所有用户可以共享该对象
    同时也是一个域对象在一定范围内可以实现数据的共享

    关键词：作用范围：
    servletcontext对象作用范围：整个web项目
    共享：存储和删除数据操作
    相关方法：
        存储数据的方法：setAttribute（key，value）
        取出数据：getAttribute（key）
        移出数据：removeAttribute（key）
    servletcontext对象：
        获取项目资源路径：
            getrealPath（）获取资源文件的绝对路径
            getresourceasStream（）：获取资源文件的字节输入流
        默认位置：maven项目（webapp根目录）
                普通项目（web根目录）
        
    获取servlet对象：
    根据servletoconfig（servlet配置对象servlet配置信息）
    this.getservletconfig()this.getservletcontext()
    String  movieName = request,getparameter("name的值")
    long count  = （long ）context。getAttribute（“count”）
    if(count != null){
        long num = count，intvalue（）；
        num++；
        context。setAttribute（“count”，num）
        notfirst
    }
    else{
        first
          context。setAttribute（“count”，1）
    }
    resp.getwriter.write(countintvalue)

    2.request

    3.response
        处理响应对象：(tomcat服务器创建)（请求对象和响应对象）
            响应过程：服务器到浏览器的过程，涉及的数据用响应对象处理
        体系结构：

        一个完整的请求和响应过程

    响应行相关方法：（用途不大，服务器会自动设置）
        setstatus（int sc）设置状态码
        setstatus（int sc，String description）设置状态码和描述
    响应头方法：（用的多）
        设置重定向：
        setheader（String name，String value）响应头指的时name，name名字是固定的，
        name对应的value也是约定俗称的
        String  url = “”；写绝对路径
        跳转的资源在本项目可以省略域名和httpi协议
        setheader（“refresh”，“6；url=”+“/index.html”）
        头的名称：refresh（刷新）头的值：int second；url = 新的url地址
        作用:经过几秒跳转到新的url地址
        头的名称location头的值，新的url地址
        response.setstatus();
        response.setheader();
        作用：通过302状态码告诉浏览器重新跳转新的url地址
        由浏览器跳转
        content—type
        设置编码格式
        content-dispositionattachment；filename（=文件名称）
        设置浏览器下载的东西
        
        

        设置响应头的编码格式：


    验证码案例： 
    下载案例：
        步骤一：获取下载对象的字节输入流
        String realpath = this.getservletcontext.getrealPath("/load/a.png");
    fileinputstream in = new fileinputstream(realpath);
            this.getservletcontext().getresourceasstream（）
            设置下载的响应头
            response。header（”contenet-disposition“，”attachement；filename=a.png“）
        步骤二：通过response获取字节输出流
        servletoutputstream out = response.getoutputstream
        步骤三：流的拼接
        byre[] bytes =  new byte[]
        int len= 0;
        while ((len!=)){

        }

        案例：文件下载在响应头
        中文文件乱码问题，不能用响应体的格式
        String filename= ”“；

        获取浏览器信息：
        user-agent用请求头获取浏览器信息
    javaee（gui和awt）


    根据name获取多个属性值：
    checkbox
    String[] names = getparametervalues("name的属性值")
    获取表单提交的数据：
    封装到map集合
    map<string，String[]> maps = reponse.getparametermap();
    request.getparametervalues();

    请求过程中文乱码
    get方法：
        tomcat8.5以后自动帮处理中文乱码
    post方法：
    由于浏览器发送的请求，首先经过tomcat，所以请求过程默认用tomcat服务器的编码格式




    使用方式：
    beanutils
    步骤一：
    在pom。xml文件里引用依赖
    步骤二：
    map的key：name的属性值
    如果一致，调用写方法写入bean对象

    利用所学知识，完成学生管理系统的增删改查

      


            