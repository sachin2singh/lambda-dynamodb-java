package com.aws.lambda.model;

public class RestRequest {
   
	private String id;
    
    private String httpMethod;

    public RestRequest() {
    	
    }

    public RestRequest(String id, String httpMethod) {
        this.id = id;
        this.httpMethod = httpMethod;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}
    
}
