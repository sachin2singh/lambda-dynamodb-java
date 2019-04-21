package com.aws.lambda.functions;

import com.amazonaws.services.kinesis.model.ResourceNotFoundException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.aws.lambda.dao.DynamodbProductDAO;
import com.aws.lambda.dao.ProductDAO;
import com.aws.lambda.domain.Product;
import com.aws.lambda.model.RestRequest;

/**
 * @author Sachin Singh
 **/

public class ProductHandler implements RequestHandler<RestRequest, Object> {
	
	private static final String HTTP_GET = "GET";
	
	private static final String HTTP_POST = "POST";
	
	private static final String HTTP_PUT = "PUT";
	
	private static final String HTTP_DELETE = "DELETE";
	
	private static final String SUCCESS = "SUCCESS";
	
	private static final ProductDAO productDAO = DynamodbProductDAO.instance();
   
	@Override
    public Object handleRequest(RestRequest req, Context context) {
		
		Product product = req.getProduct();
		if (req.getHttpMethod() == HTTP_PUT) {
			req.setHttpMethod(HTTP_POST);
		}
    	switch (req.getHttpMethod()) {
    		
    		case HTTP_GET :
    			return product == null || product.getId() == null ? 
    					productDAO.findAllProduct() : productDAO.findProductById(product.getId());
    			
    		case HTTP_POST:
    			if (product == null) {
    				throw new ResourceNotFoundException("invalid request, product not found : " + product);
    			}
    			productDAO.saveOrUpdateProduct(product);
    			return SUCCESS;	
    		
    		case HTTP_DELETE :
    			if (product == null) {
    				throw new ResourceNotFoundException("invalid request, product not found : " + product);
    			}
    			productDAO.deleteProduct(product);
    			return SUCCESS;			
    		
    		default :
    			throw new ResourceNotFoundException("http method not implemented : " + req.getHttpMethod());
    	}
    	
    }

}