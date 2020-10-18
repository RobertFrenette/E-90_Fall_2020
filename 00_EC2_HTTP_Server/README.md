# Simple EC2 HTTP Server User Data Script

```
#!/bin/bash
yum update -y
yum install httpd -y
echo "Hello, World!" > /var/www/html/index.html
echo "I am Healthy!" > /var/www/html/healthcheck.html
service httpd start
chkconfig httpd start
```
