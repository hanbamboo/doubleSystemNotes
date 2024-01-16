
CREATE DATABASE data_02 CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE TABLE goods(
   id INT(11) PRIMARY KEY,
   `name` VARCHAR(20) ,
   `price` DECIMAL(10,2),
   `quality` INT(11),
   `inventory` SMALLINT(4)
);
INSERT INTO goods VALUES(1,'手机',1000.22,100,60);
INSERT INTO goods VALUES(2,'电脑',4399.132,100,60);
INSERT INTO goods VALUES(6,'手表',399.23,50,20),
			(7,'耳机',129.69,60,10);
UPDATE goods SET price = 2000 WHERE id = 2;
UPDATE goods SET price = 2000 WHERE inventory = 60 AND `name` = '手机';
DELETE FROM goods WHERE id = 2;

SELECT id,`name`,price FROM goods WHERE `name` = '耳机' ; 

SELECT * FROM goods WHERE `name` = '耳机' AND `inventory`>10; 







SELECT NAME,price,inventory FROM goods WHERE price = 2200 OR `inventory` > 30;
SELECT * FROM goods WHERE inventory <> 50;
SELECT * FROM goods WHERE inventory IS NOT NULL;

SELECT * FROM goods WHERE price > 2200 AND ( quality > 60 OR quality < 50);

SELECT * FROM goods WHERE price >2200 AND (quality >60 OR inventory <30);
SELECT * FROM goods WHERE quality BETWEEN 50 AND 70 ;
-- 匹配手前后任意字符
SELECT * FROM goods WHERE NAME LIKE '%手%';
-- 以手开头任意字符
SELECT * FROM goods WHERE NAME LIKE '手%';
-- 以手结尾任意字符
SELECT * FROM goods WHERE NAME LIKE '%手';
-- %代表任意字符。下划线代表一个字符
-- 以手结尾的两个字符2
SELECT * FROM goods WHERE NAME LIKE '_手';


