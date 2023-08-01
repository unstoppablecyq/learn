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

### 约束

### 多表查询

### 事务































