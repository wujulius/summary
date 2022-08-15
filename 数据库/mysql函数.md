~~~~sql
/*下面是用select测试, 这些函数也可以用在select, update ,set ,where.from等后面*/
-- 字符串函数
SELECT SUBSTRING('我爱学习java',1,2);-- 截取函数,从1开始.
SELECT INSERT('我学习java',2,1,'爱');-- 给原有字符串在从2开始,插入1个字符串
SELECT ASCII('a');-- 对应ascii码表:0-255
SELECT LENGTH('text');-- 字符串长度
SELECT CONCAT('my','sql');-- 拼接字符串
SELECT CONCAT('80.3','5');-- 拼接字符串
SELECT LOWER('AA');-- 小写
SELECT UPPER('aa');-- 大写
SELECT LOWER(sname) FROM tab_stu;-- 查询表,sname字段都小写
-- 数字函数
SELECT BIN(2);-- 二进制转成10进制
SELECT HEX(2);-- 16进制转成10进制
SELECT FORMAT(12.3334,1);-- 格式化数字,如果后面数字为1,保留一位小数
-- 时间函数
SELECT SYSDATE(); -- 系统时间
SELECT NOW();-- 系统时间
SELECT YEAR(insert_time) FROM  product;-- 显示年份
SELECT MONTH(insert_time) FROM  product;-- 显示月份
SELECT HOUR(insert_time) FROM  product;-- 显示小时
SELECT DATEDIFF('2022-01-02','2022-01-03');-- 显示两个日期之间的间隔天数
SELECT ADDDATE('2022-01-02',1); -- 日期加一天
-- 日期格式化
select date_format(now(),'%M %d %Y')
select time_format(now(),'%H:%i %p')
-- 日期加减计算
select date_add(now(),interval 1 day);
select date_sub(now(),interval 1 day);

参考文档：[https://dev.mysql.com/doc/refman/8.0/en/date-and-time-functions.html#function_date-format]
-- 加密函数
SELECT MD5('123'); -- md5加密
SELECT PASSWORD('123');-- password加密

-- 其它函数
SELECT USER();-- 当前登录用户
SELECT DATABASE();-- 当前登录数据库
SELECT VERSION();-- 当前登录数据库版本
/*-- 设法使用字符串str 给定的名字得到一个锁， 超时为timeout 秒。
  若成功得到锁，则返回 1， 
  若操作超时则返回0 (例如,由于另一个客户端已提前封锁了这个名字 ),
  若发生错误则返回NULL (诸如缺乏记忆或线程mysqladmin kill 被断开 )。
  假如你有一个用GET_LOCK()得到的锁，当你执行RELEASE_LOCK()或你的连接断开(正常或非正常)时，这个锁就会解除。 
*/
SELECT GET_LOCK('a',1000); 
-- ifnull(字段, 数据)函数作用:如果该字段值为null,可以设置为指定的数据
-- 条件函数
select order_id,order_date,
	if(
    year(order_date)=year(now()), -- 测试条件
    'active', -- true
    'archived' -- false
  )
	from orders;
-- 多条件
select order_id,order_date,
	case
    when year(order_date)=year(now()) then 'active'
    when year(order_date)=year(now())-1 then 'last year'
    when year(order_date)<year(now())-1 then 'archived'
   	else 'future'
  end as category
	from orders;



~~~~

