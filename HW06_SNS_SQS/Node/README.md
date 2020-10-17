# Node SNS Publisher and SQS Consumer

## EC2 Config
- sudo curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.34.0/install.sh | bash
- . ~/.nvm/nvm.sh
- nvm install node

## Execution
- npm install
- Create a .env file with the following

```
REGION=YOUR_REGION_HERE
TOPIC_ARN=YOUR_TOPIC_ARN_HERE
QUEUE_URL=YOUR_QUEUE_URL_HERE
```

- Publisher: node snsPublisher
- Consumer: node sqsConsumer
