import boto3
import random
import time

boto3.setup_default_session(profile_name='YOUR_PROFILE_NAME')

LOW = 1
HIGH = 100
DELAY = 5
MAX = 1000
randomNumber = 0
counter = 0
topicArn = 'arn:aws:sns:YOUR_REGION:YOUR_TOPIC_ARN'

sns = boto3.client('sns', region_name='YOUR_REGION')

while counter < MAX:
    randomNumber = random.randrange(LOW, HIGH)

    message = sns.publish(
        TopicArn=topicArn,
        Message=str(randomNumber),
    )

    counter += 1
    print(str(counter) + ". Message " + str(randomNumber) + " sent to the topic " + topicArn)

    time.sleep(DELAY)
