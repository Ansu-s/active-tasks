package com.aws.sqs.utils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AwsClients {

    @Value("${aws.access.key}")
    private String USER_ACCESS_KEY;

    @Value("${aws.secret.key}")
    private String USER_SECRET_KEY;

    @Value("${aws.sqs.queue.url}")
    private String sqsURL;

    public String produceMessageToSQS(String message) {
        AmazonSQS sqsClient = sqsClientBuilder();
        SendMessageRequest messageRequest = new SendMessageRequest(sqsURL, message);
        log.info("Sending message : "+message);
        return sqsClient.sendMessage(messageRequest).getMessageId();
    }

    public List<Message> consumeMessagesFromSQS() {
        AmazonSQS sqsClient = sqsClientBuilder();
        ReceiveMessageRequest request = new ReceiveMessageRequest(sqsURL);

        List<Message> receivedMessages = sqsClient.receiveMessage(request).getMessages();
        for (Message msg : receivedMessages) {
            log.info("Received message from SQS : " + msg);
        }
        return receivedMessages;
    }

    private AWSCredentials awsCredentials() {
        AWSCredentials credentials = new BasicAWSCredentials(USER_ACCESS_KEY, USER_SECRET_KEY);
        return credentials;
    }

    private AmazonSQS sqsClientBuilder() {
        AmazonSQS sqs = AmazonSQSClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCredentials())).withRegion(Regions.AP_SOUTH_1).build();
        return sqs;
    }
}
