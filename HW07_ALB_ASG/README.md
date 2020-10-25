# HW07 Application Load Balanacer, Auto Scaling Group

Build an Application Load Balancer to implement the following diagram:


![Diagram](img/img_1.png?raw=true "Diagram")


## Setup: Create 4 EC2 Instances hosting Apache Web Servers (in different AZs)
- us-east-1a: App1Server1; App1Server2
- us-east-1b: App2Server1; App2Server2
- Each Instance should serve index.html and healthcheck.html pages from root dir
- Each Instance should serve index.html page from /alt dir

### Sample User Data script (Modify for AppN / ServerN combinations)
```
#!/bin/bash
yum update -y
yum install httpd -y
echo "App 1, Server 1" > /var/www/html/index.html 
echo "I AM HEALTHY!" > /var/www/html/healthcheck.html
mkdir /var/www/html/alt
cd /var/www/html/alt
echo "App 1, Server 1" > index.html
service httpd start
chkconfig httpd start
```

![Screenshot](img/img_2.png?raw=true "Screenshot")

## Create ALB w/ two Target Groups

### Target Group 1
- Contains EC2 Instances in us-east-1a
- All traffic should be routed here by default

![Screenshot](img/img_3.png?raw=true "Screenshot")


### Target Group 2
- Contains EC2 Instances in us-east-1b
- All traffic with /alt in URI should be routed here

![Screenshot](img/img_4.png?raw=true "Screenshot")


### Create ALB
- Traffic should be routed correctly based on URIs
- Traffic sent to /alt should reach /alt servers, and all other traffic should reach default servers

![Screenshot](img/img_5.png?raw=true "Screenshot")

![Screenshot](img/img_6.png?raw=true "Screenshot")

#### Load Balacned Access (URIs)

![Screenshot](img/img_7.png?raw=true "Screenshot")

![Screenshot](img/img_8.png?raw=true "Screenshot")

![Screenshot](img/img_9.png?raw=true "Screenshot")


## Create ASG

### Setup: Create Launch Template
![Screenshot](img/img_10.png?raw=true "Screenshot")


### ASG
- Multiple AZs should be used
- The desired capacity of ASG should be 1 Instance
- The maximum capacity should be 4 Instances
- The healthcheck interval should be 20 seconds

![Screenshot](img/img_11.png?raw=true "Screenshot")

### Auto Instance

![Screenshot](img/img_12.png?raw=true "Screenshot")


### Create Simple Scaling Policy
- Track the average CPU utilization of Instances in CloudWatch, with the threshold set to 65%
- Have one policy set to scale out (add a single instance) when this threshold is exceeded
- Have a second policy set to scale in (remove a single instance) when utilization falls below 40%

![Screenshot](img/img_13.png?raw=true "Screenshot")


#### Apply Scaling Policies to ASG

![Screenshot](img/img_14.png?raw=true "Screenshot")


### Simulate High CPU load to trigger Auto Scaling

- SSH into Instance
```
sudo amazon-linux-extras install epel -y
sudo yum install stress -y
stress --cpu 1 --timeout 30000
```

![Screenshot](img/img_15.png?raw=true "Screenshot")

![Screenshot](img/img_16.png?raw=true "Screenshot")
