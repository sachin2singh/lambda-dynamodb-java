package com.aws.lambda.dao;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.aws.lambda.domain.Product;

public class DynamodbProductDAO extends DynamodbBaseDAO implements ProductDAO {

	private static volatile DynamodbProductDAO instance;

    private DynamodbProductDAO() { }

    public static DynamodbProductDAO instance() {

        if (instance == null) {
            synchronized(DynamodbProductDAO.class) {
                if (instance == null)
                    instance = new DynamodbProductDAO();
            }
        }
        return instance;
    }
    
    @Override
    public List<Product> findAllProduct() {
        return mapper.scan(Product.class, new DynamoDBScanExpression());
    }

	@Override
	public Product findProductById(String id) {
		return mapper.load(Product.class, id);
	}

	@Override
	public void saveOrUpdateProduct(Product product) {
		mapper.save(product);
	}

	@Override
	public void deleteProduct(Product product) {
		mapper.delete(product);
	}
	
}
