CREATE DATABASE data_03 CHARACTER SET utf8 COLLATE utf8_general_ci;
USE data_03;
CREATE TABLE student (
   id INT(11) PRIMARY KEY,
   sname VARCHAR(10),
   age TINYINT(10),
   sex CHAR(1),
   score INT(11),
   dep_id INT(11)
);
INSERT INTO student VALUES(1,'张一',20,'男',93,1);
INSERT INTO student VALUES(2,'张二',21,'女',96,1);
INSERT INTO student VALUES(3,'张三',22,'男',85,1);
INSERT INTO student VALUES(4,'张四',23,'女',89,1);
INSERT INTO student VALUES(5,'张五',19,'男',67,1);
INSERT INTO student VALUES(6,'李一',23,'女',92,2);
INSERT INTO student VALUES(7,'李二',21,'男',97,2);
INSERT INTO student VALUES(8,'李三',20,'女',95,2);
INSERT INTO student VALUES(9,'李四',19,'男',89,2);
INSERT INTO student VALUES(10,'李五',18,'女',86,2);
INSERT INTO student VALUES(11,'王一',20,'男',63,3);
INSERT INTO student VALUES(12,'王二',22,'女',67,3);
INSERT INTO student VALUES(13,'王三',18,'男',73,3);
INSERT INTO student VALUES(14,'王四',21,'女',77,3);
INSERT INTO student VALUES(15,'王五',24,'男',92,3);

CREATE TABLE department (
   id INT(11) PRIMARY KEY,
   dname VARCHAR(10)
);

INSERT INTO department VALUES(1,"破晓一部");
INSERT INTO department VALUES(2,"鸿鹄二部");
INSERT INTO department VALUES(3,"启程三部");

