package com.meru.productservice.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.meru.productservice.exception.CustomMessageException;
import com.meru.productservice.model.Product;
import com.meru.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    Environment env;

    public Product addProduct(Product req) throws CustomMessageException {
        Product existingProduct = productRepo.findByProductName(req.getProductName());
        if (existingProduct != null) {
            throw new CustomMessageException("product already exists in DB");
        }
        long randomId = new Date().getTime();
        String productId = Long.toString(randomId);
        req.setProductId("PRODUCT" + productId.substring(8));
        req.setProductServicePort(env.getProperty("server.port"));
        return productRepo.save(req);
    }

    public List<Product> getProducts() throws  CustomMessageException {
        List<Product> optionalProduct = productRepo.findAll();
        if (optionalProduct.isEmpty()) {
            throw new CustomMessageException("Product Not Found in DB");
        }
        return productRepo.findAll();
    }

    public Optional<Product> getProductById(String id) throws CustomMessageException {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (!optionalProduct.isPresent()) {
            throw new CustomMessageException("Product Not Found in DB");
        }
        return productRepo.findById(id);
    }

    public Product editProductById(String id, Product req) throws CustomMessageException {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (!optionalProduct.isPresent()) {
            throw new CustomMessageException("Product Not Found in DB");
        }
        req.setProductId(id);
        req.setProductServicePort(env.getProperty("server.port"));
        return productRepo.save(req);
    }

    public boolean deleteProductById(String id) throws CustomMessageException {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (!optionalProduct.isPresent()) {
            throw new CustomMessageException("Product Not Found in DB");
        }
        productRepo.deleteById(id);
        return true;
    }
}
