package com.aws.sqs.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.aws.sqs.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Product addProduct(Product product) {
        dynamoDBMapper.save(product);
        return product;
    }

    public Product getProductById(String productId) {
        return dynamoDBMapper.load(Product.class, productId);
    }

    public String deleteProductById(String productId) {
        Product product = dynamoDBMapper.load(Product.class, productId);
        dynamoDBMapper.delete(product);
        return "Product Removed " + productId;
    }

//    public String updateProduct(String productId, Product product) {
//        dynamoDBMapper.save(product,
//                new DynamoDBSaveExpression().withExpectedEntry(productId,
//                        new ExpectedAttributeValue(
//                                new AttributeValue().withS(productId))));
//        return productId;
//    }
    public String updateProduct(String productId, Product product) {
        Product existingProduct = dynamoDBMapper.load(Product.class, productId);
        if (existingProduct == null) {
            throw new RuntimeException("Product with id " + productId + " does not exist.");
        }

        DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression()
                .withExpectedEntry("productId", new ExpectedAttributeValue(new AttributeValue().withS(productId)));

        dynamoDBMapper.save(product, saveExpression);
        return productId;
    }

}
