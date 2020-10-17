require('dotenv').config();

var AWS = require('aws-sdk');
AWS.config.update({ region: `${process.env.REGION}` });

const MAX_MESSAGES = 1000;
let msgCounter = 0;
let oddCounter = 0;
let evenCounter = 0;

var sqs = new AWS.SQS({ apiVersion: '2012-11-05' });
var queueURL = `${process.env.QUEUE_URL}`;

var params = {
  AttributeNames: [
    "SentTimestamp"
  ],
  MaxNumberOfMessages: 10,
  MessageAttributeNames: [
    "All"
  ],
  QueueUrl: queueURL,
  VisibilityTimeout: 20,
  WaitTimeSeconds: 0
};

var consume = function() {
  sqs.receiveMessage(params, function(err, data) {
    if (err) {
      console.log("Receive Error", err);
    }
    if (data.Messages) {
      for (var i = 0; i < data.Messages.length; i++) {
        var message = data.Messages[i];
        var number = JSON.parse(message.Body);
        
        msgCounter++;

        let isOdd = number % 2 == 0 ? false : true;
        if (isOdd) {
          oddCounter++;
        } else {
          evenCounter++;
        }

        console.log("Message " + msgCounter + ". " + number + ". oddConter = " + oddCounter + ", evenCounter = " + evenCounter);

        removeFromQueue(message);
      }
      consume();
    } else {
      setTimeout(function() {
        receiveMessage()
      }, 60 * 1000);
    }
  });
};

var removeFromQueue = function(message) {
  sqs.deleteMessage({
      QueueUrl : queueURL,
      ReceiptHandle : message.ReceiptHandle
  }, function(err, data) {
      err && console.log(err);
  });
};

consume();
