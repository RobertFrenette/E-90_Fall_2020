# Java SNS Publisher and SQS Consumer

## EC2 Config
- wget --no-check-certificate --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u141-b15/336fa29ff2bb4ef291e347e091f7f4a7/jdk-8u141-linux-x64.rpm
- sudo yum install -y jdk-8u141-linux-x64.rpm

## Execution
- Build .jar files
- Publisher: java -jar SNSPublisher.jar
- Consumer: java -jar SQSConsumer.jar
