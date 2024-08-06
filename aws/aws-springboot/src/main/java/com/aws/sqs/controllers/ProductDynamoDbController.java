package com.aws.sqs.controllers;


import com.aws.sqs.entity.Product;
import com.aws.sqs.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/db")
public class ProductDynamoDbController {
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/add")
    public Product saveProduct(@RequestBody Product product) {
        return productRepository.addProduct(product);
    }

    @GetMapping("/get/{id}")
    public Product getProduct(@PathVariable("id") String productId) {
        return productRepository.getProductById(productId);
    }

    @PutMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") String productId, @RequestBody Product product) {
        return productRepository.updateProduct(productId, product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") String productId) {
        return productRepository.deleteProductById(productId);
    }
}
