# HW08 IaC, CloudFormation

Create a CloudFormation template which contains an EC2 instance, and a security group. The following conditions must be met:

- The template should allow for the EC2 instance to be one of two instance types: either a t2.micro, or a t2.small. No other options should be available.
- A description should be provided explaining exactly what is in this stack.
- Stack creation should prompt for a key pair to be used for SSH access to your EC2 instance.
- The default IP address for SSH access into the EC2 instance is your laptop/desktop IP address. This is referring to the default IP address that will be displayed during the first step of stack creation.
- A simple web page should be deployed automatically with a welcome message and your name displayed. You can be as creative or as uncreative as you like.
- The output from your stack creation should display your website URL, and the description for your output should be "YOUR_NAME’s simple website stack"
- An Elastic IP address should be used with your EC2 instance.


## CloudFormation Designer Diagram

![Diagram](img/img_1.png?raw=true "Diagram")

## Screenshots

![Screenshot](img/img_2.png?raw=true "Screenshot")


![Screenshot](img/img_3.png?raw=true "Screenshot")


![Screenshot](img/img_4.png?raw=true "Screenshot")


![Screenshot](img/img_5.png?raw=true "Screenshot")


![Screenshot](img/img_6.png?raw=true "Screenshot")
