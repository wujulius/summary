~~~~sql
create user 用户名 identified 密码; -- 给mysql创建一个用户, 存在mysql数据库的user表
-- 主机名,	定该用户在哪个主机上可以登陆，如果是本地用户可用 localhost，如果想让该用户可以
-- 从任意远程主机登陆，可以使用通配符%
CREATE USER '用户名'@'主机名' IDENTIFIED BY '密码';
/*
权限: 
 授予用户的权限，如 CREATE、ALTER、SELECT、INSERT、UPDATE 等。如果要授
予所有的权限则使用 ALL
数据库名.表名
该用户可以操作哪个数据库的哪些表。如果要授予该用户对所有数据库和表的相应操作
权限则可用表示，如.*
*/

grant all on 数据库.表 to 用户名;-- 给用户操作数据库的授权

revoke all on 数据库.表 from 用户名;-- 取消用户的授权

drop user 用户名; -- 删除用户

SHOW GRANTS FOR '用户名'@'主机名';-- 查询权限


mysqladmin -uroot -p password 新密码; -- 未登陆 MySQL 的情况下操作，新密码不需要加上引号。

set password for '用户名'@'主机名' = password('新密码');-- root登录, 修改其它普通账号的密码

-- 操作如下
create user 'user1'@'localhost' identified by '123'; -- 123 默认被password函数加密

grant create,alter,insert,update,select on test.* to 'user1'@'localhost';

grant all on *.* to 'user2'@'%';

revoke all on test.* from 'user1'@'localhost';

drop user 'user2'@'%';

SET PASSWORD FOR 'jack'@'localhost' = PASSWORD('root');-- 登录情况下, 用root登录, 修改普通账号密码


~~~~

