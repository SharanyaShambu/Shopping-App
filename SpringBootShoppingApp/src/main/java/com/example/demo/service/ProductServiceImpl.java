package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.exception.ProductNotFound;
import com.example.demo.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

	ProductRepository repository;

	@Override
	public String addProduct(Product product) {

		Product product1 = repository.save(product);
		if (product1 != null)
			return "Product Saved Successfully";
		else
			return "Failed To Save Product";
	}

	@Override
	public Product updateProduct(Product product) {

		return repository.save(product);
	}

	@Override
	public String deleteProduct(int productId) {
		repository.deleteById(productId);
		return "Product Deleted Successfully";
	}

	@Override
	public Product getProductById(int productId) throws ProductNotFound {
		Optional<Product> optional = repository.findById(productId);
		if (optional.isPresent())
			return optional.get();
		else
			throw new ProductNotFound("No Product Found with the given ID");
	}

	@Override
	public List<Product> getAllProduct() {

		return repository.findAll();
	}

	@Override
	public List<Product> getAllProductsBetween(int initalPrice, int finalPrice) {

		return repository.findByProductPriceBetween(initalPrice, finalPrice);
	}

	public List<Product> getProductByCategory(String productCategory) {
		return repository.findByProductCategory(productCategory);
	}

	public List<Product> getProductPriceLessThan(int price) {
		return repository.findByProductPriceLessThan(price);
	}

}
