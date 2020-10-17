import java.util.Random;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.PublishRequest;

public class SNSPublisher {
	final static int DELAY = 5000;
	final static int MAX_VALUE = 100;
	final static int MAX_NUMBERS = 1000;
	final static String topicARN = "arn:aws:sns:YOUR_REGION:YOUR_TOPIC_ARN"; // add your Region and Topic ARN

	public static void main(String[] args) throws InterruptedException {
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
        AmazonSNS snsClient = AmazonSNSClientBuilder.standard()
                .withCredentials(credentialsProvider)
                .withRegion(Regions.YOUR_REGION) 
                .build();
        
        Random rand = new Random();
        
        int oddCounter = 0;
        int evenCounter = 0;
        
        for (int i = 0; i < MAX_NUMBERS; i++) {
        	int randomNumber = rand.nextInt(MAX_VALUE) + 1;
        	@SuppressWarnings("deprecation")
			String msg = (new Integer(randomNumber)).toString();
        	PublishRequest publishRequest = new PublishRequest(topicARN, msg);
        	snsClient.publish(publishRequest);
        	
        	boolean isOdd = randomNumber % 2 == 0 ?  false : true;
        	if (isOdd) {
        		oddCounter++;
        	} else {
        		evenCounter++;
        	}
        	
        	System.out.println("Published Message " + (i + 1) + ". " + msg + ". oddCounter = " + oddCounter + ", evenCounter = " + evenCounter);
        	Thread.sleep(DELAY);
        }
	}
}


