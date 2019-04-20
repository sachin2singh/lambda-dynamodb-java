package com.aws.lambda.handler;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.kinesis.model.ResourceNotFoundException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.aws.lambda.dynamodb.DynamoDBService;
import com.aws.lambda.model.Product;
import com.aws.lambda.model.RestRequest;

/**
 * @author Sachin Singh
 **/

public class ProductHandler implements RequestHandler<RestRequest, Product> {
	
	private static final String HTTP_GET_METHOD = "GET";
	
	private static final String HTTP_POST_METHOD = "POST";
   
	@Override
    public Product handleRequest(RestRequest restRequest, Context context) {
		
    	Table table = getTable();
    	switch (restRequest.getHttpMethod()) {
    		
    		case HTTP_GET_METHOD :
    			// Get our item by ID
    	        Item item = table.getItem("id", restRequest.getId());
    	        if(item == null) {
    	        	throw new ResourceNotFoundException("no record found for the id : " + restRequest.getId());
    	        }
    	        return new Product(item.getString("id"), item.getString("name"));
    		case HTTP_POST_METHOD :
    			throw new ResourceNotFoundException("POST http method not implemented : " + restRequest.getId());
    		default :
    			throw new ResourceNotFoundException("http method not implemented : " + restRequest.getId());
    	}
    	
    }

	private Table getTable() {
		DynamoDB dynamoDB = DynamoDBService.getInstance();
        // Get a reference to the Widget table
        Table table = dynamoDB.getTable("Product");
		return table;
	}
}