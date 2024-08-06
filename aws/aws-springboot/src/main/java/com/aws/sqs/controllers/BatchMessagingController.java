package com.aws.sqs.controllers;

import com.aws.sqs.service.BatchMessaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sqs")
public class BatchMessagingController {

    @Autowired
    private BatchMessaging batchMessaging;

    @PostMapping("/sendBatchMessages")
    public void sendBatchMessages() {
        batchMessaging.sendBatchMessages();
    }
}
