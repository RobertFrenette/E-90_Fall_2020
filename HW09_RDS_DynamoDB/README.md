# HW09 RDS, DynamoDB

## RDS

### Create a MariaDB Database Instance 
- Configure Network & Security to use default VPC, default subnet, make it not publicly accessible, create new VPC security group
- Set database name to "e90_grade_tracker"

![Screenshot](img/img_1.png?raw=true "Screenshot")


### Launch an EC2 Instance to be used as your MySql DB client

![Screenshot](img/img_2.png?raw=true "Screenshot")

EC2 User Data script for LAMP Stack

```
#!/bin/bash
yum install httpd php php-mysql mysql -y
yum update -y
chkconfig httpd on
service httpd start
echo "<?php phpinfo();?>" > /var/www/html/index.php
```

- Connect to your DB from your EC2 instance and build DB / Tables per the following

![Screenshot](img/img_3.png?raw=true "Screenshot")


```
MySQL [(none)]> source ~/ script.sql
```

![Screenshot](img/img_4.png?raw=true "Screenshot")


- Write a SQL query to list all students with late homeworks. Show the student's name, homework topic, date_submitted, and number of days the HW is late. Sort your results by the number of days the HW is late.

```
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
```

![Screenshot](img/img_5.png?raw=true "Screenshot")


## DynamoDB

### Create a NoSQL DynamoDB Database to store device info for an IOT project
- Create a table with the name "devices" with a partition key of type number named "groupID" and with a sort key of type String named "deviceType"
- Use default settings for all other options, except set both your read and write capacity to '1'.
- Initially we want to list 5 devices with just their groupID and deviceType

![Screenshot](img/img_6.png?raw=true "Screenshot")

- Add "tempValue" and "manufacturer" attributes with values

![Screenshot](img/img_7.png?raw=true "Screenshot")


### Create Secondary Index on manufacturer attribute

![Screenshot](img/img_78png?raw=true "Screenshot")


![Screenshot](img/img_9.png?raw=true "Screenshot")

