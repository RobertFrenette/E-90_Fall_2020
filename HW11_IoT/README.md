# HW11 IoT

## Problem 1
Create a Thing that will represent a multisensor which transmits the following information:
- temperature
- humidity
- luminosity
- motion

![Screenshot](img/1.png?raw=true "Screenshot")

### Obtain Certs

![Screenshot](img/2.png?raw=true "Screenshot")

### Create / Attach Policy

![Screenshot](img/3.png?raw=true "Screenshot")

![Screenshot](img/4.png?raw=true "Screenshot")

### Execute ```device_pub.py``` and Subscribe to Topic

![Screenshot](img/7.png?raw=true "Screenshot")


## Problem 2

### Set up a rule that looks for any messages where the temperature is above 37 degrees, and then writes that message to an S3 bucket.

![Screenshot](img/8.png?raw=true "Screenshot")

![Screenshot](img/9.png?raw=true "Screenshot")

![Screenshot](img/10.png?raw=true "Screenshot")

### S3 Bucket contents

![Screenshot](img/11.png?raw=true "Screenshot")


### Set up a rule that looks for any message indicating motion was detected, and send out a notification through an SNS topic.

![Screenshot](img/12.png?raw=true "Screenshot")

![Screenshot](img/13.png?raw=true "Screenshot")

![Screenshot](img/14.png?raw=true "Screenshot")

![Screenshot](img/15.png?raw=true "Screenshot")

![Screenshot](img/16.png?raw=true "Screenshot")

### Email

![Screenshot](img/17.png?raw=true "Screenshot")
