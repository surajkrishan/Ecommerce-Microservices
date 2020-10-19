package com.meru.productservice.controller;

import java.util.List;
import java.util.Optional;

import com.meru.productservice.exception.CustomMessageException;
import com.meru.productservice.model.Product;
import com.meru.productservice.service.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Api(tags = "Product")
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product req) {
		try {
			return productService.addProduct(req);
		} catch (CustomMessageException e) {
			throw new ResponseStatusException(HttpStatus.CREATED,e.getMessage());
		}
	}

	@GetMapping("/getProducts")
	public List<Product> getProducts() throws CustomMessageException{
		try {
			return productService.getProducts();
		} catch (CustomMessageException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
	}

	@GetMapping("/getProductById/{id}")
	public Optional<Product> getProductById(@PathVariable String id) {
		try {
			return productService.getProductById(id);
		} catch (CustomMessageException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
	}

	@PutMapping("/editProductById/{id}")
	public Product editProductById(@PathVariable String id, @RequestBody Product req) {
		try {
			return productService.editProductById(id, req);
		} catch (CustomMessageException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
	}

	@DeleteMapping("/deleteProductById/{id}")
	public boolean deleteProductById(@PathVariable String id) {
		try {
			return productService.deleteProductById(id);
		} catch (CustomMessageException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
	}
}
