import boto3
import time

boto3.setup_default_session(profile_name='YOUR_PROFILE_NAME')

MAX_MESSAGES = 1000
msgCounter = 0
oddCounter = 0
evenCounter = 0

sqs = boto3.client('sqs', region_name='YOUR_REGION')
queue_url = 'https://sqs.YOUR_REGION.amazonaws.com/YOUR_QUEUE_URL'

while msgCounter < MAX_MESSAGES:
    response = sqs.receive_message(
        QueueUrl=queue_url,
        AttributeNames=[
            'SentTimestamp'
        ],
        MaxNumberOfMessages=1,
        MessageAttributeNames=[
            'All'
        ],
        VisibilityTimeout=0,
        WaitTimeSeconds=0
    )

    try:
        message = response['Messages'][0]
        receipt_handle = message['ReceiptHandle']

        sqs.delete_message(
            QueueUrl=queue_url,
            ReceiptHandle=receipt_handle
        )

        number = int(message['Body'])

        msgCounter += 1

        if (number % 2) == 0:
            evenCounter += 1
        else:
            oddCounter += 1

        print("Message " + str(msgCounter) + ". " + str(number) + ". oddCounter = " + str(oddCounter) + ", evenCounter = " + str(evenCounter))

    except KeyError:
        print('No Messages on the Queue')
        message = []
        time.sleep(60)
