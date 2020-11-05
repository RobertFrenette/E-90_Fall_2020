#DROP DATABASE e90_grade_tracker;
CREATE DATABASE e90_grade_tracker;

USE e90_grade_tracker;

CREATE TABLE `students` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`name` varchar(100) NOT NULL,
	PRIMARY KEY (`id`));

CREATE TABLE `homeworks` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`student_id` bigint NOT NULL,
	`hw_topic` varchar(100) NOT NULL,
	`date_due` DATE NOT NULL,
	`date_submitted` DATE,
	PRIMARY KEY (`id`));


INSERT INTO students (name) VALUES ('Johnny Depp');
INSERT INTO students (name) VALUES ('Jennifer Aniston');
INSERT INTO students (name) VALUES ('Natalie Portman');


INSERT INTO homeworks (student_id, hw_topic, date_due, date_submitted) 
VALUES (1, 'HW1', '2018-11-10', '2018-11-09');
INSERT INTO homeworks (student_id, hw_topic, date_due, date_submitted) 
VALUES (1, 'HW2', '2018-11-10', '2018-11-09');
INSERT INTO homeworks (student_id, hw_topic, date_due, date_submitted) 
VALUES (2, 'HW1', '2018-11-10', '2018-11-10');
INSERT INTO homeworks (student_id, hw_topic, date_due, date_submitted) 
VALUES (2, 'HW2', '2018-11-10', '2018-11-14');
INSERT INTO homeworks (student_id, hw_topic, date_due, date_submitted) 
VALUES (3, 'HW1', '2018-11-10', '2018-11-12');
INSERT INTO homeworks (student_id, hw_topic, date_due, date_submitted) 
VALUES (3, 'HW2', '2018-11-10', '2018-11-11');

SELECT 
	s.name, h.hw_topic, h.date_submitted, DATEDIFF(h.date_submitted, h.date_due) 
FROM 
	students s, homeworks h 
WHERE 
	s.id = h.student_id
AND
	h.date_submitted > h.date_due 
ORDER BY 
	DATEDIFF(h.date_submitted, h.date_due);
