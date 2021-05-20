DROP TABLE IF EXISTS Profilestatus;
DROP TABLE IF EXISTS Evaluatorassigned;
DROP TABLE IF EXISTS Evaluator;
DROP TABLE IF EXISTS PROFILE;



CREATE TABLE Profile(id INT PRIMARY KEY, vendor VARCHAR(250), name VARCHAR(250),mobileno VARCHAR(250),location VARCHAR(250),experience FLOAT(2),skill1 VARCHAR(250),skill2 VARCHAR(250),date DATE);

INSERT INTO Profile (id, vendor, name, mobileno, location, experience, skill1, skill2, date) 
VALUES (1967214,'TCS', 'P1' , '1111111111','Chennai','2.00','java','angular','2021-05-10'),
	(100000, 'outside' , 'P2' , '2222222222','HYD','3.10','Angular','python','2021-05-09'),
	(1967219, 'TCS' , 'P3' , '2222222222','HYD','3.10','Angular','python','2021-05-09'),
	
	(1967215, 'TCS' , 'P10' , '2222222222','HYD','3.10','Angular','python','2021-05-09');




CREATE TABLE Evaluator(evalid INT PRIMARY KEY, evalname VARCHAR(250) , mobileno BIGINT NOT NULL, mail VARCHAR(250));
INSERT INTO Evaluator(evalid, evalname, mobileno, mail) 
VALUES (1,'Beaulah', '687339409','dixcy.ms'),
	(2, 'Paras' ,'2347944392','paras.gupta'),
	(3, 'saikumar' ,'2347944392','sai.kumar'),
	(4, 'Rohan' ,'2347944392','rohan.ahuja');
	




CREATE TABLE Evaluatorassigned(id INT PRIMARY KEY, evalname VARCHAR(250) , evalid INT);
INSERT INTO Evaluatorassigned (id,evalname,evalid) VALUES(1967219,'beauleah',1),(100000,'rohan',4);






CREATE TABLE Profilestatus(id INT PRIMARY KEY, status VARCHAR(250) , comments VARCHAR(250), evalname VARCHAR(20));
INSERT INTO Profilestatus VALUES(100000,'hired','good','rohan'),(1967219,'not hired','Too junior','beauleah');
