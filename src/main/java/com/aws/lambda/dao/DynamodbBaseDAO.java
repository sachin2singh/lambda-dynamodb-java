package com.aws.lambda.dao;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public abstract class DynamodbBaseDAO {

    protected DynamoDBMapper mapper;

    protected DynamodbBaseDAO() {

    	AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
        mapper = new DynamoDBMapper(client);
    }

}
