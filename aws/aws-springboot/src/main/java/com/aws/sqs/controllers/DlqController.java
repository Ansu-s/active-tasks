package com.aws.sqs.controllers;


import com.aws.sqs.service.DeadLetterQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sqs/dlq/")
public class DlqController {

    @Autowired
    private DeadLetterQueue dlqService;

    @PostMapping("/createQueues")
    public void createQueues(@RequestParam String srcQueueName, @RequestParam String dlQueueName) {
        dlqService.createQueue(srcQueueName);
        dlqService.createQueue(dlQueueName);
        String dlQueueArn = dlqService.getQueueArn(dlQueueName);
        dlqService.setRedrivePolicy(srcQueueName, dlQueueArn);
    }
}

