## mysql索引实现原理

### 常见的数据结构：
        二叉树树结构:
            定义：每个节点最多有两个子节点，值从左到右依次递增
        索引不使用二叉树的原因：
            当值依次递增插入时，最终会退化成链表，对加快查询无任何作用
        红黑树：（自平衡二叉树）：
            每个节点只能是红色或黑色
            根节点必须为黑色
            红色的节点，它的叶子节点必须为黑色
            从任意节点出发到其叶子节点的所有路径包含相同数目的黑色节点
        使用：  当插入数据时，红黑树通过旋转和变色来达到平衡，弥补二叉树退化为链表的情况
        索引不使用二叉树的原因：
            当值依次递增插入时树的高度会变得特别高，随着查询次数的提高，查询效率也会随之下降
            时间复杂度：O（log2N）
        B树：（多路平衡搜索树）
            特点：

            一个节点可以有多个元素
            叶节点具有相同的深度，叶节点的指针为空
            所有索引元素不重复
            节点中的数据索引从左到右递增排列


            问：为什么索引的数据结构不用B树？

            虽然B树相对于红黑树，树的高度降低了，但是随着数据量的增多，树的高度还是会变得很高，效率会变得特别低。而且对范围查找也不方便。
    B+树：
        特点：

            非叶子节点不存储data，只存储索引（冗余），可以放多个索引。
            叶子节点包含所有的索引字段
            叶子节点用指针连接，提高区间访问性能（注意是单向指针。）

    线程查找-性能低----》二分查找-二叉树会出现退化为链表的问题----》AVL平衡二叉树-数据变化有频繁更新节点的问题----》出现红黑树
### 索引的数据结构：
    mysql B+树
        mysql使用的是B+树，但是不完全是。对原B+树做了一些改造，例如：

        叶子节点改成双向指针，提高范围查询效率。
        忘了
    hash
        可以通过对某一值做hash运算，可以快速确定数据存放地址，查询到数据。但是缺点也很明显，不支持范围查询<>。几乎不用

        问：为什么innodb表必须有主键？

        因为innodb表的索引结构是B+树，而B+树是基于索引来存储数据的。所有的数据全部保存在B+树的叶子节点上。

        问：如果没有主键会怎么样？

        innodb引擎会查找并选择第一个没有null值的列，作为主键索引。如果没有，则会使用隐藏列作为主键。

        问：为什么推荐使用整形自增主键而不用uuid？

        优点：

        节约空间
        插入效率高（由于B+树遵循左小右大，所以自增插入数据总是在最右侧插入。而uuid则不一定，如果页16k已经写满了，那只能把页中的数据向后移，在空位中插入。频繁的移动分页会造成碎片，后续需要使用OPTIMIZE TABLE来进行碎片整理）
        问：为什么非主键索引结构叶子节点存储的是主键值？

        非主键索引存储主键值，是为了当数据变动时，不需要修改各非主键索引的值，只需修改主键索引叶子结点的数据即可。减少了重复操作，即提高性能。

## mysql索引的种类

    主要索引种类有：普通索引，唯一索引，主键索引，组合索引，全文索引，单列索引

    常用索引种类
    1、普通索引

    普通索引是最基本的索引，它没有任何限制，值可以为空；仅加速查询。可以通过以下几种方式来创建或删除：

    1）、直接创建索引

    CREATE INDEX index_name ON table(column(length))
    2）、修改表结构的方式添加索引

    ALTER TABLE table_name ADD INDEX index_name ON (column(length))
    3）、删除索引

    DROP INDEX index_name ON table
    2、唯一索引

    唯一索引与普通索引类似，不同的就是：索引列的值必须唯一，但允许有空值。如果是组合索引，则列值的组合必须唯一。简单来说：唯一索引是加速查询 + 列值唯一（可以有null）。以通过以下几种方式来创建：

    1）、创建唯一索引

    CREATE UNIQUE INDEX indexName ON table(column(length))
    2）、修改表结构

    ALTER TABLE table_name ADD UNIQUE indexName ON (column(length))
    3、主键索引

    主键索引是一种特殊的唯一索引，一个表只能有一个主键，不允许有空值。简单来说：主键索引是加速查询 + 列值唯一（不可以有null）+ 表中只有一个。

    一般是在建表的时候同时创建主键索引：

    CREATE TABLE mytable( ID INT NOT NULL, username VARCHAR(16) NOT NULL, PRIMARY KEY(ID) );
    当然也可以用 ALTER 命令。记住：一个表只能有一个主键。

    4、组合索引

    组合索引指在多个字段上创建的索引，只有在查询条件中使用了创建索引时的第一个字段，索引才会被使用。使用组合索引时遵循最左前缀集合。

    可以说：组合索引是多列值组成的一个索引，专门用于组合搜索，其效率大于索引合并。

    ALTER TABLE `table` ADD INDEX name_city_age (name,city,age);

    组合索引最左匹配原则：
        最左匹配原则是什么
            顾名思义，就是最左优先，在创建组合索引时，要根据业务需求，where子句中使用最频繁的一列放在最左边。复合索引很重要的问题是如何安排列的顺序，比如where后面用到c1, c2 这两个字段，那么索引的顺序是(c1,c2)还是(c2,c1)呢，正确的做法是，重复值越少的越放前面，比如一个列 95%的值都不重复，那么一般可以将这个列放最前面。另外，复合索引的字段数尽量不要超过 3个，一旦超过，要慎重考虑必要性。

            index(a,b,c)
            where a=3    只使用了a
            where a=3 and b=5    使用了a,b
            where a=3 and b=5 and c=4    使用了a,b,c
            where b=3 or where c=4    没有使用索引
            where a=3 and c=4    仅使用了a
            where a=3 and b>10 and c=7    使用了a,b
            where a=3 and b like 'xx%' and c=7    使用了a,b
    5、全文索引

    全文索引主要用来查找文本中的关键字，而不是直接与索引中的值相比较。fulltext索引跟其它索引大不相同，它更像是一个搜索引擎，而不是简单的where语句的参数匹配。fulltext索引配合match against操作使用，而不是一般的where语句加like。它可以在create table，alter table ，create index使用，不过目前只有char、varchar，text 列上可以创建全文索引。值得一提的是，在数据量较大时候，现将数据放入一个没有全局索引的表中，然后再用CREATE index创建fulltext索引，要比先为一张表建立fulltext然后再将数据写入的速度快很多。

    1）、创建表的适合添加全文索引

    复制代码

    CREATE TABLE `table` (

        `id` int(11) NOT NULL AUTO_INCREMENT ,

        `title` char(255) CHARACTER NOT NULL ,

        `content` text CHARACTER NULL ,

        `time` int(10) NULL DEFAULT NULL ,

        PRIMARY KEY (`id`),

        FULLTEXT (content)

    );
    复制代码

    2）、修改表结构添加全文索引

    ALTER TABLE article ADD FULLTEXT index_content(content)
    3）、直接创建索引

    CREATE FULLTEXT INDEX index_content ON article(content)
    1.添加PRIMARY KEY(主键索引)

    ALTER TABLE `table_name` ADD PRIMARY KEY ( `column` )

    2.添加UNIQUE(唯一索引)

    ALTER TABLE `table_name` ADD UNIQUE (`column`)

    3.添加INDEX(普通索引)

    ALTER TABLE `table_name` ADD INDEX index_name ( `column` )

    4.添加FULLTEXT(全文索引)

    ALTER TABLE `table_name` ADD FULLTEXT (`column`)
    
    6.单列索引：
        以表的单列字段创建的索引
#### 组合索引的abc问题
    五 : 聚合索引 ABC 问题

        1 : 聚合索引原则（和最左匹配原则相一致）
        组合索引的生效原则是
        从前往后依次使用生效，如果中间某个索引没有使用，那么断点前面的索引部分起作用，断点后面的索引没有起作用。

        在MySQL中，如果创建了复合索引(A, B, C)，就相当于创建了(A, B, C)、(A, B)和(A)三个索引，这被称为复合索弓|前导列特性，因此在创建复合索索引时应该将最常用作查询条件的列放在最左边，依次递减。

        2 : 测试表结构
        CREATE TABLE `TEST` (
        `ID` int(11) NOT NULL AUTO_INCREMENT,
        `A` varchar(30) COLLATE utf8_bin DEFAULT NULL,
        `B` varchar(30) COLLATE utf8_bin DEFAULT NULL,
        `C` varchar(30) COLLATE utf8_bin DEFAULT NULL,
        PRIMARY KEY (`ID`) USING BTREE,
        KEY `TEST_INDEX` (`A`,`B`,`C`) USING BTREE
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

        3 : 聚合索引组合顺序
        A B C 组合顺序如下
        
        A
        A B
        A C
        A B C
        A C B
        
        B
        B A
        B C
        B A C
        B C A
        
        C
        C A
        C B
        C A B
        C B A

        4 : 聚合索引测试结果
        测试结果如下所示 Y：是，N：否

            EXPLAIN select * from test t where A = 1; -- Y
            EXPLAIN select * from test t where A = 1 and B = 1; -- Y
            EXPLAIN select * from test t where A = 1 and C = 1; -- Y
            EXPLAIN select * from test t where A = 1 and B = 1 and C = 1; -- Y
            EXPLAIN select * from test t where A = 1 and C = 1 and B = 1; -- Y

            EXPLAIN select * from test t where B = 1; -- N
            EXPLAIN select * from test t where B = 1 and A = 1; -- Y
            EXPLAIN select * from test t where B = 1 and C = 1; -- N
            EXPLAIN select * from test t where B = 1 and A = 1 and C = 1; -- Y
            EXPLAIN select * from test t where B = 1 and C = 1 and A = 1; -- Y

            EXPLAIN select * from test t where C = 1; -- N
            EXPLAIN select * from test t where C = 1 and A = 1; -- Y
            EXPLAIN select * from test t where C = 1 and B = 1; -- N
            EXPLAIN select * from test t where C = 1 and A = 1 and B = 1; -- Y
            EXPLAIN select * from test t where C = 1 and B = 1 and A = 1; -- Y

            -- 其余查询方式
            EXPLAIN select * from test where A > 3; -- Y
            EXPLAIN select * from test where A = 3 order by B; -- Y
            EXPLAIN select * from test where A = 3 order by C; -- Y
            EXPLAIN select * from test where C = 3 order by A; -- N
    总结：
        1.查询的条件，Mysql会根据索引排序。
        2.由于聚合索引(A, B, C)，就相当于创建了(A, B, C)、(A, B)和(A)三个索引，所以只要条件中有(A, B, C)、(A, B)或(A)，就会走索引。

### 索引文件的目录结构

    innodb引擎结构：
        frm文件（结构文件）和ibd文件（索引+数据文件）（聚集索引）
    myisam引擎结构：
        frm文件（结构文件）和MYD文件（data数据文件）和MYI文件（index索引文件）、

    innnodb比myisam引擎少一次磁盘io操作，性能要比myisam引擎好一些

    共享表：
        在mysql目录的data目录下ibdata1文件
        优点：所有数据及索引全部存放在ibdata1文件中
        缺点：在表中做了大量删除操作，ibdata文件不会变小，表空间中会产生大量空隙。对于经常删除操作的这类应用不适合共享表
    独享表：
        在mysql目录的data目录下的某个数据库名的文件夹下，
            优点：
                可以实现单表在不同的数据库中移动

                空间可以回收（drop/truncate table方式操作表空间不能自动回收）

                不管怎么删除，表空间的碎片不会太严重的影响性能，而且还有机会处理

            缺点：单表增加比共享空间方式更大。
    