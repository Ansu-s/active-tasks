package com.aws.sqs.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@DynamoDBDocument
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @DynamoDBAttribute
    private String companyName;

    @DynamoDBAttribute
    private String companyAddress;
}
