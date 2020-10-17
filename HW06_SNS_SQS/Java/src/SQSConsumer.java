import java.util.List;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;

public class SQSConsumer {
	final static int MAX_MESSAGES = 1000;
	final static String queueURL = "https://sqs.YOUR_REGION.amazonaws.com/YOUR_QUEUE_URL"; // add your Region and Queue URL
	
	public static void main(String[] args) {
		String profileName = "YOUR_PROFILE_NAME"; // add your Profile Name
		ProfileCredentialsProvider credentialsProvider  = new ProfileCredentialsProvider(profileName);

		try {
			credentialsProvider.getCredentials();
		} catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                    "Please make sure that your credentials file is at the correct " +
                    "location (~/.aws/credentials), and is in valid format.",
                    e);
		}
		
		// add your Region
        AmazonSQS sqs = AmazonSQSClientBuilder.standard()
                .withCredentials(credentialsProvider)
                .withRegion(Regions.YOUR_REGION) 
                .build();

        System.out.println("Receiving messages from Queue.\n");
        System.out.println("URL: " + queueURL);

        try {
	        int msgCounter = 0;
	        int oddCounter = 0;
	        int evenCounter = 0;
	        
	        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueURL);
	        
	        while(msgCounter < MAX_MESSAGES) {
	        	List<Message> messages = sqs.receiveMessage(receiveMessageRequest).getMessages();
	        	
	        	for (Message message: messages) {
	        		msgCounter++;
	        		int number = Integer.parseInt(message.getBody());
	        		
	        		boolean isOdd = number % 2 == 0 ? false : true;
	        		if (isOdd) {
	        			oddCounter++;
	        		} else {
	        			evenCounter++;
	        		}
	        		
	            	System.out.println("Message " + msgCounter + ". " + number + ". oddConter = " + oddCounter + ", evenCounter = " + evenCounter);
	            	String messageReciptHandle = message.getReceiptHandle();
	            	
	            	sqs.deleteMessage(new DeleteMessageRequest(queueURL, messageReciptHandle));
	        	}
	        }
		} catch (AmazonServiceException ase) {
			System.out.println("Caught an AmazonServiceException, which means the request made it to Amazon SQS " +
								"but was rejected with an error response.");
			System.out.println("Error Message: " + ase.getMessage());
			System.out.println("HTTP Status Code: " + ase.getStatusCode());
			System.out.println("AWS Error Code: " + ase.getErrorCode());
			System.out.println("Error Type: "+ ase.getErrorType());
			System.out.println("Request ID: " + ase.getRequestId());
		} catch (AmazonClientException ace) {
			System.out.println("Caught an AmazonClientException which means the client encountered a serious internal problem " + 
								"while trying to communicate with SQS.");
			System.out.println("Error Message: " + ace.getMessage());
		}
	}
}
