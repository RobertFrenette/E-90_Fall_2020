# HW04 VPC


![Diagram](img/img_1.png?raw=true "Diagram")


## Create VPC

![Diagram](img/img_2.png?raw=true "Diagram")

![Diagram](img/img_3.png?raw=true "Diagram")


## Create Public / Private Subnets

![Diagram](img/img_4.png?raw=true "Diagram")

Note: Enable auto-assign public IPv4 address on Public Subnet

![Diagram](img/img_5.png?raw=true "Diagram")

![Diagram](img/img_6.png?raw=true "Diagram")


## Create Internet Gateway

![Diagram](img/img_7.png?raw=true "Diagram")

![Diagram](img/img_8.png?raw=true "Diagram")

- Attach to VPC

![Diagram](img/img_9.png?raw=true "Diagram")


## Create Public / Private Route Tables

![Diagram](img/img_10.png?raw=true "Diagram")

![Diagram](img/img_11.png?raw=true "Diagram")

- Configure Public Subnet Assoc

![Diagram](img/img_12.png?raw=true "Diagram")

- Configure Public Routes to IGW

![Diagram](img/img_13.png?raw=true "Diagram")


## Create EC2 Instances
- Create EC2 instance on public VPC
![Diagram](img/img_14.png?raw=true "Diagram")


- Create EC2 instance on private VPC
![Diagram](img/img_15.png?raw=true "Diagram")


### User Data script
```
#! /bin/bash
yum update -y
yum -y install httpd
service httpd start
```

![Diagram](img/img_16.png?raw=true "Diagram")


## Create NAT Gateway

![Diagram](img/img_17.png?raw=true "Diagram")

![Diagram](img/img_18.png?raw=true "Diagram")


## Assoc Private Route Table with NAT Gateway

- Add Private Subnet Assoc

![Diagram](img/img_19.png?raw=true "Diagram")


- Add Route
![Diagram](img/img_20.png?raw=true "Diagram")


## NACL

![Diagram](img/img_21.png?raw=true "Diagram")
