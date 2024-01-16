-- 查询学生所有成绩并按照成绩由低到高排序
SELECT * FROM student;
-- 由低到高 升序 默认
SELECT * FROM student ORDER BY score;
SELECT * FROM student ORDER BY score ASC ;
-- 由高到低 降序
SELECT * FROM student ORDER BY score DESC;
-- 查询学生表中男生的成绩
SELECT * FROM student  WHERE `sex` = '男' ORDER BY score DESC;

-- 查询学生表中成绩降序排列年龄升序排列
SELECT * FROM student ORDER BY score DESC,age ASC ;

-- 查询学生表中按照姓名排序
SELECT * FROM student ORDER BY sname ASC;

-- 查询学生表中的成绩最大值
SELECT MAX(`score`) FROM student ;
-- 可以给查询结果字段起别名，表也可以起别名，用as关键字
SELECT MAX(`score`)  AS '最大值' FROM student ;
-- 查询学生表中年龄最小值
SELECT MIN(`age`)  AS '最小值' FROM student ;
-- 查询学生表中成绩平均值
SELECT AVG(`score`)  AS '平均值' FROM student ;
-- 查询学生表中男生总成绩
SELECT SUM(`score`)  AS '男生总成绩' FROM student  WHERE `sex` = '男';
-- 查询表中多少条数据
SELECT COUNT(*)  FROM student ;


-- 将学生表当中的学生按照性别分组，统计男女每组记录数
SELECT COUNT(sex),sex FROM student GROUP BY sex;

-- 查询学生表中男女组当中大于90的记录
SELECT COUNT(*),sex FROM student  WHERE score > 90 GROUP BY sex ;
-- from -> where -> group by -> having -> where -> order by

-- 查询学生表中男女组的总成绩只要男生的
-- having 用法和where类似，但是执行顺序是不一样的
SELECT SUM(score),sex FROM student WHERE sex = '男'  GROUP BY sex  ;
SELECT SUM(score),sex FROM student GROUP BY sex HAVING sex= '男';


-- 查询学生表当中每个部门的男女数
SELECT dep_id,sex,COUNT(sex) FROM student GROUP BY dep_id,sex;

-- 内连接 分表链接
SELECT a.*,b.*FROM student AS a INNER JOIN department AS b
ON a.dep_id = b.id;

SELECT a.*,b.dname FROM student AS a INNER JOIN department AS b
ON a.dep_id = b.id;

