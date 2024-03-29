## MySQL

### 启动服务

cmd启动mysql服务：

管理员打开/关闭cmd

net start mysql80
net stop mysql80



#### 客户端连接：

MySQL自带客户端->输入密码

Windows命令行工具执行指令->mysql [-h 127.0.0.1] [-P 3306] -u -root -p  

//这里需要注意环境变量



### MySQL概念

建立在关系模型基础上，多张相互连接的二维表组成的数据库

- 用表存储数据，格式统一便于维护
- 用SQL语言操作，标准统一使用方便

#### 数据模型

数据库、表



### SQL

#### 通用语法

- 可以单行/多行书写，分号结尾
- 可以用空格/缩进来增强可读性
- 不分大小写，关键字建议用大写
- 注释：
  - 单行注释：
    - -- 注释内容
    - #注释内容（MySQL特有）
  - 多行注释：



#### SQL分类

##### DDL-Data Definition Language

数据定义语言，用来定义数据库对象(数据库、表、字段)

###### DDL-数据库操作

```mysql
#查询：
	#查询所有数据库：
SHOW DATABASES;
	#查询当前数据库
SELECT DATABASE();

#创建：
CREATE DATABASE [IF NOT EXISTS] 数据库名 [DEFAULT CHARSET 字符集] [COLLATE 排序规则];

#删除：
DROP DATABASE [IF EXISTS] 数据库名;

#使用：
USE 数据库名;
```

###### DDL-表操作-查询

```mysql
#查询当前数据库所有表
SHOW TABLES;

#查询表结构
DESC 表名;

#查询指定表的建表语句
SHOW CREATE TABLE 表明;
```

###### DDL-表操作-创建

```mysql
CREATE TABLE 表明(
	字段1 字段1类型 [COMMENT 字段1注释],
	字段2 字段2类型 [COMMENT 字段2注释],
	字段3 字段3类型 [COMMENT 字段3注释],
	...
	字段n 字段n类型 [COMMENT 字段n注释],
)[COMMENT 表注释]；
```

###### DDL-表操作-数据类型

主要分为数值类型、字符串类型、日期时间类型

**数值类型**

| 分类     | 类型         | 大小     | 有符号(SIGNED)范围                                           | 无符号(UNSIGNED)范围                                       | 描述               |
| -------- | ------------ | -------- | ------------------------------------------------------------ | ---------------------------------------------------------- | ------------------ |
| 数值类型 | TINYINT      | 1 byte   | (-128，127)                                                  | (0，255)                                                   | 小整数值           |
| 数值类型 | SMALLINT     | 2  bytes | (-32768，32767)                                              | (0，65535)                                                 | 大整数值           |
| 数值类型 | MEDIUMINT    | 3  bytes | (-8388608，8388607)                                          | (0，16777215)                                              | 大整数值           |
| 数值类型 | INT或INTEGER | 4  bytes | (-2147483648，2147483647)                                    | (0，4294967295)                                            | 大整数值           |
| 数值类型 | BIGINT       | 8  bytes | (-2^63，2^63-1)                                              | (0，2^64-1)                                                | 极大整数值         |
| 数值类型 | FLOAT        | 4  bytes | (-3.402823466 E+38，3.402823466351  E+38)                    | 0 和 (1.175494351  E-38，3.402823466 E+38)                 | 单精度浮点数值     |
| 数值类型 | DOUBLE       | 8  bytes | (-1.7976931348623157 E+308，1.7976931348623157 E+308)        | 0 和  (2.2250738585072014 E-308，1.7976931348623157 E+308) | 双精度浮点数值     |
| 数值类型 | DECIMAL      |          | 依赖于M(精度)和D(标度)的值<br />精度：一共几位；<br />标度：小数点后几位。 | 依赖于M(精度)和D(标度)的值                                 | 小数值(精确定点数) |

**字符串类型**

| 分类       | 类型       | 大小                  | 描述                                                         |
| ---------- | ---------- | --------------------- | ------------------------------------------------------------ |
| 字符串类型 | CHAR       | 0-255 bytes           | 定长字符串，char(10) -----------> 性能好	用户名  username  varchar(50) |
| 字符串类型 | VARCHAR    | 0-65535 bytes         | 变长字符串，varchar(10) ---> 性能较差（要计算占用空间大小）性别  gender  char(1) |
| 字符串类型 | TINYBLOB   | 0-255 bytes           | 不超过255个字符的二进制数据                                  |
| 字符串类型 | TINYTEXT   | 0-255 bytes           | 短文本字符串                                                 |
| 字符串类型 | BLOB       | 0-65 535 bytes        | 二进制形式的长文本数据                                       |
| 字符串类型 | TEXT       | 0-65 535 bytes        | 长文本数据                                                   |
| 字符串类型 | MEDIUMBLOB | 0-16 777 215 bytes    | 二进制形式的中等长度文本数据                                 |
| 字符串类型 | MEDIUMTEXT | 0-16 777 215 bytes    | 中等长度文本数据                                             |
| 字符串类型 | LONGBLOB   | 0-4 294 967 295 bytes | 二进制形式的极大文本数据                                     |
| 字符串类型 | LONGTEXT   | 0-4 294 967 295 bytes | 极大文本数据                                                 |

**日期时间类型**

| 分类     | 类型      | 大小 | 范围                                       | 格式                | 描述                     |
| -------- | --------- | ---- | ------------------------------------------ | ------------------- | ------------------------ |
| 日期类型 | DATE      | 3    | 1000-01-01 至  9999-12-31                  | YYYY-MM-DD          | 日期值                   |
| 日期类型 | TIME      | 3    | -838:59:59 至  838:59:59                   | HH:MM:SS            | 时间值或持续时间         |
| 日期类型 | YEAR      | 1    | 1901 至 2155                               | YYYY                | 年份值                   |
| 日期类型 | DATETIME  | 8    | 1000-01-01 00:00:00 至 9999-12-31 23:59:59 | YYYY-MM-DD HH:MM:SS | 混合日期和时间值         |
| 日期类型 | TIMESTAMP | 4    | 1970-01-01 00:00:01 至 2038-01-19 03:14:07 | YYYY-MM-DD HH:MM:SS | 混合日期和时间值，时间戳 |

```mysql
#创建员工表举例
create table emp(
	id int comment '编号',
    workno varchar(10) comment '工号',
    name varchar(10) comment '姓名',
    gendar char(1) comment '性别',
    age tinyint unsigned comment '年龄',
    idcard char(18) comment '身份证号',
    entrydate date comment '入职时间'
)comment '员工信息表';
```

###### DDL-表操作-修改

```mysql
#字段操作:
#添加字段
ALTER TABLE 表名 ADD 字段名 类型(长度) [comment 注释] [约束];
#修改数据类型
ALTER TABLE 表名 MODIFY 字段名 新数据类型(长度);
#修改字段名和字段类型
ALTER TABLE 表明 CHANGE 旧字段名 新字段名 类型(长度) [comment 注释] [约束];
#删除字段
ALTER TABLE 表名 DROP 字段名;

#表操作:
#修改表名
ALTER TABLE 表名 RENAME TO 新表明;
#删除表
DROP TABLE [IF EXISTS] 表名;
#删除指定表，并重新创建该表(数据全部被删除，表结构留下)
TRUNCATE TABLE 表名;
```

###### 图形化界面

DataGrip



##### DML--Data Manipulation Language

数据操作语言，用来对数据表中的数据进行修改

添加数据 (INSERT)

```mysql
#给指定字段添加数据
INSERT INTO 表名(字段名1,字段名2,...) VALUES (值1,值2,...);
#给全部字段添加数据
INSERT INTO 表名 VALUES (值1,值2,...);
#批量添加数据
INSERT INTO 表名(字段名1,字段名2,...) VALUES (值1,值2,...),(值1,值2,...),(值1,值2,...);
INSERT INTO 表名 VALUES (值1,值2,...),(值1,值2,...),(值1,值2,...);
-- 插入数据时指定的字段顺序需要和值的顺序一一对应，字符串和日期型数据应该包含在引号中，插入的数据大小应该在字段规定范围内。
```



修改数据 (UPDATE)

```mysql
UPDATE 表名 SET 字段名1 = 值1,字段名2 = 值2,...[WHILE 条件];
```

删除数据 (DELETE)

```mysql
DELETE FROM 表名 [WHERE 条件];
```



##### DQL--Data Query Language

数据查询语言，用来查询数据库中表的记录

查询关键字：**SELECT**

###### 语法

```mysql
编写顺序:
SELECT
	字段列表
FROM
	表名列表
WHERE
	条件列表
GROUP BY
	分组字段列表
HAVING
	分组后条件列表
ORDER BY
	排序字段列表
LIMIT
	分页参数
```

- 基本查询
- 条件查询(WHERE)
- 聚合函数(count,max,min,avg,sum)
- 分组查询(GROUP BY)
- 排序查询(ORDER BY)
- 分页查询(LIMIT)

###### 基本查询

```mysql
#1，查询多个字段
SELECT 字段1,字段2,字段3...FROM 表名;
SELECT * FROM 表名;
#2，设置别名
SELECT 字段1 [AS 别名1],字段2 [AS 别名2] ... FROM 表名;
#3，去除重复记录
SELECT DISTINCT 字段列表 FROM 表名;
```

###### 条件查询

语法：

```mysql
SELECT 字段列表 FROM 表名 WHERE 条件列表;
```

条件:

常用的比较运算符

| 比较运算符          | 功能                                     |
| ------------------- | ---------------------------------------- |
| >                   | 大于                                     |
| >=                  | 大于等于                                 |
| <                   | 小于                                     |
| <=                  | 小于等于                                 |
| =                   | 等于                                     |
| <> 或  ！=          | 不等于                                   |
| BETWEEN ... AND ... | 在某个范围之内(含最小、最大值)           |
| IN(...)             | 在in之后的列表中的值，多选一             |
| LIKE 占位符         | 模糊匹配(_匹配单个字符, %匹配任意个字符) |
| IS NULL             | 是NULL                                   |

常用的逻辑运算符如下:

| 逻辑运算符   | 功能                        |
| ------------ | --------------------------- |
| AND 或 &&    | 并且 (多个条件同时成立)     |
| OR 或  \| \| | 或者 (多个条件任意一个成立) |
| NOT 或 ！    | 非 , 不是                   |

###### 聚合函数

| 函数  | 功能     |
| ----- | -------- |
| count | 统计数量 |
| max   | 最大值   |
| min   | 最小值   |
| avg   | 平均值   |
| sum   | 求和     |

语法：

```mysql
SELECT 聚合函数(字段列表) FROM 表名;
# NULL不参与所有聚合函数运算。
```

###### 分组查询

语法：

```mysql
SELECT 字段列表 FROM 表名 [ WHERE 条件 ] GROUP BY 分组字段名 [ HAVING 分组
后过滤条件 ];
```

where和having区别

- 执行时机不同：where是分组之前进行过滤，不满足where条件，不参与分组；而having是分组 之后对结果进行过滤。
- 判断条件不同：where不能对聚合函数进行判断，而having可以。

注意：

- 分组之后，查询的字段一般为聚合函数和分组字段，查询其他字段无任何意义。
- 执行顺序: where > 聚合函数 > having。
- 支持多字段分组, 具体语法为 : group by columnA,columnB

###### 排序查询

语法:

```mysql
SELECT 字段列表 FROM 表名 ORDER BY 字段1 排序方式1 , 字段2 排序方式2;
```

排序方式：

- ASC：升序（默认值）
- DESC：降序

###### 分页查询

语法：

```mysql
SELECT 字段列表 FROM 表名 LIMIT 起始索引,查询记录数;
```

注意事项: 

- 起始索引从0开始，起始索引 = （查询页码 - 1）* 每页显示记录数。
- 分页查询是数据库的方言，不同的数据库有不同的实现，MySQL中是LIMIT。 
- 如果查询的是第一页数据，起始索引可以省略，直接简写为 limit 10。



###### 执行顺序

执行顺序：

FROM->WHERE->GROUP BY->HAVING->SELECT->ORDER BY->LIMIT



##### DCL--Data Control Language

数据控制语言，用来常见数据库用户、控制数据库的访问权限



###### 管理用户

1. 查询用户

   ```
   select * from mysql.user;
   ```

   Host代表当前用户访问的主机, 如果为localhost, 仅代表只能够在当前本机访问，是不可以 远程访问的。 User代表的是访问该数据库的用户名。在MySQL中需要通过Host和User来唯一标识一个用户。

2. 创建用户

   ```mysql
   CREATE USER '用户名'@'主机名' IDENTIFIED BY '密码';>
   
   # 主机名：localhost ->只有本机可以访问
   # 主机名：% -> 任意主机可以访问
   ```

3. 修改用户密码

   ```mysql
   ALTER USER '用户名'@'主机名' IDENTIFIED WITH mysql_native_password BY '新密码' ;
   ```

4. 删除用户

   ```mysql
   DROP USER '用户名'@'主机名' ;
   ```

主要是DBA(数据库管理员)用.



###### 权限控制

常用权限：（可以参考官网文档）

| 权限                | 说明               |
| ------------------- | ------------------ |
| ALL, ALL PRIVILEGES | 所有权限           |
| SELECT              | 查询数据           |
| INSERT              | 插入数据           |
| UPDATE              | 修改数据           |
| DLETE               | 删除数据           |
| ALTER               | 修改表             |
| DROP                | 删除数据库/表/试图 |
| CREATE              | 创建数据库/表      |

1. 查询权限

   ```mysql
   SHOW GRANTS FOR '用户名'@'主机名' ;
   ```

2. 授予权限

   ```mysql
   GRANT 权限列表 ON 数据库名.表名 TO '用户名'@'主机名';
   
   ```

3. 撤销权限

   ```mysql
   REVOKE 权限列表 ON 数据库名.表名 FROM '用户名'@'主机名';
   ```

   

注意：

- 多个权限之间要用逗号分隔
- 授权时，数据库名和库名可以使用*进行通配，代表所有。







### 函数

一段可以直接被另一段程序调用的程序或代码

MySQL中的函数主要分为以下四类： 字符串函数、数值函数、日期函数、流程函数。

#### 字符串函数

| 函数                     | 功能                                                       |
| ------------------------ | ---------------------------------------------------------- |
| CONCAT(S1,S2,...Sn)      | 字符串拼接，将S1，S2，... Sn拼接成一个字符串               |
| LOWER(str)               | 将字符串str全部转为小写                                    |
| UPPER(str)               | 将字符串str全部转为大写                                    |
| LPAD(str,n,pad)          | 左填充，用字符串pad对str的左边进行填充，达到n个字符 串长度 |
| RPAD(str,n,pad)          | 右填充，用字符串pad对str的右边进行填充，达到n个字符 串长度 |
| TRIM(str)                | 去掉字符串头部和尾部的空格                                 |
| SUBSTRING(str,start,len) | 返回从字符串str从start位置起的len个长度的字符串            |

​    

#### 数值函数

| 函数        | 功能                               |
| ----------- | ---------------------------------- |
| CEIL(x)     | 向上取整                           |
| FLOOR(x)    | 向下取整                           |
| MOD(x，y)   | 返回x/y的模                        |
| RAND()      | 返回0~1内的随机数                  |
| ROUND(x，y) | 求参数x的四舍五入的值，保留y位小数 |



#### 日期函数

| 函数                               | 功能                                               |
| ---------------------------------- | -------------------------------------------------- |
| CURDATE()                          | 返回当前日期                                       |
| CURTIME()                          | 返回当前时间                                       |
| NOW()                              | 返回当前日期和时间                                 |
| YEAR(date)                         | 获取指定date的年份                                 |
| MONTH(date)                        | 获取指定date的月份                                 |
| DAY(date)                          | 获取指定date的日期                                 |
| DATE_ADD(date, INTERVAL expr type) | 返回一个日期/时间值加上一个时间间隔expr后的 时间值 |
| DATEDIFF(date1,date2)              | 返回起始时间date1 和 结束时间date2之间的天 数      |



#### 流程函数

| 函数                                                         | 功能                                                       |
| ------------------------------------------------------------ | ---------------------------------------------------------- |
| IF(value , t , f)                                            | 如果value为true，则返回t，否则返回 f                       |
| IFNULL(value1 , value2)                                      | 如果value1不为空，返回value1，否则 返回value2              |
| CASE WHEN [ val1 ] THEN [res1] ... ELSE [ default ] END      | 如果val1为true，返回res1，... 否 则返回default默认值       |
| CASE [ expr ] WHEN [ val1 ] THEN [res1] ... ELSE [ default ] END | 如果expr的值等于val1，返回 res1，... 否则返回default默认值 |



### 约束

作用于表中字段上的规则，用于限制存储在表中的数据。 

作用：保证数据库中数据的正确、有效性和完整性。

约束的分类：（约束作用域表中字段上，可以在创建、修改表的时候添加）

| 约束                     | 描述                                                      | 关键字      |
| ------------------------ | --------------------------------------------------------- | ----------- |
| 非空约束                 | 限制该字段的数据不能为null                                | NOT NULL    |
| 唯一约束                 | 保证该字段的所有数据都是唯一、不重复的                    | UNIQUE      |
| 主键约束                 | 主键是一行数据的唯一标识，要求非空且唯一                  | PRIMARY KEY |
| 默认约束                 | 保存数据时，如果未指定该字段的值，则采用默认值            | DEFAULT     |
| 检查约束(8.0.16版本之后) | 保证字段值满足某一个条件                                  | CHECK       |
| 外键约束                 | 用来让两张表的数据之间建立连接，保证数据的一致 性和完整性 | FOREIGN KEY |

#### 外键约束

用来让两张表的数据之间建立连接，从而保证数据的一致性和完整性。

语法：

```mysql
#添加
CREATE TABLE 表名(
字段名 数据类型,
...
[CONSTRAINT] [外键名称] FOREIGN KEY (外键字段名) REFERENCES 主表 (主表列名)
);

ALTER TABLE 表名 ADD CONSTRAINT 外键名称 FOREIGN KEY (外键字段名)
REFERENCES 主表 (主表列名) ;

#删除
 ALTER TABLE 表名 DROP FOREIGN KEY 外键名称;
```



#### 删除/更新

| 行为        | 说明                                                         |
| ----------- | ------------------------------------------------------------ |
| NO ACTION   | 当在父表中删除/更新对应记录时，首先检查该记录是否有对应外键，如果有则不 允许删除/更新。 (与 RESTRICT 一致) 默认行为 |
| RESTRICT    | 当在父表中删除/更新对应记录时，首先检查该记录是否有对应外键，如果有则不 允许删除/更新。 (与 NO ACTION 一致) 默认行为 |
| CASCADE     | 当在父表中删除/更新对应记录时，首先检查该记录是否有对应外键，如果有，则 也删除/更新外键在子表中的记录。 |
| SET NULL    | 当在父表中删除对应记录时，首先检查该记录是否有对应外键，如果有则设置子表 中该外键值为null（这就要求该外键允许取null）。 |
| SET DEFAULT | 父表有变更时，子表将外键列设置成一个默认的值 (Innodb不支持)  |

语法：

```mysql
ALTER TABLE 表名 ADD CONSTRAINT 外键名称 FOREIGN KEY (外键字段) REFERENCES 主表名 (主表字段名) ON UPDATE CASCADE ON DELETE CASCADE;

// CASCADE
alter table emp add constraint fk_emp_dept_id foreign key (dept_id) references
dept(id) on update cascade on delete cascade ;

// SET NULL
alter table emp add constraint fk_emp_dept_id foreign key (dept_id) references dept(id) on update set null on delete set null ;
```





### 多表查询

#### 多表关系

##### 一对多(多对一)

案例: 部门与员工的关系 

关系: 一个部门对应多个员工，一个员工对应一个部门 

实现: 在多的一方建立外键，指向一的一方的主键

##### 多对多

案例: 学生与课程的关系 

关系: 一个学生可以选修多门课程，一门课程也可以供多个学生选择 

实现: 建立第三张中间表，中间表至少包含两个外键，分别关联两方主键

##### 一对一

案例: 用户与用户详情的关系 

关系: 一对一关系，多用于单表拆分，将一张表的基础字段放在一张表中，其他详情字段放在另 一张表中，以提升操作效率 

实现: 在任意一方加入外键，关联另外一方的主键，并且设置外键为唯一的(UNIQUE)



#### 多表查询概述

##### 概述

我们要执行多表查询，就只需要使用逗号分隔多张表即可

如： select * from emp, dept ;

消除无效的笛卡尔积：加上连接查询的条件

select * from emp , dept where emp.dept_id = dept.id;

##### 分类

###### 连接查询

- 内连接: 相当于查询A、B交集部分数据
- 外连接:
- 左外连接:查询左表所有数据，以及两张表交集部分数据
- 右外连接:查询右表所有数据，以及两张表交集部分数据
- 自连接: 当前表与自身的连接查询，自连接必须使用表别名

###### 子查询

#### 内连接

内连接查询的是两张表交集部分的数据。

内连接的语法分为两种: 隐式内连接、显式内连接。

语法结构：

```mysql
#隐式内连接
SELECT 字段列表 FROM 表1 , 表2 WHERE 条件 ... ;
#显式内连接
SELECT 字段列表 FROM 表1 [ INNER ] JOIN 表2 ON 连接条件 ...;

#一旦为表起了别名，就不能再使用表名来指定对应的字段了，此时只能够使用别名来指定字段。
```

#### 外连接

外连接分为两种，分别是：左外连接 和 右外连接。

语法结构：

```mysql
#左外连接
#左外连接相当于查询表1(左表)的所有数据，当然也包含表1和表2交集部分的数据。
SELECT 字段列表 FROM 表1 LEFT [OUTER] JOIN 表2 ON 条件 ...;

#右外连接
SELECT 字段列表 FROM 表1 RIGHT [OUTER] JOIN 表2 ON 条件 ...;
#右外连接相当于查询表2(右表)的所有数据，当然也包含表1和表2交集部分的数据。


#左外连接和右外连接是可以相互替换的，只需要调整在连接查询时SQL中，表结构的先后顺序就可以了。而我们在日常开发使用时，更偏向于左外连接。
```



#### 自连接

##### 自连接查询

是把一张表连接查询多次

语法：

```mysql
SELECT 字段列表 FROM 表A 别名A JOIN 表A 别名B ON 条件 ... ;

#对于自连接查询，可以是内连接查询，也可以是外连接查询。

#在自连接查询中，必须要为表起别名，要不然我们不清楚所指定的条件、返回的字段，到底是哪一张表的字段。
```



##### 联合查询

对于union查询，就是把多次查询的结果合并起来，形成一个新的查询结果集。

语法：

```mysql
SELECT 字段列表 FROM 表A ...
UNION [ ALL ]
SELECT 字段列表 FROM 表B ....;
```

- 对于联合查询的多张表的列数必须保持一致，字段类型也需要保持一致。 
- union all 会将全部的数据直接合并在一起，union 会对合并之后的数据去重。



#### 子查询

##### 概述

###### 概念

SQL语句中嵌套SELECT语句，称为嵌套查询，又称子查询。

```mysql
SELECT * FROM t1 WHERE column1 = ( SELECT column1 FROM t2 );
```

子查询外部的语句可以是INSERT / UPDATE / DELETE / SELECT 的任何一个。

###### 分类

根据子查询结果不同，分为：

- 标量子查询（子查询结果为单个值） 
- 列子查询(子查询结果为一列)
- 行子查询(子查询结果为一行) 
- 表子查询(子查询结果为多行多列)

根据子查询位置，分为：

- WHERE之后
- FROM之后
- SELECT之后

##### 标量子查询

子查询返回的结果是单个值（数字、字符串、日期等），最简单的形式，这种子查询称为标量子查询。 常用的操作符：= <> > >= < <=

##### 列子查询

子查询返回的结果是一列（可以是多行），这种子查询称为列子查询。 常用的操作符：IN 、NOT IN 、 ANY 、SOME 、 ALL

| 操作符 | 描述                                   |
| ------ | -------------------------------------- |
| IN     | 在指定的集合范围之内，多选一           |
| NOT IN | 不在指定的集合范围之内                 |
| ANY    | 子查询返回列表中，有任意一个满足即可   |
| SOME   | 与ANY等同，使用SOME的地方都可以使用ANY |
| ALL    | 子查询返回列表的所有值都必须满足       |

##### 行子查询

子查询返回的结果是一行（可以是多列），这种子查询称为行子查询。 常用的操作符：= 、<> 、IN 、NOT IN

##### 表子查询

子查询返回的结果是多行多列，这种子查询称为表子查询。 常用的操作符：IN



### 事务

#### 简介

事务是一组操作的集合，它是一个不可分割的工作单位，事务会把所有的操作作为一个整体一起向系 统提交或撤销操作请求，即这些操作要么同时成功，要么同时失败。

 默认MySQL的事务是自动提交的，也就是说，当执行完一条DML语句时，MySQL会立即隐 式的提交事务。

#### 操作

##### 控制事务1

```mysql
#查看/设置事务提交方式
SELECT @@autocommit ;
SET @@autocommit = 0 ;
#提交事务
COMMIT;
#回滚事务
ROLLBACK;

#注意：上述的这种方式，我们是修改了事务的自动提交行为, 把默认的自动提交修改为了手动提交, 此时我们执行的DML语句都不会提交, 需要手动的执行commit进行提交。
```

##### 控制事务2

```mysql
#开启事务
START TRANSACTION 或 BEGIN ;
#提交事务
COMMIT;
#回滚事务
ROLLBACK;
```

#### 事务四大特性（ACID）

- 原子性（Atomicity）：事务是不可分割的最小操作单元，要么全部成功，要么全部失败。 
- 一致性（Consistency）：事务完成时，必须使所有的数据都保持一致状态。
- 隔离性（Isolation）：数据库系统提供的隔离机制，保证事务在不受外部并发操作影响的独立 环境下运行。 
- 持久性（Durability）：事务一旦提交或回滚，它对数据库中的数据的改变就是永久的。

#### 并发事务控制

赃读：一个事务读到另外一个事务还没有提交的数据。

不可重复读：一个事务先后读取同一条记录，但两次读取的数据不同，称之为不可重复读。

幻读：一个事务按照条件查询数据时，没有对应的数据行，但是在插入数据时，又发现这行数据 已经存在，好像出现了 "幻影"。

#### 事务隔离级别

主要有以下几种：

| 隔离级别              | 脏读 | 不可重复读 | 幻读 |
| --------------------- | ---- | ---------- | ---- |
| Read uncommitted      | √    | √          | √    |
| Read committed        | X    | √          | √    |
| Repeatable Read(默认) | X    | X          | √    |
| Serializable          | X    | X          | X    |

**事务隔离级别越高，数据越安全，但是性能越低。**

语法：

```mysql
#查看事务隔离级别
SELECT @@TRANSACTION_ISOLATION;
#设置事务隔离几倍
SET [ SESSION | GLOBAL ] TRANSACTION ISOLATION LEVEL { READ UNCOMMITTED | READ COMMITTED | REPEATABLE READ | SERIALIZABLE }
```





















