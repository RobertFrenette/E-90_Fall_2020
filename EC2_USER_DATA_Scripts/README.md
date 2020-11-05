# EC2 Apache Server User Data Script

```
#!/bin/bash
yum update -y
yum install httpd -y
echo "Hello, World!" > /var/www/html/index.html
echo "I am Healthy!" > /var/www/html/healthcheck.html
service httpd start
chkconfig httpd start
```

# EC2 LAMP Server User Data Script

```
#!/bin/bash
yum install httpd php php-mysql mysql -y
yum update -y
chkconfig httpd on
service httpd start
echo "<?php phpinfo();?>" > /var/www/html/index.php
```

# EC2 Node Server User Data Script

```
#!/bin/bash
yum update -y
curl -o- https://raw.githubusercontent.com/creationix/nvm/v0.32.1/install.sh | bash
export NVM_DIR="$HOME/.nvm"
[ -s "$NVM_DIR/nvm.sh" ] && \. "$NVM_DIR/nvm.sh"
nvm install node
```

Note: The above will install for Root. To execute Node CMDs for ec2-user:
- ssh into ec2 Instance

```
export NVM_DIR="/.nvm" 
 [ -s "$NVM_DIR/nvm.sh" ] && \. "$NVM_DIR/nvm.sh"
node -v
```

- or modify User Data:

```
cat <<EOF >> /home/ec2-user/.bashrc
export NVM_DIR="/.nvm" 
 [ -s "$NVM_DIR/nvm.sh" ] && \. "$NVM_DIR/nvm.sh"
EOF
nvm install node
```
