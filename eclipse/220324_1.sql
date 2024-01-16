-- 创建库data_04 
CREATE DATABASE data_04 CHARACTER SET utf8 COLLATE utf8_general_ci;
-- 创建员工表employee
CREATE TABLE employee (
	`id` INT (10) PRIMARY KEY,
	`ename` VARCHAR(10),
	`age` TINYINT(4),
	`sex` CHAR(1),
	`level` INT(1),
	`salary` DECIMAL(10,2),
	`dep_id` TINYINT(4)
);
-- 创建部门表department
CREATE TABLE department (
	`dep_id` TINYINT(4) PRIMARY KEY,
	`dep_name` VARCHAR(10)
);
-- 插入部门数据
INSERT INTO department VALUES(1,'财务部');
INSERT INTO department VALUES(2,'人事部');
INSERT INTO department VALUES(3,'开发部');
-- 插入人员数据
INSERT INTO employee VALUES(1,'张一',20,'男',1,5000,1);
INSERT INTO employee VALUES(2,'张二',21,'女',2,4500,1);
INSERT INTO employee VALUES(3,'张三',22,'男',1,5500,2);
INSERT INTO employee VALUES(4,'张四',23,'女',2,5600,2);
INSERT INTO employee VALUES(5,'张五',19,'男',2,5700,2);
INSERT INTO employee VALUES(6,'李一',23,'女',1,10000,3);
INSERT INTO employee VALUES(7,'李二',21,'男',2,8000,3);
INSERT INTO employee VALUES(8,'李三',20,'女',1,9500,2);
INSERT INTO employee VALUES(9,'李四',19,'男',1,8900,2);
INSERT INTO employee VALUES(10,'李五',18,'女',1,8600,2);
INSERT INTO employee VALUES(11,'王一',20,'男',1,6300,3);
INSERT INTO employee VALUES(12,'王二',22,'女',1,6700,3);
INSERT INTO employee VALUES(13,'王三',31,'男',1,7300,3);
INSERT INTO employee VALUES(14,'王四',21,'女',1,7700,3);
INSERT INTO employee VALUES(15,'王五',24,'男',1,9200,3);

-- 查询员工表，并按照薪水由高到低和年龄由低到高进行排序
SELECT * FROM employee ORDER BY `salary` DESC ,`age` ASC ;
-- 查询员工表中的最高薪水 ，最低薪水，总薪水，平均年龄
SELECT MAX(salary) '最高薪水',MIN(salary) '最低薪水',SUM(salary) '总薪水',AVG(age) '平均年龄' FROM employee;
-- 查询员工表中每个部门的最高薪水
SELECT MAX(salary)  '最高薪水' FROM employee GROUP BY dep_id;
-- 查询员工表中每个部门的最高薪水，部门名称
SELECT MAX(employee.salary) '最高薪水' ,department.`dep_name` '部门名称' 
FROM employee INNER JOIN department 
ON employee.dep_id=department.dep_id GROUP BY employee.dep_id ;

-- 所有薪水减一千
SELECT salary-1000 FROM employee ;

-- 查询员工表中总薪水超过30000 的部门，显示部门名称和总薪水
SELECT SUM(employee.`salary`),department.`dep_name` FROM  employee 
 INNER JOIN department  ON employee.`dep_id`=department.`dep_id` 
  GROUP BY employee.dep_id  HAVING SUM(employee.`salary`)>30000;
-- 查询员工表中每个部门不同等级的员工的平均薪水
SELECT AVG(salary),`level`,dep_id 
FROM employee GROUP BY `level`,dep_id;
-- 查询员工表中每个部门的男女员工数
SELECT COUNT(sex),sex,dep_id 
FROM employee GROUP BY sex,dep_id;
 -- 查询每位员工的姓名、年龄、部门名
SELECT a.ename,a.age,b.dep_name 
FROM employee AS a INNER JOIN department AS b 
ON a.`dep_id`=b.`dep_id`;
 -- 查询每位员工的姓名、年龄、薪水，部门名并按照薪水降序
SELECT a.ename,a.age,a.`salary`,b.dep_name 
FROM employee AS a INNER JOIN department AS b 
ON a.`dep_id`=b.`dep_id` ORDER BY a.`salary` DESC;