package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

	public List<Product> findByProductPriceBetween(int totalPrice,int finalPrice );
	public List<Product> findByProductCategory(String Category);
	public List<Product> findByProductPriceLessThan(int price);
}
