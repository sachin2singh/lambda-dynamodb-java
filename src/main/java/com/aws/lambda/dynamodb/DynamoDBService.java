package com.aws.lambda.dynamodb;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

public class DynamoDBService {

	// Create a connection to DynamoDB
    private static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
    private static DynamoDB dynamoDB;
    
    public static DynamoDB getInstance () {
    	if (dynamoDB == null) {
    		dynamoDB = new DynamoDB(client);
    	}
    	return dynamoDB;
    }
}
