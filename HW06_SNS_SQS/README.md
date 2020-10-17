# HW06 SNS, SQS


![Diagram](img/img_1.png?raw=true "Diagram")


## Part I
Create a publisher in Java or Python that does the following:
- Runs for 1,000 iterations

In each iteration:
- Generate a random value between 1-100
- Publish that number to an SNS topic
- Sleeps for 5 seconds


## Part II
Create a consumer in Python or Java running on an EC2 instance that pulls messages off of the SQS Queue. For each message it receives it will identify whether the number is odd or even, and will display the current running count of odd and even numbers.


### Setup
Before running any of the Apps in this Repo:
- Ensure you have an IAM Account with Programmatic Access
- Add .aws/credentials to your EC2 Instance(s)
