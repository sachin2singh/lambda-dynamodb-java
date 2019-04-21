package com.aws.lambda.model;

import com.aws.lambda.domain.Product;

public class RestRequest {
   
	private Product product;
    
    private String httpMethod;

    public RestRequest() {
    	
    }

    public RestRequest(Product product, String httpMethod) {
        this.product = product;
        this.httpMethod = httpMethod;
    }

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}
    
}
