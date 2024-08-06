package com.aws.sqs.service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry;
import org.springframework.stereotype.Service;

@Service
public class BatchMessaging {

    private final String queueUrl = "https://sqs.ap-south-1.amazonaws.com/017820678177/sourceQueue";

    public AmazonSQS sqs = sqsClientBuilder();

    public void sendBatchMessages() {
        SendMessageBatchRequest sendBatchRequest = new SendMessageBatchRequest().withQueueUrl(queueUrl).withEntries(new SendMessageBatchRequestEntry("msg_1", "Hello from message 1"), new SendMessageBatchRequestEntry("msg_2", "Hello from message 2"));

        sqs.sendMessageBatch(sendBatchRequest);
    }

    private AWSCredentials awsCredentials() {
        return new BasicAWSCredentials("AKIAQIJ######OIYFJ7", "5DyTenHzJB3TPqJ#####dCmVgL3bvyqpeGax1DD");
    }

    public AmazonSQS sqsClientBuilder() {
        return AmazonSQSClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCredentials())).withRegion(Regions.AP_SOUTH_1).build();
    }
}
