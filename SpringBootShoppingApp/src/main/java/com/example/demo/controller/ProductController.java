package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.exception.ProductNotFound;
import com.example.demo.service.ProductService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
	ProductService service;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@PostMapping("/save") // http://localhost:8081/products/save
	public String saveProduct(@RequestBody Product product) {
		logger.info("Received request to save product: {}", product);
		logger.info("Added product {} successfully", product);
		return service.addProduct(product);
	}

	@PutMapping("/update") // http://localhost:8081/products/update
	public Product updateProduct(@RequestBody Product product) {
		logger.info("Product {} updated successfully", product);
		return service.updateProduct(product);
	}

	@DeleteMapping("/delete/{id}") // http://localhost:8081/products/delete/123
	public String deleteProduct(@PathVariable("id") int productId) {
		logger.info("Product with id {} deleted successfully", productId);
		return service.deleteProduct(productId);
	}

	@GetMapping("/getProductById/{id}") // http://localhost:8081/products/getProductById/12
	public Product getProduct(@PathVariable("id") int productId) throws ProductNotFound {
		logger.info("Retrieved Product with productId {} successfully", productId);
		return service.getProductById(productId);
	}

	@GetMapping("/getAll") // http://localhost:8081/products/getAll
	public List<Product> getAllProducts() {
		logger.info("Retrieved all products successfully");
		return service.getAllProduct();
	}

	@GetMapping("/getBetween/{price1}/{price2}") // http://localhost:8081/products/getBetween/1000/2000
	public List<Product> getAllBetween(@PathVariable("price1") int initialPrice,
			@PathVariable("price2") int finalPrice) {
		logger.info("Retrieved products between {} and {}", initialPrice, finalPrice);
		return service.getAllProductsBetween(initialPrice, finalPrice);
	}

	@GetMapping("/getByCategory/{category}") // http://localhost:8081/products/getByCategory/Electronics
	public List<Product> getProductByCategory(@PathVariable("category") String Category) {
		logger.info("Retrieved Product with productCategory {} successfully", Category);
		return service.getProductByCategory(Category);
	}

	@GetMapping("/getProductLessThan/{price}") // http://localhost:8081/products/getProductLessThan/20000
	public List<Product> getProductLessThanPrice(@PathVariable("price") int productprice) {
		logger.info("Retrieved Product with productPrice less than {} successfully", productprice);
		return service.getProductPriceLessThan(productprice);
	}

}
