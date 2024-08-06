package com.aws.sqs.service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.AmazonSQSException;
import com.amazonaws.services.sqs.model.GetQueueAttributesRequest;
import com.amazonaws.services.sqs.model.GetQueueAttributesResult;
import com.amazonaws.services.sqs.model.SetQueueAttributesRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DeadLetterQueue {


    public AmazonSQS sqs = sqsClientBuilder();
    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;
    @Value("${cloud.aws.credentials.secret-key}")
    private String secretKey;

    public void createQueue(String queueName) {
        try {
            sqs.createQueue(queueName);
        } catch (AmazonSQSException e) {
            if (!e.getErrorCode().equals("QueueAlreadyExists")) {
                throw e;
            }
        }
    }

    public String getQueueArn(String queueName) {
        String queueUrl = sqs.getQueueUrl(queueName).getQueueUrl();
        GetQueueAttributesResult queueAttrs = sqs.getQueueAttributes(new GetQueueAttributesRequest(queueUrl).withAttributeNames("QueueArn"));
        return queueAttrs.getAttributes().get("QueueArn");
    }

    public void setRedrivePolicy(String srcQueueName, String dlQueueArn) {
        String srcQueueUrl = sqs.getQueueUrl(srcQueueName).getQueueUrl();
        SetQueueAttributesRequest request = new SetQueueAttributesRequest().withQueueUrl(srcQueueUrl).addAttributesEntry("RedrivePolicy", "{\"maxReceiveCount\":\"5\", \"deadLetterTargetArn\":\"" + dlQueueArn + "\"}");
        sqs.setQueueAttributes(request);
    }

    private AWSCredentials awsCredentials() {
        AWSCredentials credentials = new BasicAWSCredentials("AKI####QUWOIYFJ7", "5DyTenHzJB3T###9dCmVgL3bvyqpeGax1DD");
        return credentials;
    }

    public AmazonSQS sqsClientBuilder() {
        AmazonSQS sqs = AmazonSQSClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCredentials())).withRegion(Regions.AP_SOUTH_1).build();
        return sqs;
    }
}
