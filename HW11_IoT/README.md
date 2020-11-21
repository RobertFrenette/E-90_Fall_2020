# HW11 IoT

## Problem 1
Create a Thing that will represent a multisensor which transmits the following information:
- temperature
- humidity
- luminosity
- motion

![Screenshot](img/img_1.png?raw=true "Screenshot")

### Obtain Certs

![Screenshot](img/img_2.png?raw=true "Screenshot")

### Create / Attach Policy

![Screenshot](img/img_3.png?raw=true "Screenshot")

![Screenshot](img/img_4.png?raw=true "Screenshot")

### Execute ```device_pub.py``` and Subscribe to Topic

![Screenshot](img/img_7.png?raw=true "Screenshot")


## Problem 2

### Set up a rule that looks for any messages where the temperature is above 37 degrees, and then writes that message to an S3 bucket.

![Screenshot](img/img_8.png?raw=true "Screenshot")

![Screenshot](img/img_9.png?raw=true "Screenshot")

![Screenshot](img/img_10.png?raw=true "Screenshot")

### S3 Bucket contents

![Screenshot](img/img_11.png?raw=true "Screenshot")


### Set up a rule that looks for any message indicating motion was detected, and send out a notification through an SNS topic.

![Screenshot](img/img_12.png?raw=true "Screenshot")

![Screenshot](img/img_13.png?raw=true "Screenshot")

![Screenshot](img/img_14.png?raw=true "Screenshot")

![Screenshot](img/img_15.png?raw=true "Screenshot")

![Screenshot](img/img_16.png?raw=true "Screenshot")

### Email

![Screenshot](img/img_17.png?raw=true "Screenshot")
