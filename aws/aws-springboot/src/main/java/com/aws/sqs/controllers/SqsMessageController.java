package com.aws.sqs.controllers;

import com.amazonaws.services.sqs.model.Message;
import com.aws.sqs.utils.AwsClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sqs")
public class SqsMessageController {

    @Autowired
    AwsClients awsClient;

    @PostMapping("/add/{msg}")
    public String sendMessagesToSQS(@PathVariable("msg") String message) {
        return awsClient.produceMessageToSQS(message);
    }
    @GetMapping("/read")
    public List<Message> readMessagesFromSQS(){
        return awsClient.consumeMessagesFromSQS();
    }
}
