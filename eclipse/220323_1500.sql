-- 创建员工表 yg
-- 主键id 姓名 年龄 性别 部门名称 薪水 
CREATE TABLE yg (
	id INT(10) PRIMARY KEY,
	`name` VARCHAR (10),
	`age` INT(3),
	`sex` CHAR(1),
	`dep_name` VARCHAR(5),
	`salary` DECIMAL(10,2)
) ;
-- 插入数据
INSERT INTO yg VALUES(1,'赵六',20,'男','财务部',5000),
	(2,'李四',21,'男','人事部',4000),
	(3,'张三',20,'女','开发部',10000),
	(4,'王五',22,'女','人事部',4500),
	(6,'张小红',21,'男','财务部',5600),
	(7,'刘海',28,'男','人事部',6000),
	(8,'郝开心',31,'男','开发部',12000),
	(9,'马腾腾',29,'女','人事部',5100),
	(10,'特普普',32,'男','开发部',1100),
	(11,'沈红',31,'男','测试部',9000);
-- 修改李四的部门为测试部
UPDATE yg SET `dep_name` = '财务部' WHERE `name` = '李四';
-- 修改赵六的薪水为6000，性别改为女
UPDATE yg SET `salary` = 6000,`sex` = '女' WHERE `name` = '赵六';  
-- 删除姓名为特普普的员工信息
DELETE FROM yg WHERE `name` = '特普普';
-- 查询表中年龄30岁以上的员工姓名、部门、薪水
SELECT `name`,`dep_name`,`salary` FROM yg WHERE `age` > 30;
-- 查询表中年龄在20-25之间的所有员工信息
SELECT * FROM yg WHERE `age` BETWEEN 20 AND 25;
-- 查询表中薪水高于6000且年龄在25以上
SELECT * FROM yg WHERE `salary` > 6000 AND `age` >25;

-- 查询表中姓名包含 红 的所有员工信息
SELECT * FROM yg WHERE `name` LIKE '%红%';
-- 查询表中姓名两个字的所有员工信息
SELECT * FROM yg WHERE `name` LIKE '__';
-- 查询表中姓名以 腾 结尾的所有员工信息
SELECT * FROM yg WHERE `name` LIKE '%腾';

