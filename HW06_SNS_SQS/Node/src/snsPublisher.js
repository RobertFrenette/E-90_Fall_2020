require('dotenv').config();

var AWS = require('aws-sdk');
AWS.config.update({ region: `${process.env.REGION}` });

const LOW = 0; 
const HIGH = 100;
const DELAY = 5000;
const MAX = 1000;
let randomNumber = 0;
let counter = 1;

function publish() {
  setTimeout(function() {
    randomNumber = LOW + Math.floor(Math.random() * (HIGH - LOW)) + 1;
    console.log(`${counter}: ${randomNumber}`);

    let params = {
      Message: `${randomNumber}`,
      TopicArn: `${process.env.TOPIC_ARN}`
    };

    var publishTextPromise = new AWS.SNS({ apiVersion: '2010-03-31' }).publish(params).promise();

    publishTextPromise.then(
      function(data) {
        counter++;
        console.log(`Message ${params.Message} sent to the topic ${params.TopicArn}`);
        console.log("MessageID is " + data.MessageId);
      }).catch(
        function(err) {
          console.error(err, err.stack);
        });

    if (counter < MAX) {
      publish();
    }
  }, DELAY)
}
publish();
